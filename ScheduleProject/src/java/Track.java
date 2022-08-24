import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Track {
    private LocalTime time = LocalTime.of(9,00);
    private final LocalTime lunch = LocalTime.of(12,00);
    private final LocalTime morningBP = LocalTime.of(10,30);
    private final LocalTime networkSoft = LocalTime.of(16, 00);
    private final LocalTime networkHard = LocalTime.of(17, 00);

    private List<Speech> trackSpeeches = new ArrayList<>();
    List<Speech> input;
    //System.out.println(time.format(DateTimeFormatter.ofPattern("h:mm a")));

    public Track(List<Speech> input){
        this.input = input;
        while(time.isBefore(lunch)){
            trackSpeeches.add(input.get(0));
            String minutes = input.get(0).getDuration().substring(0, 2);
            int minutesToAdd = (!minutes.equals("li")? Integer.parseInt(minutes) : (05));
            time = time.plusMinutes(minutesToAdd);
            input.remove(0);
        }
    }
    public String toString(){
        return trackSpeeches.stream().map(s -> s.getTitle() + " " + s.getDuration() + "\n").collect(Collectors.joining());
    }

}
