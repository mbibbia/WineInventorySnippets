package com.jeitziner.tableview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Consumer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

interface Acceptor {
	void accept(ResultSet rs) throws SQLException;
}

public class AlbumArtistModel {

	private final ObservableList<AlbumArtist> data;
	private int limit;
	private int offset;

	public AlbumArtistModel() {
		this.data = FXCollections.observableArrayList();
		this.limit = 20;
		this.offset = 0;
	}

	public ObservableList<AlbumArtist> getData() {
		return this.data;
	}
	
	public void next() {
		if (this.offset + this.limit < getNumRecords()) {
			this.offset += this.limit;
		}
	}
	
	public void prev() {
		this.offset = Math.max(this.offset - this.limit, 0);
	}

	public void readData(ResultSet rs) throws SQLException {
		this.data.add(AlbumArtist.createAlbumArtist(rs.getInt(1),
				rs.getString(2),
				rs.getString(3)));	
	}
	
	public void readSomeRecordsFromDb() {
		this.data.clear();
		
		String query;
		query =  "SELECT albums.AlbumId, albums.Title, artists.Name";
		query += " FROM albums, artists";
		query += " WHERE albums.ArtistId = artists.ArtistId limit %d offset %d;";
		query = String.format(query, this.limit, this.offset);
	
		getResults(query, new Acceptor() {
			@Override
			public void accept(ResultSet rs) throws SQLException {
				data.add(AlbumArtist.createAlbumArtist(rs.getInt(1),
						rs.getString(2),
						rs.getString(3)));		
			}
		});	
	}
	
	int getNumRecords() {
		String query = "SELECT count(*) FROM albums;";
		
		final class CountAcceptor implements Acceptor {
			int count = 0;
			
			CountAcceptor() {				
			}
			
			@Override
			public void accept(ResultSet rs) throws SQLException {
				this.count = rs.getInt(1);
			}
		}
				
		CountAcceptor ca = new CountAcceptor();		
		getResults(query, ca);
		return ca.count;
	}
		
	public void getResults(String query, Acceptor acceptor) {
		Connection connection = null;  
		ResultSet resultSet = null;  
		Statement statement = null;  

		try {  
			String current = new java.io.File(".").getCanonicalPath();
			//System.out.print(String.format("Current path: %s", current));
			Class.forName("org.sqlite.JDBC");  
			connection = DriverManager.getConnection("jdbc:sqlite:db/chinook.db");  
			statement = connection.createStatement();  
			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				acceptor.accept(resultSet);
			}  
		} 
		catch (SQLException e) {  
			e.printStackTrace();  
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {  
			try {  
				resultSet.close();  
				statement.close();  
				connection.close();  
			} 
			catch (Exception e)	{  
				e.printStackTrace();  
			}  
		}  		
	}

	public void setColumns(TableView<AlbumArtist> table) {
		TableColumn<AlbumArtist, Integer> albumId = new TableColumn<AlbumArtist, Integer>("Id");
		albumId.setMinWidth(10);
		albumId.setCellValueFactory(new PropertyValueFactory<AlbumArtist, Integer>("albumId"));
		table.getColumns().add(albumId);

		TableColumn<AlbumArtist, String> albumTitle = new TableColumn<AlbumArtist, String>("Album");
		albumTitle.setMinWidth(300);
		albumTitle.setCellValueFactory(new PropertyValueFactory<AlbumArtist, String>("albumTitle"));
		table.getColumns().add(albumTitle);

		TableColumn<AlbumArtist, String> artistName = new TableColumn<AlbumArtist, String>("Künstler");
		artistName.setMinWidth(140);
		artistName.setCellValueFactory(new PropertyValueFactory<AlbumArtist, String>("artistName"));
		table.getColumns().add(artistName);
	}

}

