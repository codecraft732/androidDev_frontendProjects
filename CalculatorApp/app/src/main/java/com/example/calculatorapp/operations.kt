package com.example.calculatorapp


sealed class Calculator_Operation(val symbol: String) {
    object ADD : Calculator_Operation("+")
    object SUBTRACT : Calculator_Operation("-")
    object MULTIPLY : Calculator_Operation("x")
    object DIVIDE : Calculator_Operation("/")
    object PERCENTAGE : Calculator_Operation("%")

}

