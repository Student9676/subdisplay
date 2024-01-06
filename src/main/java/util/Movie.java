package util;
import util.Subtitle;


class Movie {
    ArrayList<Subtitle> parsedSubtitles = new ArrayList<>();
    ArrayList<String> rawSubtitles = new ArrayList<>();
    
    public Subtitles() {
	this.parsedSubtitles = null;
	this.rawSubtitles = null;
    }
    
    public Subtitles(ArrayList<Subtitle> parsedSubtitles, ArrayList<String> rawSubtitles) {
	this.parsedSubtitles = parsedSubtitles;
	this.rawSubtitles = rawSubtitles;
    }

    public ArrayList<Subtitle> getParsedSubtitles() {
	return this.parsedSubtitles;
    }

    public ArrayList<String> getStringSubtitles() {
	return this.rawSubtitles;
    }

    @Override
    public String toString() {
	String str = "";
	for (i = 0; i < this.parsedSubtitles.length; i++) {
	    str += this.parsedSubtitles[i];
	}
	return str;
    }

    public void add(Subtitle sub) {
	this.parsedSubtitles.add(sub);
	this.rawSubtitles.add(sub.toString())
    }
    public void add(int index, Subtitle sub) {
	this.parsedSubtitles.add(index, sub);
	this.rawSubtitles.add(index, sub.toString())
    }
    public void add(Subtitle[][] subs) {
	for (int i = 0; i < subs.length; i++) {
	    this.add(subs[i]);
	}
    }    

    public Subtitle remove(int index) {
	this.rawSubtitles.remove(index);
	return this.parsedSubtitles.remove(index);
    }
    public void remove(Subtitle sub) {
	this.parsedSubtitles.remove(sub);
	this.rawSubtitles.remove(sub);
    }

    public int subSize() {
	return this.parsedSubtitles.size();
    }
    
}
