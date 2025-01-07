package com.example.a20180101_dewanshkaushik_nycschools.ui.composables

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a20180101_dewanshkaushik_nycschools.R
import com.example.a20180101_dewanshkaushik_nycschools.activities.FlowActivity
import androidx.compose.ui.res.imageResource

@Composable
fun FormScreen(activity: CoroutineActivity) {
    // saveDatain
    val context = LocalContext.current;
    var text by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        //row 1
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                "Coroutine Activity", style = TextStyle(
                    fontSize = 16.sp, textAlign = TextAlign.Center
                ), modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            )
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
                .weight(1f, false)
            //   .height(0.dp)
        ) {
            //row 1
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Coroutine Activity", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                Button(
                    onClick = {
                        context.startActivity(Intent(context, FlowActivity::class.java))
                    }, modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Mybutton")
                }
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    label = { Text("Enter Name") },
                )
            }
            //row 2
            Row(modifier = Modifier.padding(10.dp)) {
                Text(
                    "Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Left
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                Image(
                    painter = painterResource(id = androidx.appcompat.R.drawable.abc_text_select_handle_right_mtrl),
                    contentDescription = "Description of the image",
                    contentScale = ContentScale.Crop, // Adjusts how the image fits its bounds

                )

            }
        }
        // save button layout
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(
                onClick = {
                    context.startActivity(Intent(context, FlowActivity::class.java))
                    activity.saveDatainApi(text)

                }, modifier = Modifier.weight(1f)
            ) {
                Text(text = "Save")
            }
        }
    }
}


