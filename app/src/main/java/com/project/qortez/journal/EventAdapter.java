package com.project.qortez.journal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.qortez.journal.database.EventEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ${Qortez} on 6/29/2018.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    // Constant for date format
    private static final String DATE_FORMAT = "dd/MM/yyy";
    // Member variable to handle item clicks
    final private ItemClickListener mItemClickListener;
    // Class variables for the List that holds task data and the Context
    private List<EventEntry> mEventEntries;
    private Context mContext;
    // Date formatter
    private SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());

    /**
     * Constructor for the EventAdapter that initializes the Context.
     *
     * @param context  the current Context
     * @param listener the ItemClickListener
     */
    public EventAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
    }

    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new EventViewHolder that holds the view for each event
     */
    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the event_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.event_layout, parent, false);

        return new EventViewHolder(view);
    }

    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder   The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        // Determine the values of the wanted data
        EventEntry eventEntry = mEventEntries.get(position);
        String description = eventEntry.getDescription();
        String updatedAt = dateFormat.format(eventEntry.getUpdatedAt());

        //format the date and split to parts to set up date view
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date mDate = null;
        try {
            mDate = newDateFormat.parse(updatedAt);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String[] parts = new String[0];
        if (mDate != null) {
            parts = mDate.toString().split(" ");
        }
        String dayOfWeek = parts[0];
        String monthOfYear = parts[1] + " " + parts[5];
        String dateOfMonth = parts[2];


        //Set values
        holder.eventDescriptionView.setText(description);
        holder.dateOfMonthView.setText(dateOfMonth);
        holder.dayView.setText(dayOfWeek);
        holder.monthView.setText(monthOfYear);


    }

    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mEventEntries == null) {
            return 0;
        }
        return mEventEntries.size();
    }

    public List<EventEntry> getEvents() {
        return mEventEntries;
    }

    /**
     * When data changes, this method updates the list of EventEntries
     * and notifies the adapter to use the new values on it
     */
    public void setEvents(List<EventEntry> eventEntries) {
        mEventEntries = eventEntries;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    // Inner class for creating ViewHolders
    class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Class variables for the task description and priority TextViews
        TextView eventDescriptionView;
        TextView dayView;
        TextView monthView;
        TextView dateOfMonthView;


        /**
         * Constructor for the EventViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public EventViewHolder(View itemView) {
            super(itemView);

            eventDescriptionView = itemView.findViewById(R.id.taskDescription);
            dayView = itemView.findViewById(R.id.tv_day);
            monthView = itemView.findViewById(R.id.tv_month);
            dateOfMonthView = itemView.findViewById(R.id.tv_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int elementId = mEventEntries.get(getAdapterPosition()).getId();
            mItemClickListener.onItemClickListener(elementId);
        }
    }

}
