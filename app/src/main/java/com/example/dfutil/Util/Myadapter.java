package com.example.dfutil.Util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dfutil.R;

import java.util.List;

public class Myadapter extends RecyclerView.Adapter<Myadapter.Myviewholder> {

        List<String> datasource;

          public Myadapter(List<String> datasource)
          {
                this.datasource=datasource;

          }

            public void insertdata(List<String> insertlist)
            {  //  this function add new data to recycler view
                 Dfutilcallback  dfutilcallback = new Dfutilcallback(datasource,insertlist);

                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(dfutilcallback);
                  datasource.addAll(insertlist);

                     diffResult.dispatchUpdatesTo(this);

            }

    public void updatedata(List<String> newlist)
    {  //  this function will clear old  data   and add new
        Dfutilcallback  dfutilcallback = new Dfutilcallback(datasource,newlist);

        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(dfutilcallback);
          datasource.clear();
        datasource.addAll(newlist);

        diffResult.dispatchUpdatesTo(this);

    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview  = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_layout,parent,false);
          return  new Myviewholder(itemview);
    }

    @NonNull



    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

                 holder.textview.setText(datasource.get(position));
    }



    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myviewholder extends RecyclerView.ViewHolder
       {
              TextView textview;
           public Myviewholder(@NonNull View itemView) {
               super(itemView);
                 textview = (TextView)itemView.findViewById(R.id.my_text_view);

           }
       }
}
