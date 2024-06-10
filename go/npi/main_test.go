package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMainSixOne(t *testing.T) {
	entrySixOne := []string{"Mele, Apples, Apples, Mele", "Bananes", "Mele, Apples, Apples, Pommes, Mele"}
	expectedSixOne := []string{"> Mele, Apples, Apples, Mele -> 200", "> Bananes -> 150", "> Mele, Apples, Apples, Pommes, Mele -> 150"}
	for i := range entrySixOne {
		out := RegisterFruitToCart(entrySixOne[i])
		assert.Equal(t, expectedSixOne[i], out)
	}
}

func TestMainSixTwo(t *testing.T) {
	entrySixTwo := []string{"Mele, Apples, Apples, Pommes, Mele", "Bananes"}
	expectedSixTwo := []string{"> Mele, Apples, Apples, Pommes, Mele -> 100", "> Bananes -> 250"}
	for i := range entrySixTwo {
		out := RegisterFruitToCart(entrySixTwo[i])
		assert.Equal(t, expectedSixTwo[i], out)
	}
}
