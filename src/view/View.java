package view;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public abstract class View {
    //Constants to be used to center/place boxes, buttons and text later on.
    public static final int PANE_HEIGHT = 500;
    public static final int PANE_WIDTH = 350;

    protected Text display;
    protected VBox box;

    public View() {
        box = new VBox(12);
        //CSS style for VBox
        box.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");

        display = new Text();
        display.setFont(Font.font("consolas", FontWeight.BOLD, FontPosture.REGULAR, 70));
        display.setFill(Color.BLACK);
        display.setStroke(Color.TRANSPARENT);
    }

    //To be implemented in CLockTab and StopwatchTab
    public abstract void setElements();

    //Return the displayed text (differs for both Clock and Stopwatch)
    public Text getText() {
        return display;
    }

    //Returns the VBox which includes display text as well as any buttons needed.
    public VBox getBox() {
        return box;
    }

}
