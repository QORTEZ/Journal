package com.project.qortez.journal;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.project.qortez.journal.database.AppDatabase;
import com.project.qortez.journal.database.EventEntry;

/**
 * Created by ${Qortez} on 6/29/2018.
 */
public class AddEventViewModel extends ViewModel {

    // Adding an event member variable for the EventEntry object wrapped in a LiveData
    private LiveData<EventEntry> event;

    // Creating a constructor where loadTaskById of the taskDao will be called to initialize the tasks variable
    public AddEventViewModel(AppDatabase database, int eventId) {
        event = database.eventDao().loadEventById(eventId);
    }

    // Create a getter for the event variable
    public LiveData<EventEntry> getEvent() {
        return event;
    }
}
