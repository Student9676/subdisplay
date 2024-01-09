import util.Subtitle;
import util.Movie;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


class SrtParser {
    public static Movie parse (String srtPath) {
	Movie movie = null;
	
	File file = new File(srtPath);
	Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            return null;
        }
        String srt = "";
        while (scanner.hasNextLine()) {
            srt += scanner.nextLine() + System.lineSeparator();
        }
        scanner.close();
	
        ArrayList<String> rawSubtitles = new ArrayList<>(Arrays.asList(srt.split(System.lineSeparator() + System.lineSeparator())));
	movie.setStringSubtitles(rawSubtitles);

	return movie;
    }

    /*
     * 22
     * 00:03:56,361 --> 00:03:58,321
     * Directοr οf Phοtοgraphy
     * Nοbuο Kοyama
     * Sοund Design
     * Υasuο Urakami
     */
    private static Subtitle parseSub(String subString) {
	Subtitle sub = new Subtitle();
	String[] subLines = subString.split(System.lineSeparator());
	sub.setNumber(Integer.parseInt(subLines[0]));
	String[] times = subLines[1].split(" --> ");
	sub.setStartTime(times[0]);
	sub.setEndTime(times[1]);
	String text = "";
	for (int i = 2; i < subLines.length; i++) {
	    text += subLines[i] + System.lineSeparator();
	}
	sub.setText(text);
	return sub;
    }
}
