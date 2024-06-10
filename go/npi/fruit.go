package main

import "strings"

type Fruit struct {
	Name  string
	Price int
}

func NewFruit(name string, price int) Fruit {
	return Fruit{Name: name, Price: price}
}

func (fruit Fruit) IsFruitInList(fruits []Fruit) bool {
	for _, f := range fruits {
		if f == fruit {
			return true
		}
	}
	return false
}

func FindFruit(input string) Fruit {
	switch input {
	case "Pommes":
		return Fruit{Name: "Pommes", Price: 100}
	case "Mele":
		return Fruit{Name: "Mele", Price: 100}
	case "Apples":
		return Fruit{Name: "Apples", Price: 100}
	case "Bananes":
		return Fruit{Name: "Bananes", Price: 150}
	case "Cerises":
		return Fruit{Name: "Cerises", Price: 75}
	}
	return Fruit{}
}

func FindFruits(input string) []Fruit {
	fruits := []Fruit{}
	input = strings.TrimSpace(input)
	inputs := strings.Split(input, ",")
	for _, input := range inputs {
		input = strings.TrimSpace(input)
		fruits = append(fruits, FindFruit(input))
	}
	return fruits
}
