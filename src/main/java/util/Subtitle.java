package util;

public class Subtitle {

    private int number;
    private long startTime;
    private long endTime;
    private String text;
    private long duration;

    public Subtitle() {
        this.number = 0;
        this.startTime = this.endTime = this.duration = 0;
        this.text = null;
    }

    public Subtitle(int number, String startTime, String endTime, String text) {
        this.number = number;
        this.startTime = this.parseTime(startTime);
        this.endTime = this.parseTime(endTime);
        this.duration = this.endTime - this.startTime;
        this.text = text.trim();
    }

    @Override
    public String toString() {
        return this.number + "\n" + this.startTime + " --> " + this.endTime + "\n" + this.text;
    }

    public int getNumber() {
        return this.number;
    }
    public long getStartTime() {
        return this.startTime;
    }
    public long getEndTime() {
        return this.endTime;
    }
    public String getText() {
        return this.text;
    }
    public long getDuration() {
        return this.duration;
    }

    public void setNumber(int num) {
        this.number = num;
    }
    public void setStartTime(String time) {
        this.startTime = this.parseTime(time);
    }
    public void setEndTime(String time) {
        this.endTime = this.parseTime(time);
    }
    public void setText(String text) {
        this.text = text.trim();
    }

    private long parseTime(String timeStr) {
        String[] timeVals = timeStr.split(":");
        long hours = Long.parseLong(timeVals[0]);
        long minutes = Long.parseLong(timeVals[1]);
        long seconds = Long.parseLong(timeVals[2].split(",")[0]);
        long millisecs = 0;
        if (timeVals[2].split(",").length == 2) {
            millisecs = Long.parseLong(timeVals[2].split(",")[1]);
        }

        return (hours * 3600000) + (minutes * 60000) + (seconds * 1000) + millisecs;
    }

}