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
            for(Artist artist : artists) {
                System.out.println("INSERT INTO artists (artist_name) VALUES (\"" + artist.getArtistName() + "\");");
            }
            System.out.println("INSERT INTO songs (song_title, weeks_on_list, highest_rank, artist_id) VALUES");
            for(Song song : songs) {
                 System.out.println("(\"" + song.getTitle() + "\", \"" + song.getWeeksOnList() + "\", \"" + song.getHighestRank() + "\"," + song.getArtist().getArtistID() + "),");
            }
            System.out.println(";");
            for(Song song : songs) {
                System.out.println("INSERT INTO rankings (current_ranking, song_id) VALUES (" + song.getSongId() + ", " + song.getSongId() + ");");
            }
        } else {
            System.out.println("Failed to load the list of songs");
            artists = null;
            songs = null;
        }
    }
}
