package com.example.ayushkumar.infinitecardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ayushkumar on 21/02/18.
 */

public class CardAdapter extends BaseAdapter
{
    private Context context;
    private List<Integer> images;

    public CardAdapter(Context context, List<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_card,viewGroup,false);
        view.setBackgroundResource(images.get(i));


        return view;
    }
}
