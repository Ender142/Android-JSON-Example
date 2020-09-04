package com.example.picassoveretrofit.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.picassoveretrofit.Models.Bilgi;
import com.example.picassoveretrofit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> list;
    Context context;

    public BilgiAdapter(List<Bilgi> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        TextView albumId, ID, title, urll;
        albumId = (TextView) convertView.findViewById(R.id.albumId);
        ID = (TextView) convertView.findViewById(R.id.ID);
        title = (TextView) convertView.findViewById(R.id.title);
        urll = (TextView) convertView.findViewById(R.id.urll);
        ImageView imageView;
        imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
        albumId.setText("" + list.get(position).getAlbumId());
        ID.setText("" + list.get(position).getId());
        title.setText(list.get(position).getTitle());
        urll.setText(list.get(position).getUrl());

        Picasso.get().load(list.get(position).getThumbnailUrl()).into(imageView);


        return convertView;
    }
}
