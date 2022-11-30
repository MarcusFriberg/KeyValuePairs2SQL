package com.edugames;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Artist> artists;
        List<Song> songs;

        ConvertDataToObjects objectCreator = new ConvertDataToObjects();
        if(objectCreator.loadDataAndCleanIt()) {
            artists = objectCreator.getArtists();
            songs = objectCreator.getSongs();
            System.out.println("------------------------------------------- SQL to populate artists table start on next line -------------------------------------------");
            System.out.println("INSERT INTO artists (artist_name) VALUES");
            for(Artist artist : artists) {
                System.out.print("(\'" + artist.getArtistName() + "\')");
                if(artists.indexOf(artist) == artists.size() -1) {
                    System.out.println(");");
                } else {
                    System.out.println(",");
                }
            }
            System.out.println("------------------------------------------- SQL to populate songs table start on next line -------------------------------------------");
            System.out.println("INSERT INTO songs (song_title, weeks_on_list, highest_rank, artist_id) VALUES");
            for(Song song : songs) {
                 System.out.print("(\'" + song.getTitle() + "\', " + song.getWeeksOnList() + ", " + song.getHighestRank() + ", " + song.getArtist().getArtistID() + ")");
                if(songs.indexOf(song) == songs.size() -1) {
                    System.out.println(");");
                } else {
                    System.out.println(",");
                }
            }
            System.out.println("------------------------------------------- SQL to populate rankings table start on next line -------------------------------------------");
            System.out.println("INSERT INTO rankings (current_ranking, song_id) VALUES");
            for(Song song : songs) {
                System.out.print("(" + song.getSongId() + ", " + song.getSongId() + ")");
                if(songs.indexOf(song) == songs.size() -1) {
                    System.out.println(");");
                } else {
                    System.out.println(",");
                }
            }
        } else {
            System.out.println("Failed to load the list of songs");
            artists = null;
            songs = null;
        }
    }
}
