
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainGUI;
import view.View;


public class Main extends Application {

    MainGUI mainInterface = new MainGUI();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(mainInterface.getRootPane(), View.PANE_WIDTH, View.PANE_HEIGHT);

        mainInterface.startApp();

        primaryStage.setTitle("Klok Application");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
