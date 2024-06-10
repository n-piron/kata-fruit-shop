package main

func initFruitShop() *Cart {
	cart := NewCart()
	cherry := NewFruit("Cerises", 75)
	banana := NewFruit("Bananes", 150)
	apple1 := NewFruit("Pommes", 100)
	apple2 := NewFruit("Apples", 100)
	apple3 := NewFruit("Mele", 100)

	cherryDiscount := NewDiscount([]Fruit{cherry}, 20, 2)
	bananaDiscount := NewDiscount([]Fruit{banana}, 150, 2)
	appleDiscount := NewDiscount([]Fruit{apple2}, 100, 3)
	allAppleDiscount := NewDiscount([]Fruit{apple1, apple2, apple3}, 100, 4)
	allFruitsDiscount := NewDiscount([]Fruit{cherry, banana, apple1, apple2, apple3}, 200, 5)

	cart.AddDiscount(cherryDiscount)
	cart.AddDiscount(bananaDiscount)
	cart.AddDiscount(appleDiscount)
	cart.AddDiscount(allAppleDiscount)
	cart.AddDiscount(allFruitsDiscount)

	return cart
}

func RegisterFruitToCart(input string) string {
	cart := initFruitShop()
	fruits := FindFruits(input)
	for _, fruit := range fruits {
		cart.AppendFruit(fruit)
		cart.ComputeDiscount(fruit)
	}
	return cart.ShowPrice()
}
