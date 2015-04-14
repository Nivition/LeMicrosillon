package com.nicolasbourgoin.lemicrosillon;

/**
 * Created by Nicolas on 10/04/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
    // Declare Variables
    String album;
    String artiste;
    String genre;
    String prix;
    String details;
    String flag;
    String position;
    ImageLoader imageLoader = new ImageLoader(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.singleitemview);

        Intent i = getIntent();
        // Get the result of rank
        album = i.getStringExtra("album");
        // Get the result of country
        artiste = i.getStringExtra("artiste");
        // Get the result of population
        genre = i.getStringExtra("genre");
        prix = i.getStringExtra("prix");
        details = i.getStringExtra("details");
        // Get the result of flag
        flag = i.getStringExtra("flag");

        // Locate the TextViews in singleitemview.xml
        TextView txtalbum = (TextView) findViewById(R.id.album);
        TextView txtartiste = (TextView) findViewById(R.id.artiste);
        TextView txtgenre = (TextView) findViewById(R.id.genre);
        TextView txtprix = (TextView) findViewById(R.id.prix);
        TextView txtdetails = (TextView) findViewById(R.id.details);

        // Locate the ImageView in singleitemview.xml
        ImageView imgflag = (ImageView) findViewById(R.id.pochette);

        // Set results to the TextViews
        txtalbum.setText(album);
        txtgenre.setText(genre);
        txtartiste.setText(artiste);
        txtprix.setText(prix);
        txtdetails.setText(details);

        // Capture position and set results to the ImageView
        // Passes flag images URL into ImageLoader.class
        imageLoader.DisplayImage(flag, imgflag);
    }
}