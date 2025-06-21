package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.a20180101_dewanshkaushik_nycschools.ui.theme.JetpackComposeAndroidExamplesTheme

class LauncherActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetpackComposeAndroidExamplesTheme {
                ShowMenu()
            }
        }
    }


    @Composable
    fun ShowMenu() {
        val context = LocalContext.current
        Column {
            Button(onClick = {
                val intent = Intent(context, MainActivity::class.java);
                startActivity(intent)
            }) {
                Text("RememberCoroutineScope")
            }


        }


    }
}