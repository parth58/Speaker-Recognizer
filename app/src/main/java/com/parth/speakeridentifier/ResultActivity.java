package com.parth.speakeridentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        btn=findViewById(R.id.mainmenubtn);
        textView=findViewById(R.id.spkname);

        Bundle  bundle= getIntent().getExtras();
        String speaker_name = (String)bundle.get("Speaker");

        textView.setText(speaker_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }
        });
    }
}
