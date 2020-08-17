package com.auribises.model;

public class Message {

	public String content;
	public String from;
	public String dateTimeStamp;
	
	public Message() {
		
	}
	
	public Message(String content, String from, String dateTimeStamp) {
		this.content = content;
		this.from = from;
		this.dateTimeStamp = dateTimeStamp;
	}

	@Override
	public String toString() {
		return "Message [content=" + content + ", from=" + from + ", dateTimeStamp=" + dateTimeStamp + "]";
	}
	
}

class ImageMessage extends Message{
	
}

class AudioMessage extends Message{
	
}

class AlbumMessage extends Message{
	
}
