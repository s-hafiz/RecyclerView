package com.begginers.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import adapter.MoviesAdapter;
import java_class.Movie;

public class MainActivity extends AppCompatActivity {

    //Creating list array
    private List<Movie> movieList=new ArrayList<>(30);

    //Creating recycler view object
    RecyclerView recyclerView;

    //Creating adapter object
    MoviesAdapter moviesAdapter;

    private int requestCode=1;
    private Movie movie;
    private LinearLayoutManager mLayoutManager;
    private Parcelable perce;

    //Creating three variable to get result from value activity
    private String title,genre,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initialization
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        moviesAdapter=new MoviesAdapter(this,movieList);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(moviesAdapter);
        


       // prepareMovieData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(this,ValueActivity.class);
                startActivityForResult(intent,requestCode);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==resultCode){
            title=data.getStringExtra("TITLE");
            genre=data.getStringExtra("GENRE");
            year=data.getStringExtra("YEAR");
            movie= new Movie(title,genre,year);
            movieList.add(movie);
            moviesAdapter.notifyDataSetChanged();
        }
    }


}
