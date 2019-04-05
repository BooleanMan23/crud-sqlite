package com.example.sqlite_crud;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {

    EditText namaEditText;
    String nama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        namaEditText = findViewById(R.id.namaEditText);
    }

    public  void delete(View view){
        nama = String.valueOf(namaEditText.getText());
        String table_name = "makanan2";

        try {
            //prepared statement
            String sql = "DELETE FROM makanan2 WHERE nama=?";
            SQLiteStatement statement = MainActivity.myDatabase.compileStatement(sql);




            statement.bindString(1, nama);
            statement.executeUpdateDelete();

            Context context = getApplicationContext();
            CharSequence text = nama + " berhasil di delete";
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
