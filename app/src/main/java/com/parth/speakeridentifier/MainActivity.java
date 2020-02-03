package com.parth.speakeridentifier;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button btn;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.choosefile);
        textView=findViewById(R.id.tv1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myFileintent= new Intent(Intent.ACTION_GET_CONTENT);
                myFileintent.setType("audio/*");
                startActivityForResult(myFileintent,10);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        Log.i("filepath", data.getData().getPath());
        Uri path = data.getData();
        Log.i("Real Path", path.toString());




        Intent i = new Intent(getApplicationContext(), ProcessingActvity.class);
        i.putExtra("path", path);
        startActivity(i);
        super.onActivityResult(requestCode, resultCode, data);
    }

}
