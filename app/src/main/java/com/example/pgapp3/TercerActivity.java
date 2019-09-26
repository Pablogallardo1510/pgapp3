package com.example.pgapp3;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

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
        p = (ProgressBar)findViewById(R.id.progressBar);
        t =(TextView) findViewById(R.id.porcentaje);
        dis = (CheckBox)findViewById(R.id.checkBox2);
    }
    public void Volver(View view2){
        Intent i = new Intent(TercerActivity.this, SegundoActivity.class);
        startActivity(i);
    }
    public void Guardar(View View){
        Intent i = new Intent(TercerActivity.this, SegundoActivity.class);
        i.putExtra("newnombre",nombre.getText().toString());
        i.putExtra("newrut",rut.getText().toString());
        i.putExtra("newedad",edad.getText().toString());

        if(dis.isChecked()==true){
            i.putExtra("newdis","si");
        }else{
            i.putExtra("newdis","ninguna");
        }
        if (masculino.isChecked()==true){
            i.putExtra("newsexo",masculino.getText().toString());

        }else { if (femenino.isChecked()==true){
            i.putExtra("newsexo",femenino.getText().toString());
            }
        }


        startActivity(i);
    }
}
