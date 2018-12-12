package ch.bibbias.app;

import java.io.IOException;

import ch.bibbias.model.Wine;
import ch.bibbias.model.WineList;
import ch.bibbias.view.WineEditDialogController;
import ch.bibbias.view.WineListController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private ObservableList<Wine> wineList;

	public MainApp() {
		wineList = FXCollections.observableArrayList(new WineList().get());

	}

	/**
	 * Returns the data as an observable list of Wines.
	 * 
	 * @return
	 */
	public ObservableList<Wine> getWineList() {
		return wineList;
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Meine Weine");

		initRootLayout();

		showWineList();
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showWineList() {
		try {
			// Load wine list.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/WineListView.fxml"));
			AnchorPane wineListView = (AnchorPane) loader.load();

			// Set wine list into the center of root layout.
			rootLayout.setCenter(wineListView);

			// Give the controller access to the main app.
			WineListController controller = loader.getController();
			controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens a dialog to edit details for the specified wine. If the user clicks OK,
	 * the changes are saved into the provided wine object and true is returned.
	 * 
	 * @param wine the wine object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showWineEditDialog(Wine wine) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("../view/WineEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Wine");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the wine into the controller.
			WineEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setWine(wine);

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
