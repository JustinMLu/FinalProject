package view;

import data.Stopwatch;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import javafx.scene.control.Tab;

public class StopwatchTab extends View {

    private Stopwatch stopwatch;
    private boolean start = false;
    private boolean pause = false;

    Button startButton, stopButton, pauseButton;

    public StopwatchTab() {

        box.setLayoutX((View.PANE_WIDTH / 2) - 107.5);
        box.setLayoutY(View.PANE_HEIGHT / 2 - 200);
        stopwatch = new Stopwatch();
        display.setText("00:00");

        startButton = new Button("Start");
        pauseButton = new Button("Pause");
        stopButton = new Button("Stop");
    }

    public void setElements() {
        start = false;
        pause = true;

        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

        startButton.setOnAction(event -> {
            start = true;
            pause = false;
        });

        pauseButton.setOnAction(event -> {
            pause = true;
            start = false;
        });

        stopButton.setOnAction(event -> {
            start = false;
            pause = false;
        });

        KeyFrame frame = new KeyFrame(Duration.millis(1), event -> {

            stopwatch.timekeep(start, pause);

            if (stopwatch.getMinutes() < 10) {

                if (stopwatch.getSeconds() < 10) {
                    display.setText("0" + stopwatch.getMinutes() + ":0" + stopwatch.getSeconds());
                }
                else {
                    display.setText("0" + stopwatch.getMinutes() + ":" + stopwatch.getSeconds());
                }
            }
            else {
                if (stopwatch.getSeconds() < 10) {
                    display.setText(stopwatch.getMinutes() + ":0" + stopwatch.getSeconds());
                }
                else {
                    display.setText(stopwatch.getMinutes() + ":" + stopwatch.getSeconds());
                }
            }

            if (stopwatch.getMinutes() > 99 || display.getText().compareTo("99:99") > 0) {
                display.setFont(Font.font("consolas", FontWeight.BOLD, FontPosture.REGULAR, 50));
            }
        });

        time.getKeyFrames().add(frame);
        time.playFromStart();

        box.getChildren().addAll(getText(), startButton, pauseButton, stopButton);

    }

}
