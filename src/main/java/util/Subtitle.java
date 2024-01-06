package util;

public class Subtitle {

    private int number;
    private String startTime;
    private String endTime;
    private String text;
    private String timeDuration;
    
    public Subtitle(int number, String startTime, String endTime, String text) {
	this.number = number;
	this.startTime = startTime;
	this.endTime = endTime;
	this.text = text;
    }

    @Override
    public String toString() {
	return this.number + "\n" + this.startTime + " --> " + this.endTime + "\n" + this.text;
    }
    
    public int getNumber() {
	return this.number;
    }

    public String getStartTime() {
	return this.startTime;
    }

    public String getEndTime() {
	return this.endTime;
    }

    public String getText() {
	return text;
    }
}
