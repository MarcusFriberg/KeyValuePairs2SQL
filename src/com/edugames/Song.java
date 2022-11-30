package com.edugames;

public class Song {
    private int songId;
    private int weeksOnList;
    private int highestRank;
    private Artist artist;
    private String title;

    public Song(int SongId, int weeksOnList, int highestRank, Artist artist, String title) {
        this.songId = SongId;
        this.weeksOnList = weeksOnList;
        this.highestRank = highestRank;
        this.artist = artist;
        this.title = title;
    }

    public int getSongId() {
        return songId;
    }

    public int getWeeksOnList() {
        return weeksOnList;
    }

    public int getHighestRank() {
        return highestRank;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }
}
