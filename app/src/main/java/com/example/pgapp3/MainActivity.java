package com.example.pgapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button boton1,boton2;
    private EditText user, password;
    private TextView saludo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button)findViewById(R.id.button);
        boton2 = (Button)findViewById(R.id.button2);
        user = (EditText)findViewById(R.id.editText);
        password =(EditText)findViewById(R.id.editText2);
        saludo = (TextView)findViewById(R.id.TextView);
    }

    public void Siguiente(View view){
        SQLHelper chelp = new SQLHelper( this,"UsuariosDB",null,1);
        SQLiteDatabase db = chelp.getWritableDatabase();
        String usuario=user.getText().toString();
        String contrasenia=password.getText().toString();

        if(!usuario.isEmpty() && !contrasenia.isEmpty()){
            Cursor fila = db.rawQuery("select * from USUARIOS where Usuario ='" + usuario+"'", null);
            /// revisa la consulta
            if(fila.moveToFirst()){
                Cursor fila2 = db.rawQuery("select * from USUARIOS where Contrasenia ='" + contrasenia+"'", null);
                if(fila2.moveToFirst()){
                    Toast.makeText(this,"Bienvenido "+usuario,Toast.LENGTH_SHORT).show();

                    // cambio de Actividad
                    Intent i = new Intent(MainActivity.this, PrimerActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"No se encuentra el usuario",Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }
    }


    public void Registrar(View view2){

        SQLHelper chelp = new SQLHelper( this,"UsuariosDB",null,1);
        //insetando datos//
        SQLiteDatabase db = chelp.getWritableDatabase();
        String usuario=user.getText().toString();
        String contrasenia=password.getText().toString();
        if(!usuario.isEmpty() && !contrasenia.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("Codigo",1);
            registro.put("Usuario",usuario);
            registro.put("Contrasenia",contrasenia);

            db.insert("USUARIOS",null,registro);
            db.close();
            Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Debes llenar todos los campos",Toast.LENGTH_SHORT).show();
        }

    }
}
