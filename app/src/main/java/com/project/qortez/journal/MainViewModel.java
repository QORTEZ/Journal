package com.project.qortez.journal;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.project.qortez.journal.database.AppDatabase;
import com.project.qortez.journal.database.EventEntry;

import java.util.List;

/**
 * Created by ${Qortez} on 6/29/2018.
 */
public class MainViewModel extends AndroidViewModel {

    // Constant for logging
    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<EventEntry>> events;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        events = database.eventDao().loadAllEvents();
    }

    public LiveData<List<EventEntry>> getEvents() {
        return events;
    }
}
