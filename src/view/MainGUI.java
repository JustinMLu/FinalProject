package view;

import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class MainGUI {

    private ClockTab clockTab;
    private StopwatchTab watchTab;
    private Button toWatch, toClock;
    private VBox buttonBox;
    private Pane root;

    public MainGUI() {
        clockTab = new ClockTab();
        watchTab = new StopwatchTab();
        //Root pane will contain all GUI elements and display entire app
        root = new Pane();

        //Initialize buttons that allow user to switch between clock and stopwatch.
        toWatch = new Button("Click for Stopwatch");
        toClock = new Button("Click for Clock");

        //CSS STYLING FOR BUTTONS
        toWatch.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 2px; -fx-border-color: #000000; -fx-text-fill: #000000");
        toClock.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 2px; -fx-border-color: #000000; -fx-text-fill: #000000");

        //Set the location of 'click for stopwatch' button
        toWatch.setLayoutX(View.PANE_WIDTH / 2 - 75);
        toWatch.setLayoutY(View.PANE_HEIGHT / 2 + 120);

        //Set the location of 'click for clock' button
        toClock.setLayoutX(View.PANE_WIDTH / 2 - 75);
        toClock.setLayoutY(View.PANE_HEIGHT / 2 + 120 + 40);

        buttonBox = new VBox(10);
        //Set the button box VBox to a CSS style that looks nice :)
        buttonBox.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: black;");

        //Set buttonBox position on screen (it is lower than both clock and stopwatch)
        buttonBox.setLayoutX((View.PANE_WIDTH / 2) - 107.5);
        buttonBox.setLayoutY(View.PANE_HEIGHT / 2 + 70);
    }

    //Return the 'root' Pane node that will display the entire application.
    public Pane getRootPane() {
        return root;
    }

    public void startApp() {
        //Set up and update all elements inside watchTab, including Timeline loop.
        watchTab.setElements();
        //Set up and update all elements inside clockTab, including Timeline loop.
        clockTab.setElements();

        watchTab.getBox().setVisible(false);

        /*
        If 'click for stopwatch' button is pressed,
        Set stopwatch to visible and clock to invisible.
         */
        toWatch.setOnAction(event -> {
            clockTab.getBox().setVisible(false);
            watchTab.getBox().setVisible(true);
        });

        /*
        If 'click for clock' button is pressed,
        Set clock to visible and stopwatch to invisible.
         */
        toClock.setOnAction(event -> {
            clockTab.getBox().setVisible(true);
            watchTab.getBox().setVisible(false);
        });

        //Add the two tab switching buttons to buttonBox VBox
        buttonBox.getChildren().addAll(toWatch, toClock);
        //Add the buttonBox VBox, watch tab VBox, and clock tab VBox to ROOT PANE to be displayed.
        root.getChildren().addAll(watchTab.getBox(), clockTab.getBox(), buttonBox);
    }

}
