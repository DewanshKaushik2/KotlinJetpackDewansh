package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.example.a20180101_dewanshkaushik_nycschools.ui.theme.JetpackComposeAndroidExamplesTheme
import kotlinx.coroutines.launch

class RememberCoroutineScope : BaseActivity() {

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

        val scope = rememberCoroutineScope();
        val context = LocalContext.current
        var text = "Counter is running ${counter.value}"
        if(counter.value == 10) {
            text = "Counter stopped"
        }

        Column {
            Text(text = text)
            Button(onClick = {
                scope.launch {
                    Log.d("CoroutineScopeComposable","Start");
                    try {
                        for(i in ) {

                        }
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }) {
                Text(text = "Start")
            }

        }

    }


}