package view;

import data.Stopwatch;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class StopwatchTab extends View {

    private Stopwatch stopwatch;
    private boolean start = false;
    private boolean pause = false;
    private Button startButton, stopButton, pauseButton;

    public StopwatchTab() {
        //Set up VBox layout and default texts
        box.setLayoutX((View.PANE_WIDTH / 2) - 107.5);
        box.setLayoutY((View.PANE_HEIGHT / 2) - 200);
        stopwatch = new Stopwatch();
        display.setText("00:00");

        //Initialize stop, start, and paue buttons.
        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        stopButton = new Button("Stop");

        //Add the supported CSS styles for the buttons
        startButton.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 2px; -fx-border-color: #000000; -fx-text-fill: #000000");
        pauseButton.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 2px; -fx-border-color: #000000; -fx-text-fill: #000000");
        stopButton.setStyle("-fx-background-color: #FFFFFF; -fx-border-width: 2px; -fx-border-color: #000000; -fx-text-fill: #000000");
    }

    public void setElements() {
        //Initial state of timer, where it is stopped.
        start = false;
        pause = true;

        //Create a timeline to essentially act as a loop.
        Timeline time = new Timeline();
        //Set the time to indefinite so it does not randomly end.
        time.setCycleCount(Timeline.INDEFINITE);

        //EVENT HANDLERS FOR STOPWATCH

        //If start button is pressed, start timer.
        startButton.setOnAction(event -> {
            start = true;
            pause = false;
        });

        //If pause button is pressed, pause timer.
        pauseButton.setOnAction(event -> {
            pause = true;
            start = false;
        });

        //If stop button is pressed, stop and reset timer.
        stopButton.setOnAction(event -> {
            start = false;
            pause = false;
        });

        //Create Keyframe to act as a timed loop with a 1 millisecond repeating duration.
        KeyFrame frame = new KeyFrame(Duration.millis(1), event -> {

            /*
            Utilize the variables which are determined by
            event handlers above to change the stopwatch states.
            */
            stopwatch.timekeep(start, pause);

            /* AESTHETIC EDITS ESSENTIALLY
            If minutes are less than 10, add a preceding 0.
            e.g: 9 minutes becomes 09:xx

            If seconds are less than 100, also add a preceding 0.
            e.g: 4 minutes 9 seconds becomes 04:09.
             */
            if (stopwatch.getMinutes() < 10) {

                if (stopwatch.getSeconds() < 10) {
                    display.setText("0" + stopwatch.getMinutes() + ":0" + stopwatch.getSeconds());
                } else {
                    display.setText("0" + stopwatch.getMinutes() + ":" + stopwatch.getSeconds());
                }
            } else {
                if (stopwatch.getSeconds() < 10) {
                    display.setText(stopwatch.getMinutes() + ":0" + stopwatch.getSeconds());
                } else {
                    display.setText(stopwatch.getMinutes() + ":" + stopwatch.getSeconds());
                }
            }

            /*
            If the minutes exceed 99 OR the stopwatch display String is longer than "99:99",
            reduce font size so the stopwatch box will not be cut off by the Pane screen.
             */
            if (stopwatch.getMinutes() > 99 || display.getText().compareTo("99:99") > 0) {
                display.setFont(Font.font("consolas", FontWeight.BOLD, FontPosture.REGULAR, 50));
            }
        });

        //Add the single frame every 1ms loop into the Timeline (which is indefinite anyways)
        time.getKeyFrames().add(frame);
        //Replay timeline in order to repeat loop.
        time.playFromStart();

        //Add stopwatch buttons and stopwatch text to the Stopwatch specific VBox
        box.getChildren().addAll(getText(), startButton, pauseButton, stopButton);
    }

}
