#![allow(dead_code)]

use std::collections::HashMap;

use fruit::Fruit;
mod fruit;
mod reduction;

struct Basket {
    amount: usize,
    fruits: HashMap<String, usize>,
}

impl Basket {
    fn new() -> Self {
        Self {
            amount: 0,
            fruits: HashMap::default(),
        }
    }

    fn add_reductions(&self) -> usize {
        // Apply the basic reductions
        let mut total_to_remove = 0;
        for fruit in reduction::get_reductions() {
            let entry = self.fruits.get(&fruit.item.to_owned());
            if entry.is_some() {
                let amount = entry.unwrap();
                total_to_remove += (*amount / fruit.amount_needed) * fruit.reduction_applied
            }
        }
        // count all the strings that are apples by filtering and adding their quantities
        let apple_count: usize = self
            .fruits
            .iter()
            .filter(|(f, _)| Fruit::from(f.as_str()) == Fruit::Pommes) // filter the fruits that are apples
            .map(|(_, c)| c) // extract the count
            .sum();
        total_to_remove += (apple_count / 4) * 100;

        // Apply the 5 fruit discount
        // count all the fruits, divide by 5 and multiply by the discount price
        total_to_remove += (self.fruits.values().fold(0, |acc, f_count| acc + f_count) / 5) * 200;
        total_to_remove
    }

    fn register_fruit_to_cart(&mut self, fruit: &str) -> String {
        fruit.split(", ").for_each(|part| {
            let f = Fruit::from(part);
            self.amount += f.price();
            // entry = get the value
            // if no value, then insert it with the default value
            // then add 1
            *self.fruits.entry(part.to_string()).or_default() += 1;
        });
        format!("{} -> {}", fruit, self.amount - self.add_reductions())
    }
}

#[cfg(test)]
mod case_6 {
    use crate::Basket;

    #[test]
    fn case_6_1() {
        let mut basket = Basket::new();
        assert_eq!(
            basket.register_fruit_to_cart("Mele, Apples, Apples, Mele"),
            "Mele, Apples, Apples, Mele -> 200"
        );
        assert_eq!(basket.register_fruit_to_cart("Bananes"), "Bananes -> 150");
        assert_eq!(
            basket.register_fruit_to_cart("Mele, Apples, Apples, Pommes, Mele"),
            "Mele, Apples, Apples, Pommes, Mele -> 150"
        );
    }
    #[test]
    fn case_6_2() {
        let mut basket = Basket::new();
        assert_eq!(
            basket.register_fruit_to_cart("Mele, Apples, Apples, Pommes, Mele"),
            "Mele, Apples, Apples, Pommes, Mele -> 100"
        );

        assert_eq!(basket.register_fruit_to_cart("Bananes"), "Bananes -> 250");
    }
}
