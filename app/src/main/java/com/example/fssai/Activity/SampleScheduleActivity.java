package com.example.fssai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fssai.Adapter.ScheduleAdapter;
import com.example.fssai.Adapter.ScheduleModel;
import com.example.fssai.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class SampleScheduleActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ScheduleAdapter scheduleAdapter;
    public static List<ScheduleModel> scheduleModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_schedule);
        getSupportActionBar().setTitle("SAMPLING APPROVAL REQUEST");

        EditText samplerName,city,fsoName,date,time,location;
        Button approval_btn;


        samplerName = findViewById(R.id.et_samplerName);
        city = findViewById(R.id.city_edittext);
        fsoName = findViewById(R.id.nameFSO_edittext);
        date = findViewById(R.id.date_edittext);
        time = findViewById(R.id.time_edittext);
        location = findViewById(R.id.location_edittext);
        approval_btn = findViewById(R.id.approval_btn);

        recyclerView = findViewById(R.id.recycler_view);



        DatePicker();
        TimePicker();

        getList();
        setRecyclerView(samplerName.getText().toString(), city.getText().toString(), fsoName.getText().toString(),
                date.getText().toString(), time.getText().toString(), location.getText().toString());



        approval_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!samplerName.getText().toString().trim().isEmpty()
                        && !city.getText().toString().trim().isEmpty()
                        && !fsoName.getText().toString().trim().isEmpty()
                        && !date.getText().toString().trim().isEmpty()
                        && !time.getText().toString().trim().isEmpty()
                        && !location.getText().toString().trim().isEmpty()){

                    addToList(samplerName.getText().toString(), city.getText().toString(), fsoName.getText().toString(),
                            date.getText().toString(), time.getText().toString(), location.getText().toString());

                    if(scheduleAdapter != null) {
                        scheduleAdapter.notifyDataSetChanged();
                    }
                    // Notify the adapter that data has changed

                }else{
                    Toast.makeText(SampleScheduleActivity.this,"Please Provide Complete Detail",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private void setRecyclerView(String name, String city, String fsoName, String date, String time, String location){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        scheduleAdapter = new ScheduleAdapter(this, scheduleModelList); // Pass the existing list to the adapter
        recyclerView.setAdapter(scheduleAdapter);
    }

    private void addToList(String name, String city, String fsoName, String date, String time, String location) {
        // Create a new ScheduleModel object and add it to the existing list
        String dateTime = date+" "+time;
        ScheduleModel model = new ScheduleModel(city, fsoName,name,dateTime, location);
        scheduleModelList.add(model);
    }

    private List<ScheduleModel> getList() {
        // Return the existing list
        return scheduleModelList;
    }

    private String DatePicker(){
        final TextView editText = findViewById(R.id.date_edittext);

// Create a PopupWindow object
        final PopupWindow popupWindow = new PopupWindow(this);

// Inflate the popup_window.xml layout file
        View popupView = getLayoutInflater().inflate(R.layout.date_popup, null);

// Set the PopupWindow view to the inflated layout
        popupWindow.setContentView(popupView);

// Set the width and height of the PopupWindow
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

// Set the minimum and maximum dates for the DatePicker
        Calendar calendar = Calendar.getInstance();
        DatePicker datePicker = popupView.findViewById(R.id.date_picker);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);

        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                // Show the pop-up window at the center of the screen
                popupWindow.showAtLocation(editText, Gravity.CENTER, 0, 0);
                return true;
            }
        });

// Handle touch events on the EditText view
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

// Handle the date selection when the user clicks on the "OK" button
        Button closeButton = popupView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int dayOfMonth = datePicker.getDayOfMonth();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);

                // Set the selected date on the EditText view
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                editText.setText(dateFormat.format(calendar.getTime()));

                // Dismiss the pop-up window
                popupWindow.dismiss();
            }
        });

        return editText.getText().toString();

    }

    private String TimePicker(){
        final TextView timeButton = findViewById(R.id.time_edittext);

// Create a PopupWindow object
        final PopupWindow popupWindow = new PopupWindow(this);

// Inflate the popup_window.xml layout file
        View popupView = getLayoutInflater().inflate(R.layout.time_popup, null);

// Set the PopupWindow view to the inflated layout
        popupWindow.setContentView(popupView);

// Set the width and height of the PopupWindow
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

// Set the current time as the default time for the TimePicker
        Calendar calendar = Calendar.getInstance();
        TimePicker timePicker = popupView.findViewById(R.id.time_picker);
        timePicker.setIs24HourView(true);
        timePicker.setHour(calendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setMinute(calendar.get(Calendar.MINUTE));

        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                // Show the pop-up window at the center of the screen
                popupWindow.showAtLocation(timeButton, Gravity.CENTER, 0, 0);
                return true;
            }
        });

// Handle touch events on the EditText view
        timeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });

// Handle the time selection when the user clicks on the "Close" button
        Button closeButton = popupView.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                // Set the selected time on the time button
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hour, minute));

                // Dismiss the pop-up window
                popupWindow.dismiss();
            }
        });

// Handle the time selection when the user changes the time using the TimePicker
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // Update the selected time on the time button
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute));
            }
        });

        return timeButton.getText().toString();
    }




}