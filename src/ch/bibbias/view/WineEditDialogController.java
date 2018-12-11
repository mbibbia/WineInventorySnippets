package ch.bibbias.view;

import ch.bibbias.model.Wine;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
	private TextField wineTypeField;
	@FXML
	private TextField wineClassificationField;
	@FXML
	private TextField wineCountryField;
	@FXML
	private TextField wineRegionField;
	@FXML
	private TextField wineProducerField;

	private Stage dialogStage;
	private Wine wine;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
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
		wineTypeField.setText(wine.getType().getName());
		wineClassificationField.setText(wine.getClassification().getCode());
		wineCountryField.setText(wine.getCountry().getCode());
		wineRegionField.setText(wine.getRegion().getName());
		wineProducerField.setText(wine.getProducer().getName());

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
			wine.setType(wineTypeField.getText());
			wine.setClassificatin(wineClassificationField.getText());
			wine.setCountry(wineCountryField.getText());
			wine.setRegion(wineRegionField.getText());
			wine.setProducer(lastProducerField.getText());

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
		if (wineTypeField.getText() == null || wineTypeField.getText().length() == 0) {
			errorMessage += "No valid type!\n";
		}
		if (wineClassificationField.getText() == null || wineClassificationField.getText().length() == 0) {
			errorMessage += "No valid classification!\n";
		}

		if (wineCountryField.getText() == null || wineCountryField.getText().length() == 0) {
			errorMessage += "No valid country!\n";
		}

		if (wineRegionField.getText() == null || wineRegionField.getText().length() == 0) {
			errorMessage += "No valid region!\n";
		}

		if (wineProducerField.getText() == null || wineProducerField.getText().length() == 0) {
			errorMessage += "No valid producer!\n";
		}

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
