

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    public class ScheduleController {
        @FXML
        private TextArea outputTextArea;

        @FXML
        protected void onScheduleButtonClick() {
            File talksFile = new File("ScheduleProject/src/resources/talks");
            List<Speech> speechList = Main.getEvents(talksFile);
            speechList = Main.sortEventsByDuration(speechList);

            try {
                Track track1 = new Track(speechList);
                Track track2 = new Track(speechList);
                outputTextArea.setText("Track 1\n" + track1 + "\n" + "Track 2\n" + track2 + "\n");
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

