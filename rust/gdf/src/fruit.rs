#[derive(Debug, Clone, Copy, PartialEq, Eq, Hash)]
pub enum Fruit {
    Pommes,
    Cerises,
    Bananes,
}

/// Map a string litteral to a Fruit
impl From<&str> for Fruit {
    fn from(value: &str) -> Self {
        use self::Fruit::*;
        match value {
            "Pommes" | "Apples" | "Mele" => Pommes,
            "Bananes" => Bananes,
            "Cerises" => Cerises,
            &_ => unreachable!(),
        }
    }
}

impl Fruit {
    pub fn price(&self) -> usize {
        match self {
            Fruit::Pommes => 100,
            Fruit::Cerises => 75,
            Fruit::Bananes => 150,
        }
    }
}
