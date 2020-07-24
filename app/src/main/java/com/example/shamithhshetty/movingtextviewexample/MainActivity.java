package com.example.shamithhshetty.movingtextviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.movingtextview.MovingTextView;

public class MainActivity extends AppCompatActivity {

    MovingTextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        String str[]={"str","tgg","ff","efwef"};
       // txt.setMovingtexts(str);
        txt.startAnimation();
    }
    public void MyclickStart(View view){
        txt.startAnimation();
    }
    public void MyclickStop(View view){
        txt.stopAnimation();
    }
}
