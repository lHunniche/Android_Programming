package io.ameal.lesson05_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        MyAdapter myAdapter = new MyAdapter(getRandomIntegers(1000));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);


        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Integer> getRandomIntegers(int amount)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < amount; i++)
        {
            arrayList.add((int) (Math.random() * 10000));
        }
        return arrayList;
    }
}
