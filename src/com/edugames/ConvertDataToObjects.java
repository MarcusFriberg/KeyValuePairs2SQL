package com.edugames;
import java.io.File;
import java.util.*;

public class ConvertDataToObjects {
    private int nextArtistID = 1;
    private int nextSongID = 1;
    private final Set<String> uniqueArtists = new HashSet<>();
    private final List<Artist> artists = new ArrayList<>();
    private final List<Song> songs = new ArrayList<>();
    private String artist;
    private String title;
    private int rank;
    private int highestRank;
    private int weeksOnList;
    private String s;

    public ConvertDataToObjects() {

    }

    public Artist getArtistByName(String name) {
        Artist returnObject = null;
        for(Artist object : artists) {
            if(object.getArtistName().equals(name)) {
                returnObject = object;
            }
        }
        return returnObject;
    }

    public boolean loadDataAndCleanIt() {
        boolean rankIsFound = false;
        boolean weeksOnListIsFound = false;
        boolean highestRankIsFound = false;
        boolean artistIsFound = false;
        boolean titleIsFound = false;
        Scanner scanner = null;
        File file;

        try {
            file = new File("C:\\Users\\MarcusFriberg\\Utbildning\\Edugrade\\HT22\\Inlämningsuppgifter\\Java Programmering\\KeyValuePairs2SQL\\src\\com\\edugames\\data.txt");
            scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                s = scanner.nextLine();
                if(s.startsWith("rowid")) {
                    String[] rankArray = s.split(":");
                    rank = Integer.parseInt(rankArray[1]);
                    rankIsFound = true;
                }
                if(s.startsWith("pbpl")) {
                    String[] highestRankArray = s.split(":");
                    highestRank = Integer.parseInt(highestRankArray[1]);
                    highestRankIsFound = true;
                }
                if(s.startsWith("avli")) {
                    String[] weeksArray = s.split(":");
                    weeksOnList = Integer.parseInt(weeksArray[1]);
                    weeksOnListIsFound = true;
                }
                if(s.startsWith("arso")) {
                    String[] artistArray = s.split(":");
                    artist = artistArray[1];
                    artistIsFound = true;
                }
                if(s.startsWith("tit")) {
                    String[] titleArray = s.split(":");
                    title = titleArray[1];
                    titleIsFound = true;
                }
                if(rankIsFound && highestRankIsFound && weeksOnListIsFound && artistIsFound && titleIsFound) {
                    if(!uniqueArtists.contains(artist)) {
                        uniqueArtists.add(artist);
                        Artist artistObject = new Artist(nextArtistID, artist);
                        artists.add(artistObject);
                        nextArtistID ++;
                    }
                    songs.add(new Song(rank, weeksOnList, highestRank, getArtistByName(artist), title));
                    nextSongID ++;
                    rankIsFound = false;
                    weeksOnListIsFound = false;
                    highestRankIsFound = false;
                    artistIsFound = false;
                    titleIsFound = false;
                }
            }
        } catch(Exception e) {
            System.out.println("Failed reading the data");
        }
        return songs.size() == 100;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
