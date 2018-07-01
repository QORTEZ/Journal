package com.project.qortez.journal;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.project.qortez.journal.database.AppDatabase;

/**
 * Created by ${Qortez} on 6/29/2018.
 */
public class AddEventViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    // Adding two member variables. One for the database and one for the entryId
    private final AppDatabase mDb;
    private final int mEntryId;

    // Initialize the member variables in the constructor with the parameters received
    public AddEventViewModelFactory(AppDatabase database, int entryId) {
        mDb = database;
        mEntryId = entryId;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AddEventViewModel(mDb, mEntryId);
    }
}
