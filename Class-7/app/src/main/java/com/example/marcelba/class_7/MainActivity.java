package com.example.marcelba.class_7;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView texst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texst = (TextView) findViewById(R.id.racaApi);
        if(texst != null)
        {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
             {
                 texst.setText("Bien tienes lolipop");
             }else
            {
                texst.setText("Tienes version mala pringao");
            }

        }

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        texst.setText(texst.getText()+"\n onDestroy");
    }

    @Override
    protected void onPause(){
        super.onPause();
        texst.setText(texst.getText()+"\n onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        texst.setText(texst.getText()+"\n onRestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        texst.setText(texst.getText()+"\n onResume");
    }

    @Override
    protected void onStart(){
        super.onStart();
        texst.setText(texst.getText()+"\n onStart");
    }

    @Override
    protected void onStop(){
        super.onStop();
        texst.setText(texst.getText()+"\n onStop");
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
}
