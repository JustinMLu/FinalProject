package view;
import data.Clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class ClockTab extends View {

    private Clock clock;
    private Text date;

    public ClockTab(Clock clock) {

        this.clock = clock;
        box.setLayoutX((View.PANE_HEIGHT / 2) - 182.5);
        box.setLayoutY((View.PANE_WIDTH / 2) - 125);

        date = new Text();
        date.setFont(Font.font("consolas", FontWeight.BOLD, FontPosture.REGULAR, 30));
        date.setFill(Color.BLACK);
        date.setStroke(Color.TRANSPARENT);

        clock.update();

        if (clock.getData(2) > 12) {
            if (clock.getData(3) < 10) {
                display.setText((clock.getData(2) - 12) + ":0" + clock.getData(3) + "\nPM");
            }
            else {
                display.setText((clock.getData(2) - 12) + ":" + clock.getData(3) + "\nPM");
            }
        }
        else {
            if (clock.getData(3) < 10) {
                display.setText(clock.getData(2) + ":0" + clock.getData(3) + "\nAM");
            }
            else {
                display.setText(clock.getData(2) + ":" + clock.getData(3) + "\nAM");
            }
        }
        date.setText(clock.getMonth() + " " + clock.getData(1) + " " + clock.getData(0));

    }

    //Code from https://www.youtube.com/watch?v=t2Bv6hwELsU

    public void setElements() {
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);

        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {

                clock.update();
                if (clock.getData(2) > 12) {
                    if (clock.getData(3) < 10) {
                        display.setText((clock.getData(2) - 12) + ":0" + clock.getData(3) + "\nPM");
                    }
                    else {
                        display.setText((clock.getData(2) - 12) + ":" + clock.getData(3) + "\nPM");
                    }
                }
                else {
                    if (clock.getData(3) < 10) {
                        display.setText(clock.getData(2) + ":0" + clock.getData(3) + "\nAM");
                    }
                    else {
                        display.setText(clock.getData(2) + ":" + clock.getData(3) + "\nAM");
                    }
                }
                date.setText(clock.getMonth() + " " + clock.getData(1) + " " + clock.getData(0));
            }
        });

        time.getKeyFrames().add(frame);
        time.playFromStart();

        box.getChildren().addAll(getText(), date);
    }
}
