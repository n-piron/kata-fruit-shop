package main

type Discount struct {
	Fruit            []Fruit
	Discount         int
	FruitCounter     int
	DiscountTreshold int
}

func NewDiscount(fruits []Fruit, discount int, discountTreshold int) *Discount {
	return &Discount{Fruit: fruits, Discount: discount, DiscountTreshold: discountTreshold}
}

func (discount *Discount) IncreaseFruitCounter() {
	discount.FruitCounter++
}

func (discount *Discount) ApplyDiscount(cart *Cart) {
	cart.TotalPrice -= discount.Discount
}
