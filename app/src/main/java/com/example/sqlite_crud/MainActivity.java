package com.example.sqlite_crud;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            myDatabase = this.openOrCreateDatabase("Restaurant", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS makanan2 (nama VARCHAR, harga INT(10))");
        }
        catch (Exception E){

        }
    }

    public void create(View view){
        Intent intent = new Intent(getApplicationContext(), create.class);
        startActivity(intent);


    }

    public  void cari(View view){
        Intent intent = new Intent(getApplicationContext(), cari.class);
        startActivity(intent);
    }

    public void update(View view){
        Intent intent = new Intent(getApplicationContext(), update.class);
        startActivity(intent);
    }

    public void delete(View view){
        Intent intent = new Intent(getApplicationContext(), delete.class);
        startActivity(intent);
    }

    public  static  void showInLog(){
        Cursor c = MainActivity.myDatabase.rawQuery("SELECT * FROM makanan2", null );
        //mengambil index kolum
        int namaIndex = c.getColumnIndex("nama");
        int hargaIndex = c.getColumnIndex("harga");
        c.moveToFirst();
        while (c != null){
            Log.i("hasil-nama", c.getString(namaIndex));

            Log.i("hasil-harga" , String.valueOf(c.getInt(hargaIndex)));
            c.moveToNext();


        }



    }
}
