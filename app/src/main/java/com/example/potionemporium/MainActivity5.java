package com.example.potionemporium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity5 extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 60000;
    private Button StartPausebtn,Resetbtn,leavexd;
    private TextView TvCD;
    private CountDownTimer cdt;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        StartPausebtn = (Button) findViewById(R.id.StartCD);
        Resetbtn = (Button) findViewById(R.id.ResetCD);
        TvCD = (TextView) findViewById(R.id.TvCD);
        leavexd = findViewById(R.id.leavexd);

        leavexd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        StartPausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });

        Resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCdtt();
    }
    private void startTimer(){
        cdt = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCdtt();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                StartPausebtn.setText("Start");
                StartPausebtn.setVisibility(View.INVISIBLE);
                Resetbtn.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity5.this, "Time's finished", Toast.LENGTH_SHORT).show();

            }
        }.start();

        mTimerRunning = true;
        StartPausebtn.setText("Pause");
        Resetbtn.setVisibility(View.INVISIBLE);

    }
    private void pauseTimer(){
        cdt.cancel();
        mTimerRunning = false;
        StartPausebtn.setText("Start");
        Resetbtn.setVisibility(View.VISIBLE);

    }
    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCdtt();
        Resetbtn.setVisibility(View.INVISIBLE);
        StartPausebtn.setVisibility(View.VISIBLE);

    }
    private void updateCdtt(){
        int minutes = (int) (mTimeLeftInMillis/1000)/60;
        int seconds = (int) (mTimeLeftInMillis/1000)%60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        TvCD.setText(timeLeft);

    }

}