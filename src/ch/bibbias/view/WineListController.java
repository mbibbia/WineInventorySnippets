package ch.bibbias.view;

import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import ch.bibbias.app.MainApp;
import ch.bibbias.model.Wine;

public class WineListController {
	@FXML
	private TableView<Wine> wineTable;
	@FXML
	private TableColumn<Wine, Long> wineIdColumn;
	@FXML
	private TableColumn<Wine, String> wineNameColumn;
	@FXML
	private TableColumn<Wine, String> wineTypeColumn;
	@FXML
	private TableColumn<Wine, String> wineClassificationColumn;
	@FXML
	private TableColumn<Wine, String> wineCountryColumn;
	@FXML
	private TableColumn<Wine, String> wineRegionColumn;
	@FXML
	private TableColumn<Wine, String> wineProducerColumn;

	@FXML
	private Label wineIdLabel;
	@FXML
	private Label wineNameLabel;
	@FXML
	private Label wineTypeLabel;
	@FXML
	private Label wineClassificationLabel;
	@FXML
	private Label wineCountryLabel;
	@FXML
	private Label wineRegionLabel;
	@FXML
	private Label wineProducerLabel;

	// Reference to the main application.
	private MainApp mainApp;

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public WineListController() {

	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the wine table with columns.
		wineIdColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
		wineNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		wineTypeColumn.setCellValueFactory(cellData -> cellData.getValue().getTypeProperty());
		wineClassificationColumn.setCellValueFactory(cellData -> cellData.getValue().getClassificationProperty());
		wineCountryColumn.setCellValueFactory(cellData -> cellData.getValue().getCountryProperty());
		wineRegionColumn.setCellValueFactory(cellData -> cellData.getValue().getRegionProperty());
		wineProducerColumn.setCellValueFactory(cellData -> cellData.getValue().getProducerProperty());

		// Clear wine details.
		showWineDetails(null);

		// Listen for selection changes and show the wine details when changed.
		wineTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showWineDetails(newValue));

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		wineTable.setItems(mainApp.getWineList());
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 * 
	 * @param person the person or null
	 */
	private void showWineDetails(Wine wine) {
		if (wine != null) {
			// Fill the labels with info from the wine object.
			wineIdLabel.setText(Long.toString(wine.getId()));
			wineNameLabel.setText(wine.getName());
			wineTypeLabel.setText(wine.getType().getName());
			wineClassificationLabel.setText(wine.getClassification().getCode());
			wineCountryLabel.setText(wine.getCountry().getCode());
			wineRegionLabel.setText(wine.getRegion().getName());
			wineProducerLabel.setText(wine.getProducer().getName());

		} else {
			// Wine is null, remove all the text.
			wineIdLabel.setText("");
			wineNameLabel.setText("");
			wineTypeLabel.setText("");
			wineClassificationLabel.setText("");
			wineCountryLabel.setText("");
			wineRegionLabel.setText("");
			wineProducerLabel.setText("");
		}
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeleteWine() {
		int selectedIndex = wineTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			wineTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Wine Selected");
			alert.setContentText("Please select a wine in the table.");

			alert.showAndWait();
		}

	}

}
