package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class game extends AppCompatActivity {
    CircularProgressBar  circularProgressBar;
    TextView result;
    int correct,wrong;
    RelativeLayout re3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_game );
        getSupportActionBar ().hide ();

        correct=getIntent ().getIntExtra ( "correct",0 );
        correct=getIntent ().getIntExtra ( "wrong",0 );

        circularProgressBar=findViewById ( R.id.circularProgressBar);
        result=findViewById ( R.id.result );
        re3=findViewById ( R.id.re3 );
        circularProgressBar.setProgress ( correct );
        result.setText ( correct+ "/5" );
        re3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nI got"+correct+"out of 20 questions";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        } );

    }
}