package com.example.pgapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button boton1,boton2;
    private EditText newname;
    private TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button)findViewById(R.id.button);
        boton2 = (Button)findViewById(R.id.button2);
        newname = (EditText)findViewById(R.id.editText);
        saludo = (TextView)findViewById(R.id.TextView);
    }

    public void Siguiente(View view){
        Intent i = new Intent(MainActivity.this, SegundoActivity.class);
        i.putExtra("hola","sad");
        i.putExtra("int",2);
        startActivity(i);
    }

    public void Newsaludo(View view2){
        String valor="Hola "+ newname.getText().toString();
        saludo.setText(valor);
    }
}
