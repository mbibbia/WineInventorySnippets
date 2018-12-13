package ch.bibbias.view;

import ch.bibbias.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Dialog to edit details of a wine.
 * 
 * @author Marco Bibbia
 */

public class WineEditDialogController {

	@FXML
	private TextField wineIdField;
	@FXML
	private TextField wineNameField;
	@FXML
	private ChoiceBox<WineType> wineTypeBox;
	@FXML
	private ChoiceBox<WineClassification> wineClassificationBox;
	@FXML
	private ChoiceBox<Country> wineCountryBox;
	@FXML
	private ChoiceBox<Region> wineRegionBox;
	@FXML
	private ChoiceBox<Producer> wineProducerBox;

	private Stage dialogStage;
	private Wine wine;
	private boolean okClicked = false;
	ObservableList<WineType> wineTypeList = FXCollections.observableArrayList(new WineTypeList().get());
	ObservableList<WineClassification> wineClassificationList = FXCollections
			.observableArrayList(new WineClassificationList().get());
	ObservableList<Country> countryList = FXCollections.observableArrayList(new CountryList().get());
	ObservableList<Region> regionList = FXCollections.observableArrayList(new RegionList().get());
	ObservableList<Producer> producerList = FXCollections.observableArrayList(new ProducerList().get());

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		wineTypeBox.setItems(wineTypeList);
		wineClassificationBox.setItems(wineClassificationList);
		wineCountryBox.setItems(countryList);
		wineRegionBox.setItems(regionList);
		wineProducerBox.setItems(producerList);

	}

	/**
	 * Sets the stage of this dialog.
	 * 
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the wine to be edited in the dialog.
	 * 
	 * @param person
	 */
	public void setWine(Wine wine) {
		this.wine = wine;

		wineIdField.setText(Long.toString(wine.getId()));
		wineNameField.setText(wine.getName());

		if (wine.getType() != null) {
			wineTypeBox.setValue(wine.getType());
		}
		if (wine.getClassification() != null) {
			wineClassificationBox.setValue(wine.getClassification());
		}
		if (wine.getCountry() != null) {
			wineCountryBox.setValue(wine.getCountry());
		}
		if (wine.getRegion() != null) {
			wineRegionBox.setValue(wine.getRegion());
		}
		if (wine.getProducer() != null) {
			wineProducerBox.setValue(wine.getProducer());
		}

	}

	@FXML
	private void handleClickRegion() {

		if (wineCountryBox.getValue() != null) {
			ObservableList<Region> rl = FXCollections.observableArrayList();
			rl = new RegionList().getForCountry(wineCountryBox.getValue());
			wineRegionBox.setItems(rl);
		}

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 * 
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			wine.setName(wineNameField.getText());
			/*
			 * wine.setType(wineTypeField.getText());
			 * wine.setClassification(wineClassificationField.getText());
			 * wine.setCountry(wineCountryField.getText());
			 * wine.setRegion(wineRegionField.getText());
			 * wine.setProducer(lastProducerField.getText());
			 */

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (wineNameField.getText() == null || wineNameField.getText().length() == 0) {
			errorMessage += "No valid wine name!\n";
		}
		/*
		 * if (wineTypeField.getText() == null || wineTypeField.getText().length() == 0)
		 * { errorMessage += "No valid type!\n"; } if (wineClassificationField.getText()
		 * == null || wineClassificationField.getText().length() == 0) { errorMessage +=
		 * "No valid classification!\n"; }
		 * 
		 * if (wineCountryField.getText() == null || wineCountryField.getText().length()
		 * == 0) { errorMessage += "No valid country!\n"; }
		 * 
		 * if (wineRegionField.getText() == null || wineRegionField.getText().length()
		 * == 0) { errorMessage += "No valid region!\n"; }
		 * 
		 * if (wineProducerField.getText() == null ||
		 * wineProducerField.getText().length() == 0) { errorMessage +=
		 * "No valid producer!\n"; }
		 */

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
