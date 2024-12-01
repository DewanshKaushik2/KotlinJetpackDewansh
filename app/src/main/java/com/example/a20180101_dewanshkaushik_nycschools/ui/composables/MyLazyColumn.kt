package com.example.a20180101_dewanshkaushik_nycschools.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel

@Composable
fun MyLazyColumn(mainViewModel: MainViewModel) {
    val posts by mainViewModel.posts

        LazyColumn {
        items(posts) { post ->
            Text(text = post.academicopportunities1?:"null")
        }
    }
    DisposableEffect(Unit) {
        mainViewModel.fetchUsers()
        onDispose {}
    }
}
