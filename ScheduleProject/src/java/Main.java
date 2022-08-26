import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*public static void main(String[] args) {

        File talksFile = new File("ScheduleProject/src/resources/talks");
        List<Speech> speechList = getEvents(talksFile);
        speechList = sortEventsByDuration(speechList);

        try{
            Track track1 = new Track(speechList);
            System.out.println(track1);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Track track2 = new Track(speechList);
            System.out.println(track2);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }*/

    public static List<Speech> getEvents(File input) {
        List<String> lines;
        List<Speech> outputList = new ArrayList<>();
        try {
            Path path = Paths.get(input.getPath());
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

    public static List<Speech> sortEventsByDuration(List<Speech> input){
        List<Speech> sorted = input.stream().filter(n -> !n.getDuration().equals("lightning"))
                .sorted((s1, s2) -> Integer.compare(Integer.parseInt(s2.getDuration().substring(0,2)),
                        Integer.parseInt(s1.getDuration().substring(0,2))))
                .collect(Collectors.toList());
        sorted.addAll(input.stream().filter(n-> n.getDuration().equals("lightning"))
                .collect(Collectors.toList()));
        return sorted;
    }
}
