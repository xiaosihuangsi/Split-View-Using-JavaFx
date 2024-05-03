import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;



public class SplitViewTest extends Application {
    //
    // User interface controls
    //
    private ListView<String> colorListView;
    private Label colorLabel;

    @Override
    public void start (Stage stage) {
        String[] colors = { "red", "green", "blue"};
        ObservableList<String> colorList = FXCollections.observableArrayList();
        colorList.addAll(colors);
        this.colorListView = new ListView<>(colorList);

        this.colorListView.getSelectionModel().select(0);
        this.colorListView.getSelectionModel().selectedItemProperty().addListener(
            this::processColorListSelection);


        this.colorLabel = new Label(colorList.get(0));
        StackPane colorPane = new StackPane(colorLabel);

        SplitPane rootPane = new SplitPane();
        // rootPane.setOrientation(Orientation.VERTICAL);
        rootPane.setDividerPositions(0.25);
        rootPane.getItems().addAll(this.colorListView, colorPane);

        Scene scene = new Scene(rootPane, 500, 300);
        stage.setTitle("Split View Test");
        stage.setScene(scene);
        stage.show();
    }

    public void processColorListSelection(ObservableValue<? extends String>val,
        String oldValue, String newValue) {
        this.colorLabel.setText(newValue);
        }


    public static void main(String[] args) {
        launch();
    }
}