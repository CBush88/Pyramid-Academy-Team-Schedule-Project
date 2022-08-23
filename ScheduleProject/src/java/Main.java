import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File talksFile = new File("ScheduleProject/src/resources/talks");
        List<Speech> speechList = getEvents(talksFile);
    }

    public static List<Speech> getEvents(File input) {
        List<String> lines;
        List<Speech> outputList = new ArrayList<>();
        try {
            Path path = Path.of(input.getPath());
            lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] lineArr = line.split("\\s{2,}");
                String title = lineArr[0];
                String mins = lineArr[1];
                Speech speech = new Speech(title, mins);
                outputList.add(speech);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return outputList;
    }
}