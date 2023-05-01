package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FotoFinder {
    public static final Pattern PICTURES_REGEX =
            Pattern.compile("\\b[\\w\\.]+\\.(png|jpe?g|gif)\\b(\\s|$|.)");
    public List<String> finder(final String text) {
        Matcher matcher = PICTURES_REGEX.matcher(text);
        List<String> results = new ArrayList<>();
        while (matcher.find()) {
            results.add(matcher.group());
        }

        return results;
    }

    //Photos from our walk are in the file walk.png. Photos
    // from the trip to the Carpathians are in the file trip.jpeg;

}
