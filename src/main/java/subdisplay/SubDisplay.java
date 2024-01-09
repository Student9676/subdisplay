package subdisplay;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SubDisplay {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	
	while (true) {
	    System.out.println("Provide a file path for your .srt file");
	    System.out.flush();
	    String srtFile = scanner.nextLine();
	    if (check_input(srtFile)) {
		break;
	    }
	}

	// Need parser
	
	scanner.close();
    }

    public static boolean check_input(String srtFilePath) {
	try {
            Path filePath = Paths.get(srtFilePath);
            return filePath.toFile().isFile();
        } catch (Exception e) {
            return false;
        }
    }
    

}
