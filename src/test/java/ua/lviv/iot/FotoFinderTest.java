package ua.lviv.iot;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class FotoFinderTest {

    @Test
    public void testPostalCode() {
        String text = "Photos from our walk are in the file walk.png. Photos from the trip to the Carpathians are in the file trip.jpeg";
        Pattern pattern = Pattern.compile("\\b\\w+\\.(png|jpe?g|gif)\\b");
        Matcher matcher = pattern.matcher(text);
        List<String> expectedFoto = Arrays.asList("walk.png", "trip.jpeg");
        List<String> actualFoto = new ArrayList<>();
        while (matcher.find()) {
            actualFoto.add(matcher.group());
        }
        assertEquals(expectedFoto, actualFoto);
    }

    @Test
    public void testNoFotoFinder() {
        String text = "Photos from our walk are in the file walk";
        Pattern pattern = Pattern.compile("\\b\\w+\\.(png|jpe?g|gif)\\b");
        Matcher matcher = pattern.matcher(text);
        assertFalse(matcher.find());
    }

     @Test
    public void testInvalidFotoFinderFormat() {
        String text = "Photos from our walk are in the file walk.pngp";
        Pattern pattern = Pattern.compile("\\b\\w+\\.png\\b");
        Matcher matcher = pattern.matcher(text);
        assertFalse(matcher.find());
    }

}
