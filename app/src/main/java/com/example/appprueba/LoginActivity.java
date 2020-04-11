package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.appprueba.database.AppDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    CheckBox SharedPref;
    TextInputEditText userTi, passwordTi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPref = findViewById(R.id.checkCredentials);
        userTi = findViewById(R.id.inputUsuario);
        passwordTi = findViewById(R.id.passwordInput);
        preferencesVerification(); //TODO Edgar: Te falta validar que si le dan recordar los pase directo a MainActivity
    }

    private void preferencesVerification() {
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        String user = preferences.getString("user", "");
        String password = preferences.getString("password", "");
        userTi.setText(user);
        passwordTi.setText(password);
    }

    @SuppressLint("ShowToast")
    @OnClick({R.id.buttonLogin})
    public void onClick(View view) {
        String respuesta = validarAcceso();
        //String respuesta ="";
        if (respuesta.equals("")) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        } else {
            Toast.makeText(this, respuesta, Toast.LENGTH_LONG).show();
        }
    }

    private void savePreferences() {
        SharedPreferences preferences = getSharedPreferences("credentials", Context.MODE_PRIVATE);
        String user = userTi.getText() != null ? userTi.getText().toString() : "";
        String password = passwordTi.getText()!=null? passwordTi.getText().toString(): "";

        if (user.equals("")) {
            userTi.setError("Escribir Usuario");
            userTi.requestFocus();
        } else if (password.equals("")) {
            passwordTi.setError("Escribir contraseña");
            passwordTi.requestFocus();
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user", user);
            editor.putString("password", password);
            editor.apply();
        }
    }

    public String validarAcceso() {
        int users;
        String user = userTi.getText() != null ? userTi.getText().toString() : "";
        String password = passwordTi.getText()!=null? passwordTi.getText().toString(): "";

        if (user.equals("admin") && password.equals("admin")) {
            users = 1;
        } else {
            users = AppDatabase.getInstance(getApplicationContext()).personalDao().loadUser(user, Long.parseLong(password));
        }
        if (users != 0 && SharedPref.isChecked()) {
            savePreferences();
        }
        return users != 0 ? "" : "Usuario no se encuentra en la base de datos";
    }
}
