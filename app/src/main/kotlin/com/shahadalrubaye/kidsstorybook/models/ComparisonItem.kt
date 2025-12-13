package com.shahadalrubaye.kidsstorybook.models

data class ComparisonItem(
    val id: String,
    val title: String,
    val doText: String,
    val dontText: String,
    val imagePath: String,
    val audioPath: String?,
    val category: ComparisonCategory = ComparisonCategory.OTHER,
    val thumbnailPath: String? = null
)

enum class ComparisonCategory {
    FAMILY,
    PLACES,
    OTHER
}

data class ComparisonGroup(
    val id: String,
    val title: String,
    val imagePath: String,
    val category: ComparisonCategory,
    val children: List<ComparisonItem>
)

