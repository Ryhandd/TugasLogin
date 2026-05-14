package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUser = findViewById(R.id.etUser);
        EditText etPass = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnSignupNav = findViewById(R.id.btnSignupNav);

        btnSignupNav.setOnClickListener(v -> 
                startActivity(new Intent(this, SignupActivity.class)));

        btnLogin.setOnClickListener(v -> {
            SharedPreferences pref = getSharedPreferences("akun", MODE_PRIVATE);
            String u = pref.getString("username", "");
            String p = pref.getString("password", "");

            String inputUser = etUser.getText().toString();
            String inputPass = etPass.getText().toString();

            if (inputUser.equals(u) && inputPass.equals(p) && !u.isEmpty()) {
                Toast.makeText(this, "Login sukses", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}