package com.app.test.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowUserActivity extends AppCompatActivity {

    TextView name, lastName, email, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);

        name = findViewById(R.id.nameText);
        lastName = findViewById(R.id.lastNameText);
        email = findViewById(R.id.emailText);
        id = findViewById(R.id.idUserText);
    }
}
