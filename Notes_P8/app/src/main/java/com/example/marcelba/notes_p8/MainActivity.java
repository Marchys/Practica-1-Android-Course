package com.example.marcelba.notes_p8;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    public static DBProxy db;
    ListView noteTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBProxy(this);

        Cursor c = db.getAllNotes();

        String[] fromColumns = {db.databaseTitle,db.databaseNote};
        int[] toViews = {R.id.noteTitle,R.id.noteBody};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.note_row,c,fromColumns,toViews,0);
        noteTask = (ListView)findViewById(R.id.listView);
        noteTask.setAdapter(adapter);
        noteTask.setOnItemClickListener(this);
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

    public void changeActivity(View view){
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent (this, MainActivity2.class);

        i.putExtra("id",id);
        i.putExtra("title",((TextView) view.findViewById(R.id.noteTitle)).getText().toString());
        i.putExtra("body",((TextView) view.findViewById(R.id.noteBody)).getText().toString() );

        startActivity(i);
    }
}
