package com.nicolasbourgoin.lemicrosillon;

/**
 * Created by Nicolas on 09/04/15.
 */
public class Microsillon_Model {

    private int id;
    private String album;
    private String artiste;
    private int genre;
    private float prix;
    private String details;
    private boolean published;


    public Microsillon_Model(int id, String album, String artiste, int genre, float prix, String details, boolean published) {
        this.id = id;
        this.album = album;
        this.artiste = artiste;
        this.genre = genre;
        this.prix = prix;
        this.details = details;
        this.published = published;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}