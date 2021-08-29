package com.example.notesappcompose.database.dbmapper

import com.example.notesappcompose.data.model.ColorDbModel
import com.example.notesappcompose.database.model.NoteDbModel
import com.example.notesappcompose.domain.model.ColorModel
import com.example.notesappcompose.domain.model.NoteModel

interface DbMapper {

    // NoteDbModel -> NoteModel

    fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>
    ): List<NoteModel>

    fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel): NoteModel

    // ColorDbModel -> ColorModel

    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel>

    fun mapColor(colorDbModel: ColorDbModel): ColorModel

    // NoteModel -> NoteDbModel

    fun mapDbNote(note: NoteModel): NoteDbModel

    // ColorModel -> ColorDbModel

    fun mapDbColors(colors: List<ColorModel>): List<ColorDbModel>

    fun mapDbColor(color: ColorModel): ColorDbModel
}
