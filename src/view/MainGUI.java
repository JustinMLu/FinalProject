package view;

import data.Clock;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

public class MainGUI {

    private Clock clock;
    private ClockTab clockTab;
    private StopwatchTab watchTab;
    private Button toWatch, toClock;
    private VBox buttonBox;
    private Pane root;

    public MainGUI() {

        clock = new Clock();
        clockTab = new ClockTab(clock);
        watchTab = new StopwatchTab();
        root = new Pane();

        toWatch = new Button("Click for Stopwatch");
        toClock = new Button("Click for Clock");

        toWatch.setLayoutX(View.PANE_WIDTH / 2 - 75);
        toWatch.setLayoutY(View.PANE_HEIGHT / 2 + 120);

        toClock.setLayoutX(View.PANE_WIDTH / 2 - 75);
        toClock.setLayoutY(View.PANE_HEIGHT / 2 + 120 + 40);

        buttonBox = new VBox(10);
        buttonBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");


        buttonBox.setLayoutX((View.PANE_WIDTH / 2) - 107.5);
        buttonBox.setLayoutY(View.PANE_HEIGHT / 2 + 70);
    }

    public Pane getRootPane() {
        return root;
    }

    public void startApp() {

        watchTab.setElements();
        clockTab.setElements();

        watchTab.getBox().setVisible(false);

        toWatch.setOnAction(event -> {
            clockTab.getBox().setVisible(false);
            watchTab.getBox().setVisible(true);
        });

        toClock.setOnAction(event -> {
            clockTab.getBox().setVisible(true);
            watchTab.getBox().setVisible(false);
        });

        buttonBox.getChildren().addAll(toWatch, toClock);
        root.getChildren().addAll(watchTab.getBox(), clockTab.getBox(), buttonBox);


    }

}
