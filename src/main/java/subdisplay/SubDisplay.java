package subdisplay;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import util.SrtParser;
import util.Movie;
import util.Subtitle;

public class SubDisplay {
	public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	String srtPath;
	while (true) {
	    System.out.println("Provide a file path for your .srt file");
	    System.out.flush();
	    srtPath = scanner.nextLine();
	    if (check_input(srtPath)) {
		    break;
	    }
	}

	Movie movie = SrtParser.parse(srtPath); 
	ArrayList<String> strSubs = movie.getStringSubtitles();
	ArrayList<Subtitle> parsedSubs = movie.getParsedSubtitles();
	ArrayList<TimerTask> tasks = new ArrayList<>(); 
	
	System.out.println("Press Enter to start the subtitles");
	System.out.flush();
	scanner.nextLine();
	scanner.close();
	for (int k = 0; k < 4; k++) {
	    deleteln();
	}
	
	Timer timer = new Timer();
	
	for (int i = 0; i < strSubs.size(); i++) {
	    final int index = i;
	    tasks.add(new TimerTask() {
		    @Override
		    public void run() {
			if (index > 0) {
			    for (int j = 0; j < strSubs.get(index-1).lines().count(); j++) {
				    deleteln();
			    }
                         } 
			System.out.println(strSubs.get(index));  
		    }
		});
	    timer.schedule(tasks.get(i), parsedSubs.get(i).getStartTime());
	}

	TimerTask cancelTask = new TimerTask() {
		@Override
		public void run() {
		    timer.purge();
		    timer.cancel();
		}
	};
    timer.schedule(cancelTask, parsedSubs.get(parsedSubs.size() - 1).getEndTime() + 2000);
    }

    private static boolean check_input(String srtFilePath) {
	try {
	    if (!srtFilePath.contains(".srt")) {
		return false;
	    }
            Path filePath = Paths.get(srtFilePath);
            return filePath.toFile().isFile();
        } catch (Exception e) {
            return false;
        }
    }

    private static void deleteln() {
        System.out.print("\u001B[1A");
        System.out.print("\u001B[2K");
    }
}
