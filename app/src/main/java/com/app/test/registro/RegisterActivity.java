package com.app.test.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText email = findViewById(R.id.registerEmail);
        final EditText password = findViewById(R.id.registerPassword);
        final EditText name = findViewById(R.id.userName);
        final EditText lastName = findViewById(R.id.userLastName);
        Button registerButton = findViewById(R.id.registerButton);

        final DatabaseHelper db = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.insert(email.getText().toString(), password.getText().toString(), name.getText().toString(), lastName.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Se ha registrado correctamente", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "No se ha podido registrar", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
