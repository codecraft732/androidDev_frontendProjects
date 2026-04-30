package com.example.calculatorapp


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CalculatorTheme(viewModel: ViewModel_Calculator = viewModel() ){
            val state = viewModel.state
            Calculator(
                state = state,
                onAction = { action -> viewModel.onAction(action) }
            )
}

@Composable
fun Calculator(  state: Calculator_State,
                 onAction: (Calculator_Action) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start=16.dp, end=16.dp, top=16.dp, bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier= Modifier
            .weight(1f)
            .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .border(
                    BorderStroke(
                    width = 4.dp,
                    color = Color.LightGray
                ))
                    .padding(16.dp)

            ){
                Text(text = state.Number_1 + (state.OPERATION?.symbol ?: "") + state.Number_2,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }


        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            thickness = 2.dp,
            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    onClick = {
                       onAction(Calculator_Action.CLEAR)

                    },
                    modifier = Modifier.weight(1.8f).aspectRatio(1.8f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = RoundedCornerShape(24.dp)
                ) {

                    Text(
                        text = "AC",
                        color = Color.Red,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

//                Button(
//                    onClick = {
//                    },
//                    modifier = Modifier.weight(1f).aspectRatio(1f),
//
//                    border = BorderStroke(
//                        width = 4.dp,
//                        color = Color.LightGray
//                    ),
//
//                    elevation = ButtonDefaults.buttonElevation(
//                        defaultElevation = 8.dp,
//                        pressedElevation = 5.dp,
//                    ),
//
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color.White,
//                        contentColor = Color.Black,
//                    ),
//
//                    shape = CircleShape
//                ) {
//
//                    Text(
//                        text = "( )",
//                        color = Color.Green,
//                        fontSize = 32.sp,
//                        fontWeight = FontWeight.ExtraBold
//                    )
//                }




                Button(
                    onClick = {
                        onAction(Calculator_Action.Operation(Calculator_Operation.PERCENTAGE))
                              },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "%",
                        color = Color.Blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }


                Button(
                    onClick = { onAction(Calculator_Action.Operation(Calculator_Operation.DIVIDE))},
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "/",
                        color = Color.Blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                }
            }
        }






        Box(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    onClick = { onAction(Calculator_Action.Number(7)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "7",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Button(
                    onClick = {  onAction(Calculator_Action.Number(8)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "8",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }




                Button(
                    onClick = { onAction(Calculator_Action.Number(9)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "9",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }


                Button(
                    onClick = { onAction(Calculator_Action.Operation(Calculator_Operation.MULTIPLY)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "x",
                        color = Color.Blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                }
            }
        }






        Box(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    onClick = { onAction(Calculator_Action.Number(4))  },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "4",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Button(
                    onClick = { onAction(Calculator_Action.Number(5)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "5",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }




                Button(
                    onClick = { onAction(Calculator_Action.Number(6)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "6",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }


                Button(
                    onClick = {onAction(Calculator_Action.Operation(Calculator_Operation.SUBTRACT))  },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "-",
                        color = Color.Blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                }
            }
        }






        Box(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
                verticalAlignment = Alignment.Top
            ) {
                Button(
                    onClick = {  onAction(Calculator_Action.Number(1)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "1",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Button(
                    onClick = { onAction(Calculator_Action.Number(2)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "2",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }




                Button(
                    onClick = { onAction(Calculator_Action.Number(3)) },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "3",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }


                Button(
                    onClick = {onAction(Calculator_Action.Operation(Calculator_Operation.ADD))  },
                    modifier = Modifier.weight(1f).aspectRatio(1f),

                    border = BorderStroke(
                        width = 4.dp,
                        color = Color.LightGray
                    ),

                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        pressedElevation = 5.dp,
                    ),

                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),

                    shape = CircleShape
                ) {

                    Text(
                        text = "+",
                        color = Color.Blue,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold
                    )

                }
            }
        }

    Box(modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.spacedBy(8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Button(
                onClick = { onAction(Calculator_Action.DELETE) },
                modifier = Modifier.weight(1f).aspectRatio(1f),

                border = BorderStroke(
                    width = 4.dp,
                    color = Color.LightGray
                ),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 5.dp,
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),

                shape = CircleShape
            ) {

                 Icon(
                 imageVector = Icons.Default.Backspace,
                    contentDescription = "Delete",
                     tint = Color.Gray

                )
            }

            Button(
                onClick = { onAction(Calculator_Action.Number(0)) },
                modifier = Modifier.weight(1f).aspectRatio(1f),

                border = BorderStroke(
                    width = 4.dp,
                    color = Color.LightGray
                ),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 5.dp,
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),

                shape = CircleShape
            ) {

                Text(
                    text = "0",
                    color = Color.Black,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }




            Button(
                onClick = {  onAction(Calculator_Action.DECIMAL) },
                modifier = Modifier.weight(1f).aspectRatio(1f),

                border = BorderStroke(
                    width = 4.dp,
                    color = Color.LightGray
                ),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 5.dp,
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),

                shape = CircleShape
            ) {

                Text(
                    text = ".",
                    color = Color.Black,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }


            Button(
                onClick = {  onAction(Calculator_Action.CALCULATE)  },
                modifier = Modifier.weight(1f).aspectRatio(1f),

                border = BorderStroke(
                    width = 4.dp,
                    color = Color.LightGray
                ),

                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 8.dp,
                    pressedElevation = 5.dp,
                ),

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),

                shape = CircleShape
            ) {

                Text(
                    text = "=",
                    color = Color.Black,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold
                )

            }
        }
    }
}}