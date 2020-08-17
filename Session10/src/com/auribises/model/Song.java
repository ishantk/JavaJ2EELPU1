package com.auribises.model;

public class Song implements Comparable<Song>{

	public String title;
	public String artist;
	public double duration;
	
	// References to next and previous Songs
	public Song nextSong;			// HAS-A Relation | 1 to 1
	public Song previousSong;	    // HAS-A Relation | 1 to 1
	
	public Song(){
		
	}
	
	public Song(String title, String artist, double duration) {
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", duration=" + duration + "]";
	}

	@Override
	public int compareTo(Song song) {
		if(duration == song.duration) {
			return 0;
		}else if(duration > song.duration) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
}
