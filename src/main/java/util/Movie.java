package util;

import java.util.ArrayList;
import util.Subtitle;


public class Movie {
    ArrayList<Subtitle> parsedSubtitles = new ArrayList<>();
    ArrayList<String> rawSubtitles = new ArrayList<>();
    
    public Movie() {
	this.parsedSubtitles = null;
	this.rawSubtitles = null;
    }
    
    public Movie(ArrayList<Subtitle> parsedSubtitles, ArrayList<String> rawSubtitles) {
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
	for (int i = 0; i < this.parsedSubtitles.size(); i++) {
	    str += this.rawSubtitles.get(i);
	}
	return str;
    }

    public void add(Subtitle sub) {
	this.parsedSubtitles.add(sub);
	this.rawSubtitles.add(sub.toString());
    }
    public void add(int index, Subtitle sub) {
	this.parsedSubtitles.add(index, sub);
	this.rawSubtitles.add(index, sub.toString());
    }
    public void add(ArrayList<Subtitle> subs) {
	for (int i = 0; i < subs.size(); i++) {
	    this.add(subs.get(i));
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
