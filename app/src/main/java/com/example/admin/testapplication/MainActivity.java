package com.example.admin.testapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        from = (EditText) findViewById(R.id.txtDateFrom);
    }

    public void getDate(View view) {
        final Dialog d = new Dialog(this);
        d.setTitle("Pick Date");
        d.setContentView(R.layout.date_picker_layout);
        final DatePicker datePicker = d.findViewById(R.id.daily_datepicker);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        Button setbtn = d.findViewById(R.id.setBTN);
        setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss();
                from.setText(datePicker.getMonth() + "/" + datePicker.getDayOfMonth() + "/" +datePicker.getYear() );
            }
        });
        d.show();
    }
}
