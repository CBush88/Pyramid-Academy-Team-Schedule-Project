import java.time.LocalTime;
import java.util.*;

public class Track {
    private LocalTime time = LocalTime.of(9,00,00);
    List<Speech> input;
    //System.out.println(time.format(DateTimeFormatter.ofPattern("h:mm a")));

    public Track(List<Speech> input){
        this.input = input;
        //input must be sorted
        

    }

}
