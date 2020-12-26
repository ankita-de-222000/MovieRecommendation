package com.applex.movierecommendation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private ArrayList<DummyModel> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportActionBar()!=null)
            getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recycler);

        movieList = new ArrayList<>();
        createList();
        buildRecyclerView();

    }

    private void createList(){
        DummyModel model = new DummyModel();
        model.setDirector("Anurag Basu");
        model.setTitle("Ludo");
        model.setCategory("Movie");
        model.setImg("https://upload.wikimedia.org/wikipedia/en/a/af/Ludo_film_poster.jpg");

        movieList.add(model);

        DummyModel model2 = new DummyModel();
        model2.setDirector("Christopher Nolan");
        model2.setTitle("Tenet");
        model2.setCategory("Movie");
        model2.setImg("https://d13ezvd6yrslxm.cloudfront.net/wp/wp-content/images/tenet-overseas-release.jpg");

        movieList.add(model2);
    }

    private void buildRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        MovieAdapter adapter = new MovieAdapter(MainActivity.this, movieList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if(id == R.id.search){
           openSearchDialog();
           return true;
       }
        return super.onOptionsItemSelected(item);
    }

    public void openSearchDialog(){



    }
}