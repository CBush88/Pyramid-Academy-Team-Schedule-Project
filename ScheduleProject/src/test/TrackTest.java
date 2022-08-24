import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrackTest {

    List<Speech> speeches;

    @BeforeEach
     void init(){
        File testFile = new File("ScheduleProject/src/resources/talks-test");
        speeches = Main.sortEventsByDuration(Main.getEvents(testFile));
    }

    @Test
    void track_noon_isValid() throws Exception {
        String noon = "12:00PM Lunch 60min";
        Track track1 = new Track(speeches);
        String[] track1ToString = track1.toString().split("\n");
        boolean isValid = false;

        for (String s : track1ToString) {
            if (s.contains(noon)) {
                isValid = s.contains(noon);
                break;
            }
        }

        assertTrue(isValid);
    }

    @Test
    void track_networking_isValid() throws Exception {
        String soft = "4";
        String hard = "5";
        Track track1 = new Track(speeches);
        String[] track1ToString = track1.toString().split("\n");
        boolean isValid = false;

        for(String s: track1ToString){
            if(s.startsWith(soft) || s.startsWith(hard)){
                String r = s.toLowerCase().substring( 7);
                isValid = r.equals("networking ");
            }
        }

        assertTrue(isValid);
    }

    @Test
    void track_toString_isValid() throws Exception {
        String expectedTrack1 = "9:00AM Fun path to Java SE 11 Developer Certifications 60min\n" +
                "10:00AM Effective Java SE 9 through 14 APIs/Lang features, makes your life easier. 60min\n" +
                "11:00AM Improving Startup for Java Analytical Workload 60min\n" +
                "12:00PM Lunch 60min\n" +
                "1:00PM An Open Future for Java in the Cloud 60min\n" +
                "2:00PM Keeping Up With Java: Look At All These New Features! 60min\n" +
                "3:00PM Java and Containers - Make it Awesome! 45min\n" +
                "3:45PM Memory Efficient Java 45min\n" +
                "4:30PM Networking \n";

        Track track1 = new Track(speeches);
        assertEquals(expectedTrack1, track1.toString(), "Track1 did not produce expected output");
    }

    @Test
    void getMinutesToAdd_lightning_is5() throws Exception {
        Speech input = new Speech("Sample", "lightning");
        int result = (new Track(speeches)).getMinutesToAdd(input);

        assertEquals(5, result);
    }

    @Test
    void getMinutesToAdd_30min_is30() throws Exception {
        Speech input = new Speech("Sample", "30min");
        int result = (new Track(speeches)).getMinutesToAdd(input);

        assertEquals(30, result);
    }
}
