import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    File testFile = new File("ScheduleProject/src/resources/talks-test");

    @Test
    void getEvents_length_isEqualToFileContents() {
        List<Speech> speeches = Main.getEvents(testFile);
        assertEquals(19, speeches.size(), "getEvents() did not produce list with length equal to number of events of talks-test file");
    }

    @Test
    void getEvents_duration_isLightningOrMin(){
        List<Speech> speeches = Main.getEvents(testFile);

        for(Speech s: speeches){
            boolean isLightning = s.getDuration().equalsIgnoreCase("lightning");
            boolean isMinutes = s.getDuration().substring(0,2).matches("^\\d{2}");

            assertTrue(isLightning || isMinutes, "getEvents() did not parse duration properly");
        }
    }

    @Test
    void sortEventsByDuration_length_IsSameAsInput(){
        List<Speech> speeches = Main.getEvents(testFile);
        List<Speech> sortedSpeeches = Main.sortEventsByDuration(speeches);

        assertEquals(speeches.size(), sortedSpeeches.size(), "sortEventsByDuration() did not produce list of same length as talks-test file");
    }

    @Test
    void sortEventsByDuration_order_isDescending(){
        List<Speech> speeches = Main.getEvents(testFile);
        List<Speech> sortedSpeeches = Main.sortEventsByDuration(speeches);

        List<String> expected = Arrays.asList("60min","60min","60min","60min","60min",
                "45min","45min","45min","45min","45min","45min",
                "30min","30min","30min","30min","30min","30min","30min","lightning");

        for(int i=0; i<expected.size(); i++){
            assertEquals(expected.get(i), sortedSpeeches.get(i).getDuration(), "sortEventsByDuration() did not sort speeches in descending order");
        }
    }
}