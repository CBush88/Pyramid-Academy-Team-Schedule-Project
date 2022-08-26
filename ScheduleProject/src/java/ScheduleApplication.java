

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

    public class ScheduleApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(ScheduleApplication.class.getResource("/schedule-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 434);
            stage.setTitle("Schedule");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

