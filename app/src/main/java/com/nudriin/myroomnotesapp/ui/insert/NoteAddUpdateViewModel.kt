package com.nudriin.myroomnotesapp.ui.insert

import android.app.Application
import androidx.lifecycle.ViewModel
import com.nudriin.myroomnotesapp.database.Note
import com.nudriin.myroomnotesapp.repository.NoteRepo

class NoteAddUpdateViewModel(application: Application): ViewModel() {
    private val mNoteRepo: NoteRepo = NoteRepo(application)

    fun insert(note: Note) {
        mNoteRepo.insert(note)
    }

    fun update(note: Note) {
        mNoteRepo.update(note)
    }
    fun delete(note: Note) {
        mNoteRepo.delete(note)
    }
}