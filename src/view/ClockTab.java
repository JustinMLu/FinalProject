package view;

import data.Clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ClockTab extends View {

    private Clock clock;
    private Text date;

    //Set up box positions and display text settings.
    public ClockTab() {
        clock = new Clock();
        box.setLayoutX((View.PANE_HEIGHT / 2) - 182.5);
        box.setLayoutY((View.PANE_WIDTH / 2) - 125);

        date = new Text();
        date.setFont(Font.font("consolas", FontWeight.BOLD, FontPosture.REGULAR, 30));
        date.setFill(Color.BLACK);
        date.setStroke(Color.TRANSPARENT);

        //Update clock to initialize any variables to avoid NullPointer or false values.
        clock.update();

        /*Judges whether or not the time is in AM or PM, or whether a 0 should be put in front of the minutes counter.
        If the time is greater than 12, convert to 12hr time and set as PM.
         */
        if (clock.getData(2) > 12) {

            //Put a 0 in front of the minutes value if it is less than 10, otherwise do not.
            if (clock.getData(3) < 10) {
                display.setText((clock.getData(2) - 12) + ":0" + clock.getData(3) + "\nPM");
            } else {
                display.setText((clock.getData(2) - 12) + ":" + clock.getData(3) + "\nPM");
            }
        }

        //Otherwise, it is still in AM and the value can be printed.
        else {
            //Same evaluator for putting a 0 or not in front of the minutes.
            if (clock.getData(3) < 10) {
                display.setText(clock.getData(2) + ":0" + clock.getData(3) + "\nAM");
            } else {
                display.setText(clock.getData(2) + ":" + clock.getData(3) + "\nAM");
            }
        }
        date.setText(clock.getMonth() + " " + clock.getData(1) + " " + clock.getData(0));

    }

    /*
    KeyFrame and Timeline code from https://www.youtube.com/watch?v=t2Bv6hwELsU
     */
    public void setElements() {
        Timeline time = new Timeline();
        //Set time to indefinite so it does not randomly end.
        time.setCycleCount(Timeline.INDEFINITE);

        //Set the duration of update for the KeyFrame to be 1 second
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            //Essentially a loop in which evaluators can run.
            public void handle(ActionEvent event) {
                //Updates all clock values as seen in Clock class.
                clock.update();

                //EXACT SAME EVALUATOR FOR AM, PM, :0x OR :x SEEN IN CONSTRUCTOR
                if (clock.getData(2) > 12) {
                    if (clock.getData(3) < 10) {
                        display.setText((clock.getData(2) - 12) + ":0" + clock.getData(3) + "\nPM");
                    } else {
                        display.setText((clock.getData(2) - 12) + ":" + clock.getData(3) + "\nPM");
                    }
                } else {
                    if (clock.getData(3) < 10) {
                        display.setText(clock.getData(2) + ":0" + clock.getData(3) + "\nAM");
                    } else {
                        display.setText(clock.getData(2) + ":" + clock.getData(3) + "\nAM");
                    }
                }
                date.setText(clock.getMonth() + " " + clock.getData(1) + " " + clock.getData(0));
            }
        });

        //Add the frame specified into the Timeline so it can ascertain the duration
        time.getKeyFrames().add(frame);
        //Restart the Timeline so that it repeatedly plays and updates the Clock.
        time.playFromStart();

        //Add the clock text and date text to the main VBox which will be put on the MainGUI Pane
        box.getChildren().addAll(getText(), date);
    }
}
