package com.project.qortez.journal;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.qortez.journal.database.AppDatabase;
import com.project.qortez.journal.database.EventEntry;

import java.util.Date;

public class AddEventActivity extends AppCompatActivity {

    // Extra for the event ID to be received in the intent
    public static final String EXTRA_EVENT_ID = "extraEventId";
    // Extra for the event ID to be received after rotation
    public static final String INSTANCE_EVENT_ID = "instanceEventId";
    // Constant for default task id to be used when not in update mode
    private static final int DEFAULT_EVENT_ID = -1;
    // Fields for views
    EditText mEditText;
    Button mButton;

    private int mEventId = DEFAULT_EVENT_ID;

    // Member variable for the Database
    private AppDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        initViews();

        mDb = AppDatabase.getInstance(getApplicationContext());

        if (savedInstanceState != null && savedInstanceState.containsKey(INSTANCE_EVENT_ID)) {
            mEventId = savedInstanceState.getInt(INSTANCE_EVENT_ID, DEFAULT_EVENT_ID);
        }

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_EVENT_ID)) {
            mButton.setText(R.string.update_button);
            if (mEventId == DEFAULT_EVENT_ID) {
                // populating the UI
                mEventId = intent.getIntExtra(EXTRA_EVENT_ID, DEFAULT_EVENT_ID);
                // Declaring a AddEventViewModelFactory using mDb and mEventId
                AddEventViewModelFactory factory = new AddEventViewModelFactory(mDb, mEventId);
                // Declaring a AddEventViewModel variable and initialize it by calling ViewModelProviders.of
                final AddEventViewModel viewModel
                        = ViewModelProviders.of(this, factory).get(AddEventViewModel.class);

                //Observing the LiveData object in the ViewModel. Use it also when removing the observer
                viewModel.getEvent().observe(this, new Observer<EventEntry>() {
                    @Override
                    public void onChanged(@Nullable EventEntry eventEntry) {
                        viewModel.getEvent().removeObserver(this);
                        populateUI(eventEntry);
                    }
                });
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(INSTANCE_EVENT_ID, mEventId);
        super.onSaveInstanceState(outState);
    }

    /**
     * initViews is called from onCreate to init the member variable views
     */
    private void initViews() {
        mEditText = findViewById(R.id.editTextEventDescription);

        mButton = findViewById(R.id.saveButton);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSaveButtonClicked();
            }
        });
    }

    /**
     * populateUI would be called to populate the UI when in update mode
     *
     * @param event the eventEntry to populate the UI
     */
    private void populateUI(EventEntry event) {
        if (event == null) {
            return;
        }

        mEditText.setText(event.getDescription());
    }

    /**
     * onSaveButtonClicked is called when the "save" button is clicked.
     * It retrieves user input and inserts that new event data into the underlying database.
     */
    public void onSaveButtonClicked() {
        String eventDescription = mEditText.getText().toString();
        Date date = new Date();

        final EventEntry event = new EventEntry(eventDescription,date);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (mEventId == DEFAULT_EVENT_ID) {
                    // insert new event
                    mDb.eventDao().insertEvent(event);
                } else {
                    //update event
                    event.setId(mEventId);
                    mDb.eventDao().updateEvent(event);
                }
                finish();
            }
        });
    }

}
