package com.example.calculatorapp


sealed class Calculator_Action {
    data class Number(val Number: Int) : Calculator_Action()
    object CLEAR : Calculator_Action()
    object DELETE : Calculator_Action()
    data class Operation(val operation: Calculator_Operation) : Calculator_Action()
    object DECIMAL: Calculator_Action()
    object CALCULATE : Calculator_Action()

}