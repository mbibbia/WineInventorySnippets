package com.jeitziner.tableview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Sqlite Tableview sample");
			primaryStage.setWidth(600);
			primaryStage.setHeight(800);
			
			final AlbumArtistModel model = new AlbumArtistModel();
			final AlbumArtistView view = new AlbumArtistView("Albums");
			final AlbumArtistController controller = new AlbumArtistController(model, view);

			controller.loadAlbumArtistView();
			Pane pane = view.getPane();
			
			BorderPane borderPane = new BorderPane();
			borderPane.setCenter(pane);

			Scene scene = new Scene(borderPane);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {
		launch(args);
	}
}
