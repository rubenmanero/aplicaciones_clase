package com.ruben.aplicaciones_clase.BoardgamesApp

data class Game(var name: String, var category: GameCategory, var isSelected: Boolean = false)