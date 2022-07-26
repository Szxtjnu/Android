package com.example.uicontroldemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button buttonLeft, buttonRight, button3;
    Switch aSwitch;
    ProgressBar progressBar;
    EditText editText;
    RadioGroup radioGroup;
    ImageView imageView;
    SeekBar seekBar;
    CheckBox checkBoxYuwen, checkBoxShuxue, checkBoxYingyu;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        buttonLeft = findViewById(R.id.button);
        buttonRight = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        aSwitch = findViewById(R.id.switch2);
        progressBar = findViewById(R.id.progressBar3);
        editText = findViewById(R.id.editTextNumber);
        radioGroup = findViewById(R.id.RadioGroup);
        imageView = findViewById(R.id.imageView2);
        seekBar = findViewById(R.id.seekBar);
        checkBoxYuwen = findViewById(R.id.checkBox);
        checkBoxShuxue = findViewById(R.id.checkBox2);
        checkBoxYingyu = findViewById(R.id.checkBox3);
        ratingBar = findViewById(R.id.ratingBar);

        final String[] yuwen = {""};
        final String[] shuxue = {""};
        final String[] yingyu = {""};


        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(R.string.button1);
            }
        });

        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText(R.string.button2);
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    display.setText("open");
                }else{
                    display.setText("close");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                if (TextUtils.isEmpty(s)){
                    s = "0";
                }
                progressBar.setProgress(Integer.valueOf(s));
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioButton){
                    imageView.setImageResource(R.drawable.android);
                }else{
                    imageView.setImageResource(R.drawable.iphone);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                display.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBoxYuwen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) yuwen[0] = "语文";
                else yuwen[0] = "";
                display.setText(yuwen[0] + shuxue[0] + yingyu[0]);
            }

        });

        checkBoxShuxue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    shuxue[0] = "数学";
                }else{
                    shuxue[0] = "";
                }
                display.setText(yuwen[0] + shuxue[0] + yingyu[0]);
            }
        });

        checkBoxYingyu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    yingyu[0] = "英语";
                }else{
                    yingyu[0] = "";
                }
                display.setText(yuwen[0] + shuxue[0] + yingyu[0]);
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(getApplicationContext(),String.valueOf(v)+"星评价",Toast.LENGTH_SHORT).show();
            }
        });
    }
}