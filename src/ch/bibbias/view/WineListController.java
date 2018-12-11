package ch.bibbias.view;

import javafx.scene.control.TableView;
import javafx.fxml.FXML;
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

}
