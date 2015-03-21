package com.example.marcelba.notes_p8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity2 extends Activity {

    EditText titleNote;
    EditText bodyNote;
    Long idNote;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        titleNote = (EditText)findViewById(R.id.noteTitle);
        bodyNote = (EditText)findViewById(R.id.noteBody);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            idNote =  extras.getLong("id",20);
            String title =  extras.getString("title");
            String body =  extras.getString("body");
            titleNote.setText(title);
            bodyNote.setText(body);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

    @Override
    public void onPause(){
        super.onPause();
        String tempTitle= titleNote.getText().toString();
        String tempBody = bodyNote.getText().toString();
        if(!tempBody.matches("") && !tempTitle.matches("") && idNote == null) {

         MainActivity.db.addNote(tempTitle,tempBody);
        }
        else if(idNote != null)
        {
        MainActivity.db.updateNote(idNote, tempTitle, tempBody);
        }
    }


}
