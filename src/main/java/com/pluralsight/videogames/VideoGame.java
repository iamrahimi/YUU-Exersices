package com.pluralsight.videogames;

public class VideoGame {
//    title (text)
//    platform (text)
//    genre (text)
//    year (whole number)
//    rating (decimal number)

    private String title;
    private String platform;
    private String genre;
    int year;
    float rating;

    public VideoGame() {
    }

    public VideoGame(String title, String platform, String genre, int year, float rating) {
        this.title = title;
        this.platform = platform;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }


    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                '}';
    }
}
