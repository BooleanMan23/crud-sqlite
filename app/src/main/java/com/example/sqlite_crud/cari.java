package com.example.sqlite_crud;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class cari extends AppCompatActivity {
    static ArrayList<String> makanan = new ArrayList<String>();
    static ArrayAdapter arrayAdapter;
    ListView myListView;
    EditText cariEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        makanan.clear();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);
        cariEditText = (EditText) findViewById(R.id.cariEditText);
        myListView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, makanan);
        myListView.setAdapter(arrayAdapter);

        try {
            Cursor c = MainActivity.myDatabase.rawQuery("SELECT * FROM makanan2", null);
            //mengambil index kolum
            int namaIndex = c.getColumnIndex("nama");
            int hargaIndex = c.getColumnIndex("harga");
            c.moveToFirst();
            while (c != null) {
                Log.i("name", c.getString(namaIndex));

                Log.i("age", String.valueOf(c.getInt(hargaIndex)));
                c.moveToNext();
                String masuk = c.getString(namaIndex) + " Harga =  " + String.valueOf(c.getInt(hargaIndex));
                makanan.add(masuk);
                arrayAdapter.notifyDataSetChanged();
            }


        }



        catch (Exception E)
        {
        }
        cariEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                (cari.this).arrayAdapter.getFilter().filter(s);
                try {

//                    String nama = String.valueOf(cariEditText.getText());
//
//
//
//
//                    Cursor c = MainActivity.myDatabase.rawQuery(
//                            "SELECT * FROM makanan2 WHERE nama=?",
//                            new String[] {nama}
//                    );
//
//
//                    int namaIndex = c.getColumnIndex("nama");
//                    int hargaIndex = c.getColumnIndex("harga");
//                    c.moveToFirst();
//                    while (c != null){
//                        Log.i("hasil-nama", c.getString(namaIndex));
//
//                        Log.i("hasil-harga" , String.valueOf(c.getInt(hargaIndex)));
//                        c.moveToNext();
//                        String masuk = c.getString(namaIndex) + " Harga =  " + String.valueOf(c.getInt(hargaIndex));
//                        makanan.add(masuk);
//                        arrayAdapter.notifyDataSetChanged();
//
//
//                    }


                }

                catch (Exception E){


                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    }
