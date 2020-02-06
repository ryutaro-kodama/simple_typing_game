package module;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;

public class Answer {
	ArrayList<String> answers = new ArrayList<String>();
	TimeKeeper tk = new TimeKeeper();
	
	public void addAnswer(String answer) {
		answers.add(answer);
	}
	
	public String getAnswer(int index) {
		return answers.get(index);
	}
	
	public ArrayList<String> getAnswers() {
		return answers;
	}
	
	public void printAnswers() {
		for(String x : answers) {
			System.out.println(x);
		}
	}

}
