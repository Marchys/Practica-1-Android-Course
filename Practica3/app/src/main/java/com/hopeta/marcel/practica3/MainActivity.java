package com.hopeta.marcel.practica3;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    public void getDatAndSend(View v) {

        EditText name = (EditText) findViewById(R.id.name);
        EditText surname = (EditText) findViewById(R.id.surname);
        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        Switch s = (Switch) findViewById(R.id.thisSwitch);
        SeekBar seekThing = (SeekBar) findViewById(R.id.seekBar);

        TextView checked = (TextView) findViewById(radio.getCheckedRadioButtonId());

        EditText birth = (EditText) findViewById(R.id.birthdate);

        String personName = name.getText().toString();

        String personSurname =  surname.getText().toString();
        String sex = s.getText().toString();

        String studying="aaa";
        if(s.isChecked()){
            studying="yes";
        }else{
            studying="no";
        }
        int weightInter = seekThing.getProgress();
        String weight = Integer.toString(weightInter);

        String birthDate =  birth.getText().toString();


        Intent i = new Intent(this, MainActivity2Activity.class);
        i.putExtra("name",personName);
        i.putExtra("surname",personSurname);
        i.putExtra("sex",sex);
        i.putExtra("studying",studying);
        i.putExtra("weight",weight);
        i.putExtra("birth",birthDate);
        startActivity(i);

    }


}
