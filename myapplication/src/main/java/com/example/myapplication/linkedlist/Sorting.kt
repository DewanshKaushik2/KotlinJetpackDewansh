package com.example.myapplication.linkedlist

import android.os.Build
import androidx.annotation.RequiresApi

class Sorting {

}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    var stopWords = listOf(
        "The",
        "the",
        "and",
        "a",
        "an",
        "to",
        "in",
        "of",
        "on",
        "for",
        "with",
        "at",
        "by",
        "from",
        "is",
        "it",
        "this",
        "that"
    )
    var text = "The quick quick brown fox jumps over the lazy dog. The dog barked back at the fox."
    var words = text.split(" ")
    words -= stopWords
    val wordCount = mutableMapOf<String, Int>()
    val hashmap: HashMap<String, Int>? = null
    val list: List<String>? = null
    val set: Set<String>? = null
    hashmap?.entries?.take(3)
    list?.take(3)
    set?.take(3)
    list?.indexOf("")
    for (word in words) {
        if (word.isNotEmpty()) {
            wordCount[word] = wordCount.getOrDefault(word, 0) + 1
        }
    }
    var sortedWords = wordCount.entries.sortedByDescending { it.value }

    val top3Words = sortedWords.take(3)
    println("Top 3 most frequent words")
    for ((word, count) in top3Words) {
        println("$word: $count")

    }

}





