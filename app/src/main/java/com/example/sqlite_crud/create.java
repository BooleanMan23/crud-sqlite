package com.example.sqlite_crud;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class create extends AppCompatActivity {
EditText namaEditText;
EditText hargaEditText;
String nama;
int harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        namaEditText = (EditText) findViewById(R.id.namaEditText);
        hargaEditText = (EditText) findViewById(R.id.hargaEditText);



    }

    public void create(View view){
        nama = String.valueOf(namaEditText.getText());
        String Sharga = String.valueOf(hargaEditText.getText());
        harga = Integer.parseInt(Sharga);

        try {
            //prepared statement
            String sql = "INSERT INTO makanan2 (nama, harga) VALUES (?, ?)";
            SQLiteStatement statement = MainActivity.myDatabase.compileStatement(sql);



            statement.bindString(1, nama);
            statement.bindLong(2, harga);
            statement.executeInsert();

            Context context = getApplicationContext();
            CharSequence text = nama + " dengan harga " + Sharga + " Berhasil ditambahkan";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            MainActivity.showInLog();






        }
        catch (Exception E){

        }


    }
}
