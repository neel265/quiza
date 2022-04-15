package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class splash_screen extends AppCompatActivity {

    public static   ArrayList<model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        getSupportActionBar ().hide ();
        setContentView ( R.layout.activity_splash_screen );
        list=new ArrayList <> (  );
        list.add ( new model ( "What is full form of the HtML","HYPERTEXT MARKUP LANUAGE","MARKUP LANGUAGE","A OR B BOTH","NONE OF ABOVE","HYPERTEXT MARKUP LANUAGE" ) );
        list.add ( new model ( "What is full form of the php","Personal Home Page","Hypertext Preprocesser","A OR B BOTH","NONE OF ABOVE","A OR B BOTH" ) );
        list.add ( new model ( "java is a object oriented language","True","False","A OR B BOTH","NONE OF ABOVE","True" ) );
        list.add ( new model ( "what is full form of the JDK","Development kit","Java development kit","A OR B BOTH","NONE OF ABOVE","Java development kit" ) );
        list.add ( new model ( "what is Array","Collection of the same data type of element","Array is collection of the same datatype and same element","A OR B BOTH","NONE OF ABOVE","Array is collection of the same datatype and same element" ) );



        Thread thread=new Thread (  ){

            public void run(){
                try {
                    sleep ( 3000 );
                }
                catch (Exception e){
                    e.printStackTrace ();
                }
                finally {
                    Intent intent=new Intent ( splash_screen.this,MainActivity.class );
                    startActivity ( intent );
                };
            }
        };thread.start ();
    }
}