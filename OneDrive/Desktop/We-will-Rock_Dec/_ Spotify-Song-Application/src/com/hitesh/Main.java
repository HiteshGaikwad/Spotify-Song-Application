package com.hitesh;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Album> albums=new ArrayList<Album>();
    public static void main(String[] args) {
	// write your code here
        Album album=new Album("album1","AC/DC");
        
        album.addSongToAlbum("TNT", 4.5);
        album.addSongToAlbum("Highway To Hell", 3.5);
        album.addSongToAlbum("ThunderStruck", 5.0);
        albums.add(album);
        
        album =new Album("Album2","Eminem");

        album.addSongToAlbum("Rap God", 4.5);
        album.addSongToAlbum("Not Afraid", 3.5);
        album.addSongToAlbum("Love yourself", 4.5);
        
        albums.add(album);
        
        LinkedList<Song> playList_1= new LinkedList<Song>();
        
        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway To Hell",playList_1);
        albums.get(1).addToPlayList("Rap God",playList_1);
        albums.get(1).addToPlayList("Love yourself",playList_1);

        play(playList_1);
    }

    public static void play(LinkedList<Song> playList){

        printMenu();


        ListIterator<Song> listIterator= playList.listIterator();
        boolean forward=false;;

        if(playList.size()>0){
            System.out.println("Playing the first song"+playList.get(0).toString());
            System.out.println(listIterator.next().toString());

        }else{
            System.out.println("PlayList is empty");
            return;
        }
        System.out.println("Enter your option");

        boolean quit=false;
        Scanner sc=new Scanner(System.in);

        while(quit==false){
            int option=sc.nextInt();

            switch(option) {

                case 0:
                    quit = true;
                    break;

                case 1:
                    if(forward == false) {
                        listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Playing next Song");
                        System.out.println(listIterator.next().toString());
                        forward = true;
                    }
                    else{
                        System.out.println("you are at last Song");
                        forward=false;
                    }
                    break;

                case 2:
                    if(forward==true){
                        listIterator.previous();
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Playing previous Song");
                        System.out.println(listIterator.previous().toString());
                        forward=false;
                    }
                    else{
                        System.out.println("you are the First song");
                        forward=false;
                    }
                    break;

                case 3:
                    if(forward==true) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Repeating current song");
                            System.out.println(listIterator.previous().toString());
                            forward = false;
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Repeating current song");
                            System.out.println(listIterator.next().toString());
                            forward=true;
                          }
                        }
                    break;

                case 4:
                    System.out.println("Printing all the Songs");
                    printAllSongs(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(forward==true){
                        listIterator.previous();
                        forward=false;
                    }
                    if(listIterator.hasNext())
                        //deleting current song
                        System.out.println("Deleting the current Song"+"\n"+playList.get(listIterator.nextIndex()).toString());
                    listIterator.remove();
                    forward=true;
                    break;
               }

             }
        }

        static void printAllSongs(LinkedList<Song> playList){
        for(Song songs: playList){
            System.out.println(songs.toString());
        }
        }

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - ti quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - to list of all songs\n"+
                "5 - to print all available options\n"+
                "6 - to delete current song\n");
    }
}
