package com.parth.speakeridentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ProcessingActvity extends Activity {
    Button close;

    MediaPlayer mp=new MediaPlayer();
    Uri Audiopath;

    @Override
    protected void onDestroy() {
        if(mp. isPlaying()){
            mp.stop();
            Log.i("Mediapalyer","Stopped");

        }

        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);

        close = findViewById(R.id.closebtm);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width=dm.widthPixels;
        int height=dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;
        getWindow().setAttributes(params);


        Bundle  bundle= getIntent().getExtras();
        Audiopath = (Uri)bundle.get("path");
        try{
            mp.setDataSource(getApplicationContext(),Audiopath);

            mp.prepare();
            mp.setLooping(true);
            Log.i("Mediapalyer","Prepared");
            mp.start();
            Log.i("Mediapalyer","Started");

        }catch(Exception e){e.printStackTrace();}




        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                i.putExtra("Speaker","Andrew Ng");
                startActivity(i);
            }
        });

    }

}
