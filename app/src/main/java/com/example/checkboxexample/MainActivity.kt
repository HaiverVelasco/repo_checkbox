package com.example.checkboxexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.checkboxexample.ui.theme.CheckboxexampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckboxexampleTheme {
                MyCheckbox()
            }
        }
    }
}

@Composable
fun MyCheckbox(){
 val isCheked = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.padding(16.dp)
            .clickable {isCheked.value = !isCheked.value}
    ){
        Checkbox(
            checked = isCheked.value,
            onCheckedChange = {isCheked.value = it}
        )
        Text(
            text = if (isCheked.value) "Verificado" else "No verificado",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyCheckboxPreview() {
    CheckboxexampleTheme {
        MyCheckbox()
    }
}