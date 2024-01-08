import util.Subtitle;
import util.Movie;
import java.util.ArrayList;
import java.io.File;
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
        String sep = System.getProperty("line.separator");
        String srt = "";
        while (scanner.hasNextLine()) {
            srt += scanner.nextLine() + sep;
        }
        scanner.close();
	
        ArrayList<String> rawSubtitles = new ArrayList<>(Arrays.asList(srt.split(sep + sep)));
    }
}
