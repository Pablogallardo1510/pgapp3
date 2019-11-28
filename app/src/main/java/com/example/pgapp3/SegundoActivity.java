package com.example.pgapp3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundoActivity extends AppCompatActivity {
    Button boton4,boton5;
    private TextView nombre,rut,edad,sexo,codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_main);
        boton4 = (Button)findViewById(R.id.button4);
        boton5 = (Button)findViewById(R.id.button5);

        codigo = (TextView)findViewById(R.id.infocodigo);
        nombre = (TextView)findViewById(R.id.infonombre);
        rut = (TextView)findViewById(R.id.inforut);
        edad = (TextView)findViewById(R.id.infoedad);
        sexo = (TextView)findViewById(R.id.infosexo);

        String receptor0=getIntent().getStringExtra("newcodigo");
        codigo.setText(receptor0);
        SQLHelper chelp = new SQLHelper( this,"PersonasDB",null,1);
        SQLiteDatabase db = chelp.getWritableDatabase();
        Cursor fila = db.rawQuery("select * from PERSONAS where Codigo ='" + receptor0 +"'", null);
        if(fila.moveToFirst()){
            codigo.setText(fila.getString(0));
            nombre.setText(fila.getString(1));
            rut.setText(fila.getString(2));
            edad.setText(fila.getString(3));
            sexo.setText(fila.getString(4));
        }

    }
    public void Siguiente(View view){
        Intent i = new Intent(SegundoActivity.this, TercerActivity.class);
        i.putExtra("newcodigo1",getIntent().getStringExtra("newcodigo"));
        startActivity(i);
    }
    public void Volver(View view2){
        Intent i = new Intent(SegundoActivity.this, PrimerActivity.class);
        startActivity(i);
    }
}
