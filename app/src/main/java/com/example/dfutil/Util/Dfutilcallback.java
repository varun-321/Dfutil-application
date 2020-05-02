package com.example.dfutil.Util;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class Dfutilcallback extends DiffUtil.Callback {
      private List<String> oldlist;
       private List<String> newlist;
            public Dfutilcallback(List<String> oldlist, List<String> newlist )
            {

                  this.oldlist=oldlist;
                    this.newlist=newlist;


            }




    @Override
    public int getOldListSize() {
        return oldlist.size();
    }

    @Override
    public int getNewListSize() {
        return newlist.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldItemPosition== newItemPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldlist.get(oldItemPosition)==newlist.get(newItemPosition);
    }
}
