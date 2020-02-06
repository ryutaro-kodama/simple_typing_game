package module;

import java.util.ArrayList;

public class ElapsedTime {
	ArrayList<Double> elapsedTimes = new ArrayList<Double>();
	
	public void addElapsedTime(double time) {
		elapsedTimes.add(time);
	}
	
	public ArrayList<Double> getElapsedTimes() {
		return elapsedTimes;
	}
	
	public void printElapsedTimes() {
		for(double x : elapsedTimes) {
			System.out.println(String.format("%.2f", x));
		}
	}

}
