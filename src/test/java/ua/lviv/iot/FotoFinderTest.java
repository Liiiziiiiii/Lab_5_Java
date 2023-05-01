package ua.lviv.iot;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


public class FotoFinderTest {

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testPostalCode(String input, List<String> expected) {
        FotoFinder fotoFinder = new FotoFinder();
        assertEquals(expected, fotoFinder.finder(input));
    }
    private static Stream<Arguments> provideParameters(){
        return Stream.of(
        Arguments.of("Photos from our walk are in the file walk.png. " +
                "Photos from the trip to the Carpathians are in the file trip.jpeg",Arrays.asList("walk.png.", "trip.jpeg")),
               Arguments.of("Photos from our walk are in the file walk",new ArrayList<>()),
               Arguments.of("Photos from our walk are in the file walk.pngp",new ArrayList<>()),
               Arguments.of("miwaphoto is gh_ft.png",Arrays.asList("gh_ft.png")),
               Arguments.of("",new ArrayList<>()),
               Arguments.of("miwa_g.pnghfefe.png",Arrays.asList("miwa_g.pnghfefe.png")),
                Arguments.of("miwa_g.png hfefe.png",Arrays.asList("miwa_g.png ", "hfefe.png"))
    );
    }
}
