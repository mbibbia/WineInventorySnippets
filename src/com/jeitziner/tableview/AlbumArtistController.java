package com.jeitziner.tableview;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlbumArtistController {
	private AlbumArtistModel model;
	private AlbumArtistView view;
	
	public AlbumArtistController(AlbumArtistModel model,
								 AlbumArtistView view) {
		this.model = model;
		this.view = view;
		
		this.view.connect(this.model.getData());
		setColumns();
		
		// Set Actions
		setActions();
	}
	
	void loadAlbumArtistView() {
		this.model.readSomeRecordsFromDb();
	}
	
	void loadNext() {
		this.model.next();
		loadAlbumArtistView();
	}
	
	void loadPrev() {
		this.model.prev();
		loadAlbumArtistView();
	}
	
	private void setColumns() {
		TableView<AlbumArtist> table = this.view.getTable();
		this.model.setColumns(table);		
	}
	
	private void setActions() {
		Button nextButton = this.view.getNextButton();		
		nextButton.setOnAction(event -> loadNext());

		Button prevButton = this.view.getPrevButton();
		prevButton.setOnAction(event-> loadPrev());
	}
		
}
