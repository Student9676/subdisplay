class Subtitle {

    private int number;
    private String startTime;
    private String endTime;
    private String text;
    private String timeDuration;
    
    public Subtitle(number, startTime, endTime, text) {
	this.number = number;
	this.startTime = startTime;
	this.endTime = endTime;
	this.text = text;
    }

    @Override
    public String toString() {
	String str = null;
	str = this.number + "\n" + this.startTime + " --> " + this.endTime + "\n" + this.text;
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
