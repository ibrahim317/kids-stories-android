package com.example.kidsstorybook.models

data class ComparisonItem(
    val id: String,
    val title: String,
    val doText: String,
    val dontText: String,
    val imagePath: String,
    val audioPath: String?
)

