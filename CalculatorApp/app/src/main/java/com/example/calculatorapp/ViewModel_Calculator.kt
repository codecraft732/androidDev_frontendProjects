package com.example.calculatorapp



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ViewModel_Calculator: ViewModel() {
    var state by mutableStateOf(Calculator_State())
    fun onAction(action: Calculator_Action) {
        when (action) {
        is Calculator_Action.Number -> enterNumber(action.Number)
        is Calculator_Action.Operation -> enterOperation(action.operation)
        is Calculator_Action.CLEAR -> state = Calculator_State()
        is Calculator_Action.DELETE -> Deletion()
        is Calculator_Action.DECIMAL -> enterDecimal()
        is Calculator_Action.CALCULATE -> Calculation()
        }
    }


    private fun enterOperation(operation: Calculator_Operation) {
        if (state.Number_1.isNotBlank()) {
            state = state.copy(OPERATION = operation)
        }
    }
        private fun Calculation() {
            val number1 = state.Number_1.toDoubleOrNull()
            val number2 = state.Number_2.toDoubleOrNull()
            if (number1 != null && number2 != null) {
                val result = when (state.OPERATION) {
                    is Calculator_Operation.ADD -> number1 + number2
                    is Calculator_Operation.SUBTRACT -> number1 - number2
                    is Calculator_Operation.MULTIPLY -> number1 * number2
                    is Calculator_Operation.DIVIDE -> number1 / number2
                    is Calculator_Operation.PERCENTAGE -> number1 % number2

                    null -> return
                }

                //this store result in num1 of n1+n2 or clear num2 or operation for continous calculation
                state = state.copy(
                    Number_1 = result.toString().take(15),
                    Number_2 = "",
                    OPERATION = null
                )
            }
        }


        private fun Deletion() {
            when {
                state.Number_1.isNotBlank() -> state = state.copy(
                    Number_1 = state.Number_1.dropLast(1)
                )

                state.OPERATION != null -> state = state.copy(
                    OPERATION = null
                )

                state.Number_2.isNotBlank() -> state = state.copy(
                    Number_2 = state.Number_2.dropLast(1)
                )
            }
        }


        private fun enterDecimal() {
            if (state.OPERATION == null && !state.Number_1.contains(".") && state.Number_1.isNotBlank()) {
                state = state.copy(
                    Number_1 = state.Number_1 + "."
                )
                return
            } else if (!state.Number_2.contains(".") && state.Number_2.isNotBlank()) {
                state = state.copy(
                    Number_2 = state.Number_2 + "."
                )
            }
        }

        private fun enterNumber(number: Int) {
            if (state.OPERATION == null) {
                if (state.Number_1.length >= MAX_NUM_LENGTH) {
                    return
                }
                state = state.copy(
                    Number_1 = state.Number_1 + number
                )
                return
            }
            if (state.Number_2.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                Number_2 = state.Number_2 + number
            )
        }
        companion object {
            private const val MAX_NUM_LENGTH = 12
        }
}







