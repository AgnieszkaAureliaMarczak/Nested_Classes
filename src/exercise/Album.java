package exercise;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs = new SongList();

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String title, double duration) {
        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (trackNumber < 1 || trackNumber > songs.songs.size()) {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
        playlist.add(songs.songs.get(trackNumber - 1));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songs.findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private Song findSong(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            for (Song song : this.songs) {
                if ((index >= 0) && (index <= this.songs.size())
                        && song.equals(this.songs.get(index))) {
                    return song;
                }
            }
            return null;
        }

        private boolean add(Song song) {
            if (this.songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        }
    }
}
