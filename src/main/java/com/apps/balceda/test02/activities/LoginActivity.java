package com.apps.balceda.test02.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.balceda.test02.R;

public class LoginActivity extends AppCompatActivity {

  EditText username, password;
  Button login, register;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    SharedPreferences sharedPreferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString("usuario", "jbalceda");
    editor.putString("contrasena", "ed");
    editor.commit();


    username = findViewById(R.id.username);
    password = findViewById(R.id.password);

    login = findViewById(R.id.login);
    register = findViewById(R.id.register);

    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        SharedPreferences preferences = getSharedPreferences("usuarios", Context.MODE_PRIVATE);

        if (user.equals(preferences.getString("usuario", "x"))) {
          if (pass.equals(preferences.getString("contrasena", "x"))) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
          } else {
            Toast.makeText(LoginActivity.this, "Wrong password", Toast.LENGTH_LONG).show();
          }
        } else {
          Toast.makeText(LoginActivity.this, "Wrong username", Toast.LENGTH_LONG).show();
        }
      }
    });

    register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Toast.makeText(LoginActivity.this, "Registro", Toast.LENGTH_SHORT).show();
      }
    });
  }
}
