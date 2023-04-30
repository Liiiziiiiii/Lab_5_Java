package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FotoFinder {

    public String finder(final String text){

        String pattern = "\\b\\w+\\.(png|jpe?g|gif)\\b";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
        List<String> results = new ArrayList<>();

        while (m.find()) {
            results.add(m.group());
        }

        return results.toString();
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);


        System.out.println("Enter your text: ");
        String text = br.readLine();


        //Photos from our walk are in the file walk.png. Photos from the trip to the Carpathians are in the file trip.jpeg;
        String pattern = "\\b\\w+\\.(png|jpe?g|gif)\\b";

        FotoFinder fotoFinder = new FotoFinder();
        String found = fotoFinder.finder(text);
        System.out.println(found);

    }
}