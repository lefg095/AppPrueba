package com.example.appprueba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appprueba.database.AppDatabase;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        recycler = findViewById(R.id.arvRvPersonal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setSubtitle("Personal Registrado");
            actionbar.setIcon(R.mipmap.ic_launcher);
        }

        List<Personal> personals = AppDatabase.getInstance(getApplicationContext()).personalDao().getAllPersonal();
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(new PersonalAdapter(personals));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_personal:
                Intent intent=new Intent(this,registroPersonal.class);
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
                //startActivity(new Intent(getApplicationContext(), registroPersonal.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            String message=data.getStringExtra("MESSAGE");
            Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        }
    }
}
