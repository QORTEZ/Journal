package com.project.qortez.journal.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ${Qortez} on 6/29/2018.
 */

@Dao
public interface EventDao {

    @Query("SELECT * FROM event ORDER BY id")
    LiveData<List<EventEntry>> loadAllEvents();

    @Insert
    void insertEvent(EventEntry eventEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateEvent(EventEntry eventEntry);

    @Delete
    void deleteEvent(EventEntry eventEntry);

    @Query("SELECT * FROM event WHERE id = :id")
    LiveData<EventEntry> loadEventById(int id);
}
