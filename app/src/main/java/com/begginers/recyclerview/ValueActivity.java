package com.begginers.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import java_class.Movie;

public class ValueActivity extends AppCompatActivity {

    //Creating Views
    EditText et_title,et_genre,et_year;
    Button btnSubmit;

    //Creating the result code
    private int setResult=1;

    //Creating movie list
    private List<Movie> movieList=new ArrayList<>(30);

    //Creating three string variable
    private String title,genre,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);

        //initialization
        initView();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Getting value from the edit text
                title=et_title.getText().toString();
                genre=et_genre.getText().toString();
                year=et_year.getText().toString();

                //Creating an intent for sending the result to the host activity
                Intent myIntent = new Intent();

                //Putting value like key and value pair
                myIntent.putExtra("TITLE",title);
                myIntent.putExtra("GENRE",genre);
                myIntent.putExtra("YEAR",year);

                //sending the result using intent
                setResult(setResult,myIntent);

                //finishing activity
                finish();
            }
        });


    }

    private void initView() {
        et_title= (EditText) findViewById(R.id.et_title);
        et_genre= (EditText) findViewById(R.id.et_genre);
        et_year= (EditText) findViewById(R.id.et_year);
        btnSubmit= (Button) findViewById(R.id.btn_Show);
    }
}
