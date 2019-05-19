import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainGUI;
import view.View;


public class Main extends Application {

    //Create new instance of MainGUI
    private MainGUI mainInterface = new MainGUI();

    @Override
    public void start(Stage primaryStage) {

        //Create a new scene with the MainGUI's root pane as the primary pane.
        Scene scene = new Scene(mainInterface.getRootPane(), View.PANE_WIDTH, View.PANE_HEIGHT);
        //Start all Timelines and initialize ALL OTHER user-made classes
        mainInterface.startApp();

        //Set the window title, scene, and show said scene with root pane.
        primaryStage.setTitle("Klok Application");
        primaryStage.setScene(scene);
        //Make page unresizable so watch and stopwatch boxes cannot be cut off.
        primaryStage.setResizable(false);
        //Show pane onto the screen.
        primaryStage.show();
    }


    public static void main(String[] args) {
        //Launch application in main method.
        launch(args);
    }
}
