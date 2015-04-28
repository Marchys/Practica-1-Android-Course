package com.example.marcelba.transitions;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    ViewGroup mainLinear;
    ViewGroup frame;
    private Scene scene_a, scene_b;
    private boolean sceneA = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLinear = (ViewGroup)findViewById(R.id.layout);
        frame = (ViewGroup)findViewById(R.id.frame);

        scene_a = Scene.getSceneForLayout(frame, R.layout.scene_a,this);
        scene_b = Scene.getSceneForLayout(frame, R.layout.scene_b,this);
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

        //noinspasdection SimplifiableIfStatement
        if (id == R.id.action_settings) {
           // TextView tempTextView = new TextView(this);
            //tempTextView.setText("Hello World!");
            //TransitionManager.beginDelayedTransition(mainLinear, new Explode());
            //mainLinear.addView(tempTextView);
            if(sceneA)TransitionManager.go(scene_b);
            else TransitionManager.go(scene_a);
            sceneA = !sceneA;
            return true;
        }



        return super.onOptionsItemSelected(item);
    }
}
