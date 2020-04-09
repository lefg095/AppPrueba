package com.example.appprueba;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.appprueba.database.AppDatabase;
import com.google.android.material.textfield.TextInputEditText;
import butterknife.OnClick;

public class registroPersonal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setIcon(R.mipmap.ic_launcher);
            actionbar.setSubtitle("Registro de Personal ");
        }
    }

    @OnClick({R.id.btnSave})
    public void onClick(View view) {
        guardar();
    }

    private void guardar() {
        TextInputEditText mNombre, mApellido, mDir, mIne, mTel, mPuesto;
        mNombre = findViewById(R.id.itNombre);
        mApellido = findViewById(R.id.itApellido);
        mDir = findViewById(R.id.itDir);
        mIne = findViewById(R.id.itIne);
        mTel = findViewById(R.id.itTel);
        mPuesto = findViewById(R.id.itPuesto);
        String nombre = mNombre.getText() != null ? mNombre.getText().toString() : "";
        String apellido = mApellido.getText() != null ? mApellido.getText().toString() : "";
        String dir = mDir.getText() != null ? mDir.getText().toString() : "";
        String ine = mIne.getText() != null ? mIne.getText().toString() : "";
        String tel = mTel.getText() != null ? mTel.getText().toString() : "";
        String puesto = mPuesto.getText()!=null?mPuesto.getText().toString():"";
        if (nombre.equals("")) {
            mNombre.setError("Escribir Nombre");
            mNombre.requestFocus();
        } else if (apellido.equals("")) {
            mApellido.setError("Escribir apellido");
            mApellido.requestFocus();
        } else if (dir.equals("")) {
            mDir.setError("Escribir direccion");
            mDir.requestFocus();
        } else if (tel.equals("") && !validadTelefono(tel)) {
            mTel.setError("Escribir telefono");
            mTel.requestFocus();
        } else if (ine.equals("")) {
            mIne.setError("Escribir INE");
            mIne.requestFocus();
        } else if (puesto.equals("")) {
            mPuesto.setError("Escribir puesto");
            mPuesto.requestFocus();
        } else {
            Personal personal = new Personal(nombre, apellido, dir, ine, Long.parseLong(tel), puesto);
            AppDatabase.getInstance(getApplicationContext()).personalDao().inserAll(personal);
            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
            Intent intent=new Intent();
            intent.putExtra("MESSAGE", "Registro correcto!");
            setResult(2,intent);
            finish();
        }
    }

    private boolean validadTelefono(String telefono) {
        return Patterns.PHONE.matcher(telefono).matches();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}