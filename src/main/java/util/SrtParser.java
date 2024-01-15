package util;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


public class SrtParser {
    public static Movie parse(String srtPath) {
        Movie movie = new Movie();

        File file = new File(srtPath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        String srt = "";
        while (scanner.hasNextLine()) {
            srt += scanner.nextLine() + System.lineSeparator();
        }
        scanner.close();

        ArrayList < String > rawSubtitles = new ArrayList < > (Arrays.asList(srt.split(System.lineSeparator() + System.lineSeparator())));
        rawSubtitles.replaceAll(String::trim);
        movie.setStringSubtitles(rawSubtitles);

        movie.setParsedSubtitles(parseSubs(rawSubtitles));

        return movie;
    }

    private static Subtitle parseSub(String subString) {
        Subtitle sub = new Subtitle();
        String[] subLines = subString.split(System.lineSeparator());
        sub.setNumber(Integer.parseInt(subLines[0]));
        String[] times = subLines[1].split(" --> ");
        sub.setStartTime(times[0]);
        sub.setEndTime(times[1]);
        String text = "";
        for (int i = 2; i < subLines.length; i++) {
            if (i == subLines.length - 1) {
                text += subLines[i];
            } else {
                text += subLines[i] + System.lineSeparator();
            }
        }
        sub.setText(text);
        return sub;
    }
    private static ArrayList < Subtitle > parseSubs(ArrayList < String > rawSubtitles) {
        ArrayList < Subtitle > parsedSubtitles = new ArrayList < > ();
        for (int i = 0; i < rawSubtitles.size(); i++) {
            parsedSubtitles.add(parseSub(rawSubtitles.get(i)));
        }
        return parsedSubtitles;
    }
}