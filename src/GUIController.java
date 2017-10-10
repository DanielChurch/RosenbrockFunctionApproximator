import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progressBar.setProgress(0d);
    }

    @FXML
    Button selectFileButton;

    @FXML
    Button startButton;

    @FXML
    TextField dataGenStartTextField;

    @FXML
    TextField dataGenEndTextField;

    @FXML
    TextField dataGenIncrementTextField;

    @FXML
    TextField hiddenLayersTextField;

    @FXML
    TextField inputCountTextField;

    @FXML
    TextField nodesPerHiddenLayerTextField;

    @FXML
    CheckBox isRadialBasisCheckbox;

    @FXML
    ProgressBar progressBar;

    @FXML
    private void selectFile(MouseEvent event) {
        Main.save();
    }

    @FXML
    private void start(MouseEvent event) {
        try {
            double dataGenStart = Double.parseDouble(dataGenStartTextField.getText());
            double dataGenEnd = Double.parseDouble(dataGenEndTextField.getText());
            double dataGenIncrement = Double.parseDouble(dataGenIncrementTextField.getText());
            int hiddenLayers = Integer.parseInt(hiddenLayersTextField.getText());
            int dimension = Integer.parseInt(inputCountTextField.getText());
            int nodesPerHiddenLater = Integer.parseInt(nodesPerHiddenLayerTextField.getText());
            boolean isRadialBasis = isRadialBasisCheckbox.isSelected();

            Main.start(dataGenStart, dataGenEnd, dataGenIncrement, hiddenLayers, dimension, nodesPerHiddenLater, isRadialBasis);
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid arguments");
        }
    }

    public void setProgress(double progress) {
        progressBar.setProgress(progress);
    }

}
