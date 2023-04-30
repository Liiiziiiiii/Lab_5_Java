package ua.lviv.iot;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import java.io.IOException;
import java.util.List;


public class FotoFinderTest {
    FotoFinder fotoFinder;

    @BeforeEach
    void setUp() {
        FotoFinder fotoFinder = new FotoFinder();
    }



   @Test
    public void test() throws IOException {
       String text = "Photos from our walk are in the file walk.png. Photos from the trip to the Carpathians are in the file trip.jpeg";
       String pattern = "\\b\\w+\\.(png|jpe?g|gif)\\b";
       String result = "[walk.png, trip.jpeg]";
       Assertions.assertEquals(result, fotoFinder.fider(text, pattern));



   }

}
