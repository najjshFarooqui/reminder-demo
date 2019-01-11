package com.example.najish.reminderdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.databinding.DataBindingUtil;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.najish.reminderdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener ,DatePickerDialog.OnDateSetListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.reminde_spiner));
        binding.reminderSpinner.setAdapter(spinnerAdapter);

                binding.setTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogFragment timepicker = new TimePickerFragment();
                        timepicker.show(getSupportFragmentManager(),"time picker");
                    }
                });

                binding.setDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogFragment datePicker = new DatePickerFragment();
                        datePicker.show(getSupportFragmentManager(),"date picker");
                    }
                });

                binding.reminderBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String message= binding.message.getText().toString();
                    }
                });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        binding.setTime.setText(hourOfDay+ " : " +minute);

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        binding.setDate.setText(year+"/"+month+"/"+dayOfMonth);
    }
}
