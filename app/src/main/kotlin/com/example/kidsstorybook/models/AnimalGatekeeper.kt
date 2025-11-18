package com.example.kidsstorybook.models

import com.example.kidsstorybook.data.AnimalRepository

object AnimalGatekeeper {
    private const val LOCKED_COUNT = 6

    fun lockedAnimalNames(): Set<String> {
        val animals = AnimalRepository.getAllAnimals()
        if (animals.isEmpty()) return emptySet()
        val count = LOCKED_COUNT.coerceAtMost(animals.size)
        return animals.takeLast(count).map { it.name }.toSet()
    }
}

