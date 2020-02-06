package read;

import java.util.ArrayList;
import java.util.Collections;

abstract public class ReadFile {
	
	String filename;
	ArrayList<String> questions = new ArrayList<String>();
	private int index = 0;
	
	public void setFilename(String filename) {
		// Eclipseで動作させるなら、ファイルのパスはこっち
		this.filename = filename;
		
		// ターミナルからコンパイルで動作させるなら、ファイルのパスはこっち
//		this.filename = "../" + filename;
	}
	
	// ファイルから実際に問題を読み込む
	// 単語か行かによって読み込み方が違うので、抽象メソッド
	abstract public void inputQuestions();
	
	// 各問題を入れた配列をシャッフル
	public void shuffleQuestions() {
		Collections.shuffle(questions);
	}
	
	// 今のindexに相当する問題(要素)があるか
	public boolean hasNowIndex() {
		return index < questions.size();
	}
	
	// 次の問題へ移る
	public void moveNext() {
		index += 1;
	}
	
	// index番目の問題を得る
	public String getQuestion(int index) {
		return questions.get(index);
	}
	
	// 問題が入った配列を丸々返す
	public ArrayList<String> getQuestions() {
		return questions;
	}
	
	// indexが指している問題を返す
	public String getThisQuestion() {
		return questions.get(index);
	}
	
//	// デバッグ用
//	public void printQuestions() {
//		for(String x : questions) {
//			System.out.println(x);
//		}
//	}
}
