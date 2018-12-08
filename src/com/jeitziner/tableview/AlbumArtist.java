package com.jeitziner.tableview;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AlbumArtist {
	private final SimpleIntegerProperty albumId;
	private final SimpleStringProperty albumTitle;
	private final SimpleStringProperty artistName;

	public AlbumArtist(int albumId,
			String albumTitle,
			String artistName) {
		this.albumId = new SimpleIntegerProperty(albumId);
		this.albumTitle = new SimpleStringProperty(albumTitle);
		this.artistName = new SimpleStringProperty(artistName);
	}

	public static AlbumArtist createAlbumArtist(Integer albumId,
			String albumTitle, 
			String artistName) {
		return new AlbumArtist(albumId,
				albumTitle,
				artistName);
	}

	public Integer getAlbumId() {
		return this.albumId.get();
	}

	public void setAlbumId(Integer albumId) {
		this.albumId.set(albumId);
	}

	public String getAlbumTitle() {
		return this.albumTitle.get();
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle.set(albumTitle);
	}

	public String getArtistName() {
		return this.artistName.get();
	}

	public void setArtistName(String artistName) {
		this.artistName.set(artistName);
	}



}
