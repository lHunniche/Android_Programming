package io.ameal.lesson05_recyclerview;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{

    private static ArrayList<Integer> data;
    private static ArrayList<RemovedItem> removedItems;
    private AppCompatActivity context;

    public MyAdapter(AppCompatActivity context, ArrayList<Integer> randomIntegers)
    {
        data = randomIntegers;
        removedItems = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_numberlist, viewGroup, false);
        TextView textView = view.findViewById(R.id.numberTextView);

        MyViewHolder viewHolder = new MyViewHolder(view, textView, this);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
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



    private void showUndoAction()
    {
        Snackbar snackbar = Snackbar.make(context.findViewById(R.id.myCoordinatorLayout), "Removed an element", Snackbar.LENGTH_LONG);
        snackbar.setAction("UNDO", new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                RemovedItem removedItem = removedItems.remove(removedItems.size()-1);
                data.add(removedItem.index, removedItem.value);
                notifyDataSetChanged();
            }
        });
        snackbar.show();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textView;
        MyAdapter myAdapter;
        public MyViewHolder(@NonNull View itemView, TextView textView, MyAdapter myAdapter)
        {
            super(itemView);
            this.textView = textView;
            this.textView.setOnClickListener(this);
            this.myAdapter = myAdapter;

        }

        @Override
        public void onClick(View view)
        {
            int layoutPosition = getLayoutPosition();
            int removedData = data.remove(getLayoutPosition());
            myAdapter.notifyDataSetChanged();
            removedItems.add(new RemovedItem(layoutPosition, removedData));
            myAdapter.showUndoAction();
        }
    }

    public static class RemovedItem
    {
        int index;
        int value;

        public RemovedItem(int index, int value)
        {
            this.index = index;
            this.value = value;
        }
    }





}
