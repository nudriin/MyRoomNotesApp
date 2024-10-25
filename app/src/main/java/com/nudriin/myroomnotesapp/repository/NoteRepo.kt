package com.nudriin.myroomnotesapp.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.nudriin.myroomnotesapp.database.Note
import com.nudriin.myroomnotesapp.database.NoteDao
import com.nudriin.myroomnotesapp.database.NoteRoomDB
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepo(application: Application) {
    private val mNotesDao: NoteDao
    private  val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteRoomDB.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute { mNotesDao.insert(note) }
    }
    fun delete(note: Note) {
        executorService.execute { mNotesDao.delete(note) }
    }
    fun update(note: Note) {
        executorService.execute { mNotesDao.update(note) }
    }
}