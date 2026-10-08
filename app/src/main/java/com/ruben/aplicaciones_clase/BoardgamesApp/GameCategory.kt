package com.ruben.aplicaciones_clase.BoardgamesApp

sealed class GameCategory(var isSelected: Boolean = true) {
    object Deckbuilding: GameCategory()
    object Euro: GameCategory()
    object LCG: GameCategory()
    object Legacy: GameCategory()
    object Cooperative: GameCategory()
}