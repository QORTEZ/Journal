package com.project.qortez.journal.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by ${Qortez} on 6/29/2018.
 */

@Entity(tableName = "event")
public class EventEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    @ColumnInfo(name = "updated_at")
    private Date updatedAt;

    @Ignore
    public EventEntry(String description,Date updatedAt) {
        this.description = description;
        this.updatedAt = updatedAt;
    }

    public EventEntry(int id, String description, Date updatedAt) {
        this.id = id;
        this.description = description;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
