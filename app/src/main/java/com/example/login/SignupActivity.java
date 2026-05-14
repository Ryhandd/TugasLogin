package com.example.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText etUser = findViewById(R.id.etSignupUser);
        EditText etPass = findViewById(R.id.etSignupPass);
        Button btnSignup = findViewById(R.id.btnSignup);

        btnSignup.setOnClickListener(v -> {
            SharedPreferences.Editor ed =
                    getSharedPreferences("akun", MODE_PRIVATE).edit();

            ed.putString("username", etUser.getText().toString());
            ed.putString("password", etPass.getText().toString());
            ed.apply();

            Toast.makeText(this, "Akun dibuat", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
