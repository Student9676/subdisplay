package subdisplay;

import java.nio.file.Path;
import java.nio.file.Paths;

class SubDisplay {

    public static void main(String[] args) {

	boolean invalidInput = true;
	Scanner scanner = new Scanner(System.in);
	
	while (true) {
	    System.out.println("Provide a file path for your .srt file");
	    String srtFile = scanner.nextLine();
	    if (check_input(srtFile)) {
		break;
	    }
	}

	// Need parser
	
	
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
