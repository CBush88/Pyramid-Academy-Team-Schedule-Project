import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpeechTest {

    String title = "Sample";
    String duration = "30min";
    Speech speech = new Speech(title, duration);

    @Test
    void getTitle_title_isCorrectTitle() {
        assertEquals(title, speech.getTitle(), "getTitle() did not produce expected title");
    }

    @Test
    void getDuration_duration_isCorrectDuration() {
        assertEquals(duration, speech.getDuration(), "getDuration() did not produce expected ");
    }

    @Test
    void setTitle_title_isUpdated() {
        String newTitle = "New Title";
        speech.setTitle(newTitle);

        assertEquals(newTitle, speech.getTitle(), "setTitle() did not update title as expected");
    }

    @Test
    void setDuration_duration_isUpdated() {
        String newDuration = "60min";
        speech.setDuration(newDuration);

        assertEquals(newDuration, speech.getDuration());
    }
}