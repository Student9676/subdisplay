import util.Subtitle;
import util.Movie;
import java.util.ArrayList;
import java.io.File;

class SrtParser {
    public static Movie parse (String srtPath) {

	Movie movie = null;
	
	File file = new File(srtPath);
	Scanner scanner = new Scanner(file);
	String srt = ""
	while (scanner.hasNextLine()) {
	    srt += scanner.nextLine();
	}
	scanner.close();

	String sep = System.getProperty("line.separator");
	ArrayList<String> rawSubtitles = new ArrayList<>(Arrays.asList(srt.split(sep + sep)));
	
    }
}
