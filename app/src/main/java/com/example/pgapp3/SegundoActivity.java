package com.example.pgapp3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundoActivity extends AppCompatActivity {
    Button boton4,boton5;
    private TextView nombre,rut,edad,sexo,discapacidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundo_main);
        boton4 = (Button)findViewById(R.id.button4);
        boton5 = (Button)findViewById(R.id.button5);

        nombre = (TextView)findViewById(R.id.infonombre);
        rut = (TextView)findViewById(R.id.inforut);
        edad = (TextView)findViewById(R.id.infoedad);
        sexo = (TextView)findViewById(R.id.infosexo);
        discapacidad =(TextView)findViewById(R.id.infodiscapacidad);

        String receptor1=getIntent().getStringExtra("newnombre");
        String receptor2=getIntent().getStringExtra("newrut");
        String receptor3=getIntent().getStringExtra("newedad");
        String receptor4=getIntent().getStringExtra("newsexo");
        String receptor5=getIntent().getStringExtra("newsdis");

        nombre.setText(receptor1);
        rut.setText(receptor2);
        edad.setText(receptor3);
        sexo.setText(receptor4);
        discapacidad.setText(receptor5);

        int receptor6=getIntent().getIntExtra("int",0);
    }
    public void Siguiente(View view){
        Intent i = new Intent(SegundoActivity.this, TercerActivity.class);
        startActivity(i);
    }
    public void Volver(View view2){
        Intent i = new Intent(SegundoActivity.this, MainActivity.class);
        startActivity(i);
    }
}
