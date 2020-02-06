package operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import module.Answer;
import module.ElapsedTime;
import module.TimeKeeper;
import read.*;

abstract public class Operation {
	BufferedReader reader;
	ReadFile rf;
	Answer ans;
	ElapsedTime et;
	TimeKeeper tk;
	
	String answer;
	
	public Operation(BufferedReader reader) {
		this.reader = reader;
		this.ans = new Answer();
		this.et = new ElapsedTime();
		this.tk = new TimeKeeper();
	}

	// 読み込みファイルを扱う関数をset
	public void setRf(ReadFile rf) {
		this.rf = rf;
	}
	
	// まだ出題を続けるかを返す
	public boolean doQuestionOrNot() {
		return rf.hasNowIndex() && overLimitOrNot();
		// 今指している問題があるか、かつ、(時間・問題数などの)制限を超えていないか
	}
	
	// (時間・問題数などの)制限を超えていないかを返す
	// ゲーム形式によって違うので、抽象メソッド
	abstract boolean overLimitOrNot();
	
	// 残りの時間や問題数を返す
	// ゲーム形式によって違うので、抽象メソッド
	abstract public void printRemain();
	
	// 問題を返す
	public void printQuestion() {
		String question = rf.getThisQuestion();
		System.out.println("以下を入力してください");
		System.out.println(question);
	}
	
	// 標準入力で解答を受け取る
	public String inputAnswer() {
		String answer = "";
		
		System.out.println("あなたの入力：");
        
		try {
	       	tk.setStart();
			answer = reader.readLine();
            tk.setEnd();
        } catch (IOException e) {
			System.out.println("解答の入力でエラーが発生しました。");
			System.out.println(e);
		}
		
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	// 次の問題に移るかを返す
	// 基本は問題と答えがあっていれば移る。AccuracyAtackの時だけは常に次へ移るので、オーバーライド
	public boolean nextOrNot() {
		String question = rf.getThisQuestion();
		return question.equals(answer);
	}
	
	// 次の問題へ移る時の処理
	abstract public void moveNextQuestion();
	
	// おなじ問題に留まった時の処理
	abstract public void stayThisQuestion();
	
	// 結果を表示する
	public void printResult() {
		ArrayList<String> questions = rf.getQuestions();
		ArrayList<String> answers = ans.getAnswers();
		ArrayList<Double> ets = et.getElapsedTimes();
		
    	System.out.println("〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜");
    	System.out.println("〜〜〜〜　結果を表示します　〜〜〜〜");
    	System.out.println("〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜");
		
        for(int x=0; x<answers.size(); x++) {
        	System.out.print(Integer.toString(x+1) + "問目：");
        	System.out.println(questions.get(x));
        		
            System.out.print("あなたの解答：");
           	System.out.println(answers.get(x));
           	System.out.println(checkResult(questions.get(x), answers.get(x)));
           	
           	System.out.print("経過時間：");
           	System.out.println(ets.get(x));
            	
           	System.out.print("タイプ速度(/s)：");
           	System.out.println(String.format("%.3f", calcSpeed(answers.get(x), ets.get(x))));
        	
        	System.out.println("〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜");
        }

    	System.out.println("〜〜〜〜　結果は以上です。　〜〜〜〜");
    	System.out.println("〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜〜");
    	
	}

	// 解答が正解かどうかを表示
	private String checkResult(String question, String answer) {
		if(question.equals(answer)) {
			return "＊＊＊＊＊　正解です！　＊＊＊＊＊";
		} else {
			return "- - - - - 不正解です - - - - -";
		}
	}
	
	// 入力文字数と経過時間から速度を計算
	double calcSpeed(String answer, double time) {
		return ((double)answer.length() / time);
	}
	
	// スコアを計算する
	abstract public int calcScore();
	
	// スコアを表示する
	abstract public void printScore();
}
