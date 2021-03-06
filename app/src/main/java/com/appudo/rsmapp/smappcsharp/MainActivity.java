package com.appudo.rsmapp.smappcsharp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;

    AlertDialog levelDialog;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Introduccion","Sugerencias","Curso C#","Ejercicios"};
    int Numboftabs =4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void verabout(View v)
    {

        Intent i=new Intent(this,About.class);
        startActivity(i);
    }
    public void vercontent(View v)
    {
    Intent i=new Intent(this,contenido.class);
    startActivity(i);
    }
    public void metodo(View v)
    {
        final CharSequence[] items = {" Basico "," Medio "," Avanzado "};

        // Creating and Building the Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Seleciona un nivel Dificultad");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {

                Intent d=new Intent();

                switch (item) {
                    case 0:
                                     d.putExtra("nivel","Nivel Basico");
                        d.setClass(getBaseContext(),preguntas.class);
                        startActivity(d);
                        break;
                    case 1:
                        d.putExtra("nivel","Nivel Medio");
                        d.setClass(getBaseContext(),preguntas.class);
                        startActivity(d);

                        break;
                    case 2:
                        d.putExtra("nivel","Nivel Avanzado");
                        d.setClass(getBaseContext(),preguntas.class);
                        startActivity(d);
                        break;


                }
                levelDialog.dismiss();
            }
        });

        levelDialog = builder.create();
        levelDialog.show();


    }
}
