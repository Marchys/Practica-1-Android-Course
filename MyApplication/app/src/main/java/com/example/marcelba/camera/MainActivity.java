package com.example.marcelba.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends Activity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 2;
    private ImageView mImageView;
    private Uri photo_file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView texty = (TextView)findViewById(R.id.thereiscamera);
        mImageView = (ImageView)findViewById(R.id.imagebox);
        PackageManager pm = getApplicationContext().getPackageManager();

        if(pm.hasSystemFeature(PackageManager.FEATURE_CAMERA))
        {
            texty.setText("There is Camera");
        }else
        {
            texty.setText("There is not a Camera");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private File GetPhotoFile(){
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File photo = null;

        try{
            photo = File.createTempFile("mifoto",".jpg",dir);
        }
        catch(IOException ex){ }

        return photo;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {
            case R.id.action_settings:
                Intent intentphoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if( intentphoto.resolveActivity(getPackageManager()) != null){
                    photo_file = Uri.fromFile(GetPhotoFile());
                    intentphoto.putExtra(MediaStore.EXTRA_OUTPUT, photo_file);
                    startActivityForResult(intentphoto, REQUEST_IMAGE_CAPTURE);
                }
                return true;
            case R.id.captureVideo:
                Intent intentmedia = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if(intentmedia.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intentmedia, REQUEST_VIDEO_CAPTURE);
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data){
        if(resultcode != RESULT_OK)return;
        switch(requestcode)
        {
            case REQUEST_IMAGE_CAPTURE:
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap)extras.get("data");
                mImageView.setImageBitmap(imageBitmap);
                break;
            case REQUEST_VIDEO_CAPTURE:
                VideoView videbox = (VideoView)findViewById(R.id.videobox);
                Uri extras2 = data.getData();
                videbox.setVideoURI(extras2);
                videbox.start();
                break;

        }

     }


}
