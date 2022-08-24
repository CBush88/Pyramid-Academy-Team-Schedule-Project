import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Track {

    private final List<Speech> trackSpeeches = new ArrayList<>();
    List<Speech> input;
    //System.out.println(time.format(DateTimeFormatter.ofPattern("h:mm a")));

    public Track(List<Speech> input) throws Exception{
        this.input = input;
        LocalTime time = LocalTime.of(9, 0);
        LocalTime lunch = LocalTime.of(12, 0);
        while(time.isBefore(lunch)){
            trackSpeeches.add(input.get(0));
            int minutesToAdd = getMinutesToAdd(input.get(0));
            time = time.plusMinutes(minutesToAdd);
            input.remove(0);
        }
        if(time.equals(lunch)){
            trackSpeeches.add(new Speech("Lunch", "60min"));
            time = time.plusMinutes(60);
        }else{
            throw new Exception("Didn't fill time properly");
        }
        LocalTime networkSoft = LocalTime.of(16, 0);
        while(time.isBefore(networkSoft)){
            trackSpeeches.add(input.get(0));
            int minutesToAdd = getMinutesToAdd(input.get(0));
            time = time.plusMinutes(minutesToAdd);
            input.remove(0);
        }
        LocalTime networkHard = LocalTime.of(17, 0);
        while(input.size() > 0 && time.plusMinutes(getMinutesToAdd(input.get(0))).isBefore(networkHard)){
            trackSpeeches.add(input.get(0));
            time = time.plusMinutes(getMinutesToAdd(input.get(0)));
            input.remove(0);
        }
        trackSpeeches.add(new Speech("Networking", ""));
        if(time.isBefore(networkSoft) || time.isAfter(networkHard)){
            throw new Exception("Didn't fill time properly");
        }
    }

    public int getMinutesToAdd(Speech input) {
        String minutes = input.getDuration().substring(0, 2);
        return (!minutes.equals("li")? Integer.parseInt(minutes) : (5));
    }

    public String toString(){
        LocalTime stringTime = LocalTime.of(9,0);
        StringBuilder output = new StringBuilder();
        for (Speech trackSpeech : trackSpeeches) {
            output.append(stringTime.format(DateTimeFormatter.ofPattern("h:mma"))).append(" ")
                    .append(trackSpeech.getTitle()).append(" ")
                    .append(trackSpeech.getDuration()).append("\n");
            if (!trackSpeech.getDuration().equals("")) {
                stringTime = stringTime.plusMinutes(getMinutesToAdd(trackSpeech));
            }
        }
        return output.toString();
    }

}
