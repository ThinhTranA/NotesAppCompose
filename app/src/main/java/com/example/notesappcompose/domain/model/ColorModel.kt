package com.example.notesappcompose.domain.model

import com.example.notesappcompose.data.model.ColorDbModel

data class ColorModel(
    val id: Long,
    val name: String,
    val hex: String
) {

    companion object {
        val DEFAULT = with(ColorDbModel.DEFAULT_COLOR) { ColorModel(id, name, hex) }
    }
}
