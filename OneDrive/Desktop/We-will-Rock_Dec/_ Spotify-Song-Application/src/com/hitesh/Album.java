
package com.hitesh;

import java.util.ArrayList;
import java.util.LinkedList;


public class Album {

    String albumName;
    String artistName;

    ArrayList<Song> songs;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songs=new ArrayList<Song>();
    }

    public boolean findSong(String title){
        for(Song track: songs){
            if(track.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public void addSongToAlbum(String title, double duration){
        if(!findSong(title)){
            //create object and then add
            songs.add(new Song(title,duration));
            System.out.println("Song added successfully.");
        }
        else{
            System.out.println("This song is already exist.");
        }
    }

    public void addToPlayList(int trackNo, LinkedList<Song> playList){
        //album is List of songs and ArrayList is zero based index
        int index=trackNo-1;

        //get the song object
        if(index>=0 && index<  songs.size()) {
            Song s = this.songs.get(index);

            //add to the playList
            playList.add(s);

        }
    }
    public void addToPlayList(String title,LinkedList<Song> playList){

        for(Song song: this.songs){
            if(song.getTitle().equals(title)){
                playList.add(song);
            }
        }
    }

}

