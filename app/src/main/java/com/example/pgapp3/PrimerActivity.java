package com.example.pgapp3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrimerActivity extends AppCompatActivity {
    Button boton1,boton2;
    private EditText newname;
    private TextView saludo;
    String receptor1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primer_main);
        boton1 = (Button)findViewById(R.id.button);
        boton2 = (Button)findViewById(R.id.button2);
        newname = (EditText)findViewById(R.id.editText);
        saludo = (TextView)findViewById(R.id.TextView);
        receptor1=getIntent().getStringExtra("newcodigo");

        //saludo.setText(receptor1);
    }

    public void Siguiente(View view){
        Intent i = new Intent(PrimerActivity.this, SegundoActivity.class);
        i.putExtra("newcodigo",receptor1);
        startActivity(i);
    }

    public void Newsaludo(View view2){
        String valor="Hola "+ newname.getText().toString();
        saludo.setText(valor);
    }
    public void Insertar(){
        SQLHelper chelp = new SQLHelper( this,"UsuariosDB",null,1);

        //insetando datos//
        SQLiteDatabase db = chelp.getWritableDatabase();
        if(db!=null){


        }

    }
}
