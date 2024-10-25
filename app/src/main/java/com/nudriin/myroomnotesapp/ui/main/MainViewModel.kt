package com.nudriin.myroomnotesapp.ui.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nudriin.myroomnotesapp.database.Note
import com.nudriin.myroomnotesapp.repository.NoteRepo

class MainViewModel(application: Application): ViewModel() {
    private val mNoteRepo: NoteRepo = NoteRepo(application)

    fun getAllNotes(): LiveData<List<Note>> = mNoteRepo.getAllNotes()
}