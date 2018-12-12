package com.jeitziner.dynview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {

	private Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {

			Map<Integer, Group> groupMap = readConfig();
			Group topGroup = groupMap.get(1);

			scene = new Scene(topGroup.getRegion(),800,800);
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

	public static Pane createButtonPane(String cssClass) {
		Button button = new Button(); 
		button.setText(String.format(".%s", cssClass));
		button.getStyleClass().add(cssClass);		

		final StackPane stackPane = new StackPane();
		stackPane.getChildren().add(button);

		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);

		return stackPane;		
	}

	public Map<Integer, Group> readConfig() throws IOException {
		String jsonFile = "config/desktop.json";
		InputStream fis = new FileInputStream(jsonFile);

		//create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);

		//get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();

		//we can close IO resource and JsonReader now
		jsonReader.close();
		fis.close();

		//Retrieve data from JsonObject and create Employee bean
		System.out.println(jsonObject.getString("lang"));
		System.out.println(jsonObject.getString("database"));

		// Read temp map of folders
		Map<Integer, Folder> tempFolderMap = new HashMap<Integer, Folder>();
		JsonArray folders = jsonObject.getJsonArray("folders");
		for (int i = 0; i < folders.size(); ++i) {
			JsonObject folderObj = folders.getJsonObject(i);
			int folderId = folderObj.getInt("id");
			String folderType = folderObj.getString("type");
			tempFolderMap.put(folderId, new Folder(folderId, folderType));
		}

		List<Group> groups = new ArrayList<Group>();
		Map<Integer, Group> tempGroupMap = new HashMap<Integer, Group>();
		// Read "groups" to create a list of "group" objects.
		JsonArray grps = jsonObject.getJsonArray("groups");
		for (int i = 0; i < grps.size(); ++i) {
			JsonObject grpObj = grps.getJsonObject(i);
			int id = grpObj.getInt("id");
			Group group = new Group();
			group.setId(id);
			group.setOrientation(grpObj.getString("orientation"));
			tempGroupMap.put(group.getId(), group);
		}

		// Read "groups" again to initialize the "group" objects.
		for (int i = 0; i < grps.size(); ++i) {
			JsonObject grpObj = grps.getJsonObject(i);
			Group group = tempGroupMap.get(grpObj.getInt("id"));
			if (group == null) {
				continue;
			}

			JsonArray subgrps = grpObj.getJsonArray("subgroups");
			System.out.println(String.format("size: %d", subgrps.size()));

			for (int j = 0; j < subgrps.size(); ++j) {
				JsonObject subObj = subgrps.getJsonObject(j);
				int subObjId = subObj.getInt("id");
				String type = subObj.getString("type");
				if (type.equals("group")) {
					Group subGroup = tempGroupMap.get(subObjId);
					if (subGroup == null) {
						continue;
					}
					System.out.println("add subgroup");
					group.addChild(subGroup);
				} else if (type.equals("folder")) {					
					Folder folder = tempFolderMap.get(subObjId);
					group.addChild(folder);
				}
			}
		}

		return tempGroupMap;
	}


}
