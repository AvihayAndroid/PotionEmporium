
package com.example.potionemporium;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.IntentFilter;
        import android.content.SharedPreferences;
        import android.net.ConnectivityManager;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    private NetworkStateReceiver networkStateReceiver;
    private Button btn,btn2;
    private SharedPreferences ison;
    private boolean checkData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn = (Button) findViewById(R.id.receiverbtn);
        btn2 = (Button) findViewById(R.id.leavenow);
        ison = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor =ison.edit();
        checkData = ison.getBoolean("datacheck",false);
        if (ison.getBoolean("datacheck",false)){
            btn.setText("Turn off Data Receiver");
            networkStateReceiver = new NetworkStateReceiver();
            IntentFilter connectFilter = new IntentFilter();
            connectFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(networkStateReceiver, connectFilter);
        }



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onOff(View view) {
        ison = getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor =ison.edit();
        if (!checkData) {
            networkStateReceiver = new NetworkStateReceiver();

            IntentFilter connectFilter = new IntentFilter();
            connectFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

            registerReceiver(networkStateReceiver, connectFilter);
            checkData = true;
            editor.putBoolean("datacheck",true);
            editor.commit();
            btn.setText("Turn off Data Receiver");
        } else {
            unregisterReceiver(networkStateReceiver);
            checkData = false;
            editor.putBoolean("datacheck",false);
            editor.commit();
            btn.setText("Turn on Data Receiver");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (checkData) {
            unregisterReceiver(networkStateReceiver);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(ison.getBoolean("datacheck",false)==true) {
            IntentFilter connectFilter2 = new IntentFilter();
            connectFilter2.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(networkStateReceiver, connectFilter2);
        }

    }
}