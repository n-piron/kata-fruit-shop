package main

import (
	"fmt"
	"strings"
)

type Cart struct {
	Fruits     []Fruit
	Discounts  []Discount
	TotalPrice int
}

func NewCart() *Cart {
	return &Cart{}
}

func (cart *Cart) AppendFruit(fruit Fruit) {
	cart.Fruits = append(cart.Fruits, fruit)
	cart.TotalPrice += fruit.Price
}

func (cart *Cart) ShowPrice() string {
	out := ""
	for _, fruit := range cart.Fruits {
		out += fruit.Name + ", "
	}
	out = strings.TrimRight(out, ", ")
	return fmt.Sprintf("> %s -> %d", out, cart.TotalPrice)
}

func (cart *Cart) AddDiscount(disc *Discount) {
	cart.Discounts = append(cart.Discounts, *disc)
}

func (cart *Cart) ComputeDiscount(fruitItem Fruit) {
	for i, discount := range cart.Discounts {
		for _, fruit := range discount.Fruit {
			if fruitItem == fruit {
				cart.Discounts[i].IncreaseFruitCounter()
				if cart.Discounts[i].FruitCounter > 0 &&
					cart.Discounts[i].FruitCounter%cart.Discounts[i].DiscountTreshold == 0 {
					cart.Discounts[i].ApplyDiscount(cart)
				}
			}
		}
	}
}
