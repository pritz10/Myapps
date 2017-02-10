package com.example.user.myapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public TextView textView;
    public Button sunny;
    public Button foggy;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    DatabaseReference condition=databaseReference.child("condition");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView2);
        sunny =(Button) findViewById(R.id.button);
        foggy=(Button) findViewById(R.id.button2);

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        condition.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        String text=dataSnapshot.getValue(String.class);
        textView.setText(text);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
});
      sunny.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              condition.setValue("Sunny");
          }
      });
        foggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condition.setValue("foggy");
            }
        });
    }

}
