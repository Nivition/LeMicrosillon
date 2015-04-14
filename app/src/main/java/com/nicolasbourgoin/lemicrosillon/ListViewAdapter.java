package com.nicolasbourgoin.lemicrosillon;

/**
 * Created by Nicolas on 09/04/15.
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    ImageLoader imageLoader;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public ListViewAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
        imageLoader = new ImageLoader(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // Declare Variables
        TextView album;
        TextView artiste;
        TextView genre;
        TextView prix;
        TextView details;
        ImageView pochette;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);
        // Get the position
        resultp = data.get(position);

        // Locate the TextViews in listview_item.xml
        album = (TextView) itemView.findViewById(R.id.album);
        artiste = (TextView) itemView.findViewById(R.id.artiste);
        genre = (TextView) itemView.findViewById(R.id.genre);
        prix = (TextView) itemView.findViewById(R.id.prix);
        details = (TextView) itemView.findViewById(R.id.details);
        //pochette = (TextView) itemView.findViewById(R.id.pochette);

        // Locate the ImageView in listview_item.xml
        pochette = (ImageView) itemView.findViewById(R.id.pochette);

        // Capture position and set results to the TextViews
        album.setText(resultp.get(FullscreenActivity.ALBUM));
        artiste.setText(resultp.get(FullscreenActivity.ARTISTE));
        genre.setText(resultp.get(FullscreenActivity.GENRE));
        prix.setText(resultp.get(FullscreenActivity.PRIX));
        details.setText(resultp.get(FullscreenActivity.DETAILS));
        //

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(resultp.get(FullscreenActivity.POCHETTE), pochette);
        // Capture ListView item click
        itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Get the position
                resultp = data.get(position);
                Intent intent = new Intent(context, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("album", resultp.get(FullscreenActivity.ALBUM));
                // Pass all data country
                intent.putExtra("artiste", resultp.get(FullscreenActivity.ARTISTE));
                // Pass all data population
                intent.putExtra("prix",resultp.get(FullscreenActivity.PRIX));
                intent.putExtra("details",resultp.get(FullscreenActivity.DETAILS));
                // Pass all data flag
                intent.putExtra("pochette", resultp.get(FullscreenActivity.POCHETTE));
                // Start SingleItemView Class
                context.startActivity(intent);

            }
        });
        return itemView;
    }
}
