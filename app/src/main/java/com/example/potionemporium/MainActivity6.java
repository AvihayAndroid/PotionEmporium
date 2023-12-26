package com.example.potionemporium;

import static com.example.potionemporium.FBRef.refChat;
import static com.example.potionemporium.FBRef.refUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity6 extends AppCompatActivity {
    private Button btn1, btn2;
    private TextView tv1;
    private EditText et1, et2;
    FirebaseAuth mAuth;
    FirebaseUser user;
    User helper, helper2,helper3,helper4;
    Comms comms,comms2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        btn1 = findViewById(R.id.connection);
        btn2 = findViewById(R.id.sendtext);
        et1 = findViewById(R.id.connectet);
        tv1 = findViewById(R.id.texttv);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        et2 = findViewById(R.id.sharedtext);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query query = refUser.orderByChild("username").equalTo(et1.getText().toString());
                query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                            helper = userSnapshot.getValue(User.class);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                Query query2 = refUser.orderByChild("username").equalTo(user.getEmail().substring(0, user.getEmail().length() - 4));
                query2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                            helper2 = userSnapshot.getValue(User.class);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                comms = new Comms(helper, helper2, "");
                refChat.child("comms").setValue(comms);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (comms != null) {
                    String str = et2.getText().toString();
                    comms.setText(str);
                    tv1.setText(str);
                    refChat.child("comms").setValue(comms);
                    Query query3 = refChat.orderByChild("player1");
                    query3.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                                tv1.setText(comms.getText());
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

    }

    public void onStart() {
        super.onStart();
        Query query3 = refChat.orderByChild("Comms");
        query3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot userSnapshot : snapshot.getChildren()) {
                    comms2 = userSnapshot.getValue(Comms.class);
                    tv1.setText(comms2.getText());
                    comms = comms2;

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }



}