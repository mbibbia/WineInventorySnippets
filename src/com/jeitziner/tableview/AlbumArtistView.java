package com.jeitziner.tableview;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class AlbumArtistView {
	private final TableView<AlbumArtist> table;
	private final Label title;
	private final Button prevButton;
	private final Button nextButton;
		
	public AlbumArtistView(String title) {
		this.table = new TableView<AlbumArtist>();
		this.title = new Label(title);
		this.prevButton = new Button("<<");
		this.nextButton = new Button(">>");		
	}
	
	Button getPrevButton() {
		return this.prevButton;
	}

	Button getNextButton() {
		return this.nextButton;
	}
	
	public Pane getPane() {
		final VBox vBox = new VBox();
		vBox.setSpacing(5);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		
		final HBox hBox = new HBox();
		hBox.getChildren().addAll(this.prevButton, this.nextButton);
		
		vBox.getChildren().addAll(this.title, this.table, hBox);
		
		VBox.setVgrow(this.title, Priority.ALWAYS);
		VBox.setVgrow(this.table, Priority.ALWAYS);
		VBox.setVgrow(hBox, Priority.ALWAYS);
		
		return vBox;
	}
	
	public void connect(ObservableList<AlbumArtist> data) {
		this.table.setItems(data);
	}
	
	public TableView<AlbumArtist> getTable() {
		return this.table;
	}
}
