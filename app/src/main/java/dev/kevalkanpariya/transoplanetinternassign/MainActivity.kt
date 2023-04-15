package dev.kevalkanpariya.transoplanetinternassign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.transoplanetinternassign.ui.theme.TransoplanetInternAssignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransoplanetInternAssignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AssignmentScreen()
                }
            }
        }
    }
}



@OptIn(ExperimentalComposeUiApi::class, ExperimentalTextApi::class)
@Preview
@Composable
fun AssignmentScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var appInput by remember {
            mutableStateOf("")
        }
        var customInput by remember {
            mutableStateOf("")
        }
        val focusManager = LocalFocusManager.current

        val keyboardController = LocalSoftwareKeyboardController.current

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Google",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = appInput,
            onValueChange = {
                appInput = it
            },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {
                focusManager.clearFocus()
            }),
        )

        Row(
            modifier = Modifier.fillMaxWidth().weight(2f).padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "\uD83D\uDC4B",
                modifier = Modifier.clickable {
                    appInput = "Hello!"
                },
                fontSize = 20.sp
            )
            TextField(
                value = customInput,
                onValueChange = {
                    customInput = it
                },
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
            )
            Icon(
                imageVector = Icons.Filled.Done,
                tint = Color.White,
                contentDescription = "done",
                modifier = Modifier.clickable {
                    appInput = customInput
                    customInput = ""
                    keyboardController?.hide()
                }
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Green)
            )

        }
    }
}
