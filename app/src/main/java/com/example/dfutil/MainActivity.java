package com.example.dfutil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dfutil.Util.Myadapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

  Button insert,update;
    RecyclerView recyclerView;

     List<String> datasource = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
          recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

          insert = (Button)findViewById(R.id.btn_insert);

            update = (Button)findViewById(R.id.btn_update);

              initData();
        final Myadapter myadapter =  new Myadapter(datasource);

        recyclerView.setAdapter(myadapter);
          //  Event
             insert.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     List<String > insertlist = new ArrayList<>();   // Assign old data
                        for(int i=0;i<3;i++)
                              insertlist.add(UUID.randomUUID().toString());
                         myadapter.insertdata(insertlist);
                            recyclerView.smoothScrollToPosition(myadapter.getItemCount()-1);//auto scroll item to last
                 }
             });
                 update.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                          List<String > updatelist = new ArrayList<>();
                         for(int i=0;i<3;i++)
                             updatelist.add(UUID.randomUUID().toString());
                         myadapter.updatedata(updatelist);

                     }
                 });


    }

    private void initData() {

        for(int i=0;i<3;i++)
            datasource.add(UUID.randomUUID().toString());
    }


}
