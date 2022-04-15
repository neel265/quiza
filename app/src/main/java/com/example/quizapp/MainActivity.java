package com.example.quizapp;

import static com.example.quizapp.splash_screen.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    int timervalue=20;
    RoundedHorizontalProgressBar progressBar;
    List<model> alllist;
    model model;
    int index=0;
    TextView te1,te2,te3,te4,te5;
    CardView card2,card3,card4,card5,card6;
    int correctcount=0;
    int wrongcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        getSupportActionBar ().hide ();
        progressBar=findViewById ( R.id.progress_bar_1 );
        te1=findViewById ( R.id.te1 );
        te2=findViewById ( R.id.te2 );
        te3=findViewById ( R.id.te3 );
        te4=findViewById ( R.id.te4 );
        te5=findViewById ( R.id.te5 );
        card2=findViewById ( R.id.card2 );
        card3=findViewById ( R.id.card3 );
        card4=findViewById ( R.id.card4);
        card5=findViewById ( R.id.card5 );
        card6=findViewById ( R.id.card6 );
        alllist=list;
        Collections.shuffle ( alllist );
        model=list.get(index);
        setAllData();

        countDownTimer =new CountDownTimer (20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue=timervalue-1;
                progressBar.setProgress ( timervalue );

            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog ( MainActivity.this);
                dialog.getWindow ().addFlags ( WindowManager.LayoutParams.FLAG_BLUR_BEHIND );
                dialog.setContentView ( R.layout.timeout );
                dialog.show ();
            dialog.findViewById ( R.id.timer ).setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent ( MainActivity.this,splash_screen.class );
                    startActivity ( intent );
                }
            } );
            }
        }.start ();

    }

    private void setAllData() {
        te1.setText ( model.getQuestion () );
        te2.setText ( model.getOa () );
        te3.setText ( model.getOb () );
        te4.setText ( model.getOc () );
        te5.setText ( model.getOd () );
    }
    public void correct(CardView cardView){
        cardView.setBackgroundColor ( getResources ().getColor ( R.color.green ) );
        card6.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                correctcount++;
                index++;
                model=list.get ( index );
                setAllData ();
                resetcolor ();
            }
        } );

    }
    public  void wrong(CardView cardView){
        cardView.setBackgroundColor ( getResources ().getColor ( R.color.red ) );
        card6.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                wrongcount++;
                if(index<list.size ()-1){
                    index++;
                    model=list.get ( index );
                    setAllData ();
                    resetcolor ();
                }
                else {
                    gameone();
                }
            }
        } );


    }

    private void gameone() {
        Intent intent=new Intent ( MainActivity.this,game.class );
        intent.putExtra ( "correct",correctcount );
        intent.putExtra ( "wrong",wrongcount );
        startActivity ( intent );
    }
    //only one time can user can use
    public void enable(){
        card2.setClickable ( true );
        card3.setClickable ( true );
        card4.setClickable ( true );
        card5.setClickable ( true );

    }
    public void disable(){
        card2.setClickable ( false );
        card3.setClickable ( false );
        card4.setClickable ( false );
        card5.setClickable ( false );

    }
    public void resetcolor(){
        card2.setBackgroundColor ( getResources ().getColor ( R.color.white ) );
        card3.setBackgroundColor ( getResources ().getColor ( R.color.white ) );
        card4.setBackgroundColor ( getResources ().getColor ( R.color.white ) );
        card5.setBackgroundColor ( getResources ().getColor ( R.color.white ) );
    }

    public void optionaclick(View view) {
        if(model.getOa ().equals ( model.getAns () )){
            card2.setBackgroundColor ( getResources ().getColor (R.color.green) );
            if(index<list.size ()-1){
                correct (card2);
            }
            else {
                gameone();
            }
        }
        else {
            wrong ( card2 );

        }
    }

    public void optionbclick(View view) {
        if(model.getOb ().equals ( model.getAns () )){
            card3.setBackgroundColor ( getResources ().getColor (R.color.green) );
            if(index<list.size ()-1){
                correct (card3);
            }
            else {
                gameone();
            }
        }
        else {
            wrong ( card3 );

        }

    }

    public void optioncclick(View view) {
        if(model.getOc().equals ( model.getAns () )){
            card4.setBackgroundColor ( getResources ().getColor (R.color.green) );
            if(index<list.size ()-1){
                correct (card4);
            }
            else {
                gameone();
            }
        }
        else {
            wrong ( card4);

        }


    }

    public void optiondclick(View view) {
        if(model.getOd().equals ( model.getAns () )){
            card5.setBackgroundColor ( getResources ().getColor (R.color.green) );
            if(index<list.size ()-1){
                correct (card5);
            }
            else {
                gameone();
            }
        }
        else {
            wrong ( card5);

        }



    }
}