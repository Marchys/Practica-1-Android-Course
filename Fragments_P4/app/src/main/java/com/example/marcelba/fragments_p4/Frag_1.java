package com.example.marcelba.fragments_p4;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag_1 extends Fragment implements View.OnClickListener{

    View viewMine;
    ChangeTextFragment myCallback;


    public Frag_1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewMine= inflater.inflate(R.layout.fragment_frag_1, container, false);
        Button button1 = (Button) viewMine.findViewById(R.id.buttonFragment1);
        button1.setOnClickListener(this);
        return viewMine;
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        myCallback = (ChangeTextFragment)activity;
    }
    @Override
    public void onClick(View v){
        myCallback.ChangeText("fragment 1");
        //((MainActivity)getActivity()).ChangeText("fragment 1");
    }
    void ChangeText(String text){
        TextView textMain = (TextView)viewMine.findViewById(R.id.textFragment1);
        textMain.setText(text);
    }

}
