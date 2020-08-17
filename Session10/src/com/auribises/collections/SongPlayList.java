package com.auribises.collections;

import com.auribises.model.Song;

public class SongPlayList {

	public static void main(String[] args) {
		
		Song song1 = new Song("1. Blue Eyes", "Honey Singh", 4.5);
		Song song2 = new Song("2. High Heels", "Honey Singh", 4.5);
		Song song3 = new Song("3. Sunny Sunny", "Honey Singh", 6.5);
		Song song4 = new Song("4. Party All Night", "Honey Singh", 8.5);
		Song song5 = new Song("5. Urvashi", "Honey Singh", 2.5);
		
		
		song1.nextSong = song2;
		song2.nextSong = song3;
		song3.nextSong = song4;
		song4.nextSong = song5;
		song5.nextSong = song1;
		
		song1.previousSong = song5;
		song2.previousSong = song1;
		song3.previousSong = song2;
		song4.previousSong = song3;
		song5.previousSong = song4;
		
		// why we must structure the data ?
		// so that search, sort, filter becomes very economical w.r.t. time
		// i.e. optimizations w.r.t time :)
		
		Song song = song1;
		
		while(song.nextSong != song1) {
			System.out.println(song);
			song = song.nextSong;
		}
		System.out.println(song);
		
		System.out.println("~~~~~~~~~~~~");
		
		song = song5;
		while(song.previousSong != song5) {
			System.out.println(song);
			song = song.previousSong;
		}
		
		System.out.println(song);
		
	}

}
