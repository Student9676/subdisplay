package util;

public class Subtitle {

    private int number;
    private String startTime;
    private String endTime;
    private String text;
    private String timeDuration;
    
    public Subtitle() {
	this.number = 0;
	this.startTime = this.endTime = this.text = this.timeDuration = null;
    }
    
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

    public void setNumber(int num) {
	this.number = num;
    }
    public void setStartTime(String time) {
	this.startTime = time;
    }
    public void setEndTime(String time) {
	this.endTime = time;
    }
    public void setText(String text) {
	this.text = text;
    }

}
