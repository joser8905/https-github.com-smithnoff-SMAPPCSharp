package com.appudo.rsmapp.smappcsharp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class preguntas extends AppCompatActivity {
    RadioGroup rdg;
    private Manejador manejador;
    RadioButton rb1,rb2,rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        manejador=new Manejador(this);
        TextView tp=(TextView)findViewById(R.id.textView);
        rb1=(RadioButton)findViewById(R.id.radioButton);//2131492943
        rb2=(RadioButton)findViewById(R.id.radioButton2);//2131492944
        rb3=(RadioButton)findViewById(R.id.radioButton3);//2131492945
        manejador.borrar();
        manejador.insertar("¿Que es la programacion orientada a objetos?","es un paradigma de programación que usa los objetos en sus "+
               " interacciones,para diseñar aplicaciones y programas informáticos.","es la ciencia de reparear objetos mediante codigo ","es una forma de escribir codigo usando objetos como herramienta de escritura",1,"2131492945");
        manejador.insertar("en verdad tu eres?","tu eres","mi padre","nooooooooo",1,"2131492943");
        manejador.leer();
        tp.setText(manejador.px);
        rb1.setText(manejador.ra);
        rb2.setText(manejador.rb);
        rb3.setText(manejador.rc);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preguntas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
