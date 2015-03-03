package com.example.marcelba.fragments_p4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements ChangeTextFragment {

    //private boolean isFragment2 = true;
    private TextView baseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null)return;

        baseText = (TextView)findViewById(R.id.textView);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container1,new Frag_1())
                .commit();

        getFragmentManager()
                .beginTransaction()
                .add(R.id.container2,new Frag_2())
                .commit();
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

       /*    if(isFragment2) {
               getFragmentManager()
                       .beginTransaction()
                       .replace(R.id.container1, new Frag_1())
                       .commit();
           }else{
               getFragmentManager()
                       .beginTransaction()
                       .replace(R.id.container1, new Frag_2())
                       .commit();
           }
            isFragment2=!isFragment2;*/

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendDataToF1(View view) {
        Frag_1 F1 =(Frag_1)getFragmentManager().findFragmentById(R.id.container1);
        if(F1 != null) F1.ChangeText("hello main");

    }

    public void sendDataToF2(View view) {
        Frag_2 F2 =(Frag_2)getFragmentManager().findFragmentById(R.id.container2);
        if(F2 != null) F2.ChangeText("hello main");
    }

    @Override
    public void ChangeText(String text) {
        baseText.setText(text);
    }
}
