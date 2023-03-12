package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtView;
    private EditText edtView;
    private Button logOut;
    FirebaseUser user;
    FirebaseAuth auth;

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.nameButton:
                Toast.makeText(this, "Siam it is", Toast.LENGTH_SHORT).show();
                txtView.setText("Hello "+edtView.getText().toString());
                break;
            case R.id.editName:
                Toast.makeText(this, "Want to type something?", Toast.LENGTH_SHORT).show();
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        logOut = findViewById(R.id.logout);
        if(user == null){
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else{

        }

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });
        Button namButton = findViewById(R.id.nameButton);


        namButton.setOnClickListener(this);
        namButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BottomNavigation.class);
                startActivity(intent);
                finish();

                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        edtView = findViewById(R.id.editName);
        edtView.setOnClickListener(this);
        txtView = findViewById(R.id.txtName);

    }


}