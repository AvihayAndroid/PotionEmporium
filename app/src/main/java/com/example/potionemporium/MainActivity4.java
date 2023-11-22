
package com.example.potionemporium;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.IntentFilter;
        import android.net.ConnectivityManager;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {
    private NetworkStateReceiver networkStateReceiver;
    private boolean checkData = false;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn = (Button) findViewById(R.id.receiverbtn);
    }

    public void onOff(View view) {
        if (!checkData) {
            networkStateReceiver = new NetworkStateReceiver();

            IntentFilter connectFilter = new IntentFilter();
            connectFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

            registerReceiver(networkStateReceiver, connectFilter);
            checkData = true;
            btn.setText("Turn off Data Receiver");
        } else {
            unregisterReceiver(networkStateReceiver);
            checkData = false;
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
    protected void onResume() {
        super.onResume();

        IntentFilter networkFilter = new IntentFilter();
        registerReceiver(networkStateReceiver, networkFilter);

    }
}