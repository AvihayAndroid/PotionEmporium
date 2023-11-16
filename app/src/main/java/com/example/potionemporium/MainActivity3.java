package com.example.potionemporium;

import static com.example.potionemporium.FBRef.refUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
    Button logout;
    FirebaseAuth mAuth;
    FirebaseUser user;
    User testxd;
    TextView tvxd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        logout = (Button)findViewById(R.id.logoutbtn);
        mAuth = FirebaseAuth.getInstance();
        tvxd = (TextView)findViewById(R.id.act3tv);
        user=mAuth.getCurrentUser();
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "You are signed in as "+user.getEmail(), Toast.LENGTH_SHORT).show();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onStart(){

        super.onStart();

        if(user == null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        Query query=refUser.orderByChild("username").equalTo(user.getEmail().substring(0,user.getEmail().length()-4));
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot userSnapshot : snapshot.getChildren())
                {
                    testxd = userSnapshot.getValue(User.class);
                }
                tvxd.setText(testxd.getUsername()+".com"+"\n"+testxd.getPassword());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

}