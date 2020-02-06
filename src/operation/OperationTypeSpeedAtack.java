package operation;

import java.io.BufferedReader;
import java.util.ArrayList;

// TypeSpeedAtack(1秒間のタイプ速度をスコア化)
public class OperationTypeSpeedAtack extends Operation {
	int remain = 10;
	
	public OperationTypeSpeedAtack(BufferedReader reader) {
		super(reader);
	}

	@Override
	boolean overLimitOrNot() {
		return 0 < remain;
	}

	@Override
	public void printRemain() {
		System.out.println("残り問題数は　" + Integer.toString(remain) + "　問です。");
	}

	@Override
	public void moveNextQuestion() {
		System.out.println("＊＊＊＊＊　正解です！　＊＊＊＊＊");
		rf.moveNext();
		ans.addAnswer(answer);
		et.addElapsedTime(tk.calculateTime());
		remain -= 1;
	}
	
	@Override
	public void stayThisQuestion() {
		System.out.println("- - 不正解なので同じ問題です - -");
	}

	@Override
	public int calcScore() {
		int baseScore = 1000;
		double averageSpeed = this.calcAverageSpeed();
		return (int)(baseScore - averageSpeed * averageSpeed * 100);
	}
	
	// 平均タイプスピードを求める
	private double calcAverageSpeed() {
		ArrayList<String> answers = ans.getAnswers();
		ArrayList<Double> ets = et.getElapsedTimes();
		double tmp = 0;
		
		for(int x=0; x<answers.size(); x++) {
			tmp += calcSpeed(answers.get(x), ets.get(x));
		}
		
		return tmp / answers.size();
	}

	@Override
	public void printScore() {
    	System.out.println("平均タイプスピードは　" + String.format("%.3f", this.calcAverageSpeed()) + "　(/s)です。");
    	System.out.println("得点は　" + Integer.toString(this.calcScore()) + "　点です。");
	}

}
