package com.example.a20180101_dewanshkaushik_nycschools

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel

@Composable
fun MainUi(userViewModel: MainViewModel = viewModel()) {
    // Fetch users if they haven't been fetched yet
   // userViewModel.getData()
var System=null;
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        userViewModel.users.forEach { user ->
            Text(text = "${user.academicopportunities1} - ${user.academicopportunities1}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserList() {
    MainUi()
}
