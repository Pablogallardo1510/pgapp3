package com.example.pgapp3;

import android.app.AppComponentFactory;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TercerActivity extends AppCompatActivity {
    private EditText nombre,rut,edad,sexo;
    private RadioButton masculino,femenino;
    CheckBox dis;
    ProgressBar p;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercer_main);

        nombre = (EditText)findViewById(R.id.editnombre);
        rut = (EditText)findViewById(R.id.editrut);
        edad = (EditText)findViewById(R.id.editedad);
        masculino = (RadioButton)findViewById(R.id.radioButton);
        femenino = (RadioButton)findViewById(R.id.radioButton2);


    }
    public void Volver(View view2){
        Intent i = new Intent(TercerActivity.this, SegundoActivity.class);
        startActivity(i);
    }
    public void Guardar(View View){
        String receptor0=getIntent().getStringExtra("newcodigo");

        String sunombre=nombre.getText().toString();
        String surut=rut.getText().toString();
        String suedad=edad.getText().toString();
        String susexo=sexo.getText().toString();


        SQLHelper chelp = new SQLHelper( this,"PersonasDB",null,1);
        //insetando datos//
        SQLiteDatabase db = chelp.getWritableDatabase();
        if (masculino.isChecked()==true){
            susexo=masculino.getText().toString();

        }else { if (femenino.isChecked()==true){
            susexo=femenino.getText().toString();
        }
        }
        if(!sunombre.isEmpty() && !surut.isEmpty()&& !suedad.isEmpty()){

                    ContentValues registro = new ContentValues();
                    registro.put("Codigo",1);
                    registro.put("Nombre",sunombre);
                    registro.put("Rut",surut);
                    registro.put("Edad",suedad);
                    registro.put("Sexo",susexo);

                    db.insert("PERSONAS",null,registro);
                    db.close();
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(TercerActivity.this, SegundoActivity.class);
                    startActivity(i);

        }else {
            Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }


    }
}
