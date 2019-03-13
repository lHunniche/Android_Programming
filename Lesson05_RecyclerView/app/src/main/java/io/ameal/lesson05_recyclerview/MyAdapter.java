package io.ameal.lesson05_recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    private static ArrayList<Integer> data;

    public MyAdapter(ArrayList<Integer> randomIntegers)
    {
        this.data = randomIntegers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_numberlist, viewGroup, false);
        TextView textView = view.findViewById(R.id.numberTextView);

        MyViewHolder viewHolder = new MyViewHolder(view, textView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        myViewHolder.textView.setText(data.get(i).toString());
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textView;
        public MyViewHolder(@NonNull View itemView, TextView textView)
        {
            super(itemView);
            this.textView = textView;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view)
        {
            MyAdapter.data.remove(getLayoutPosition());
            Log.e("OWO", "OWO");
        }
    }



}
