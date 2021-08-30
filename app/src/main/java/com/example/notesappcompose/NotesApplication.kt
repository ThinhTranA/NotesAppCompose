package com.example.notesappcompose

import android.app.Application
import com.example.notesappcompose.dependencyinjection.DependencyInjector

class NotesApplication: Application() {
    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjector()
    }

    private fun initDependencyInjector() {
        dependencyInjector = DependencyInjector(this)
    }
}