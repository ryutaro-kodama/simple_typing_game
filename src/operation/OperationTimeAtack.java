package operation;

import java.io.BufferedReader;

// TimeAtack(制限時間内の解答数をスコア化)
public class OperationTimeAtack extends Operation {
	double timeLimit = 30;

	public OperationTimeAtack(BufferedReader reader) {
		super(reader);
	}

	@Override
	boolean overLimitOrNot() {
		return 0 < timeLimit;
	}

	@Override
	public void printRemain() {
		System.out.println(String.format("残り時間は　%.3f　秒です。", timeLimit));
	}
	
	@Override
	public void moveNextQuestion() {
		System.out.println("＊＊＊＊＊　正解です！　＊＊＊＊＊");
		rf.moveNext();
		ans.addAnswer(answer);
		et.addElapsedTime(tk.calculateTime());
		timeLimit -= tk.calculateTime();
	}
	
	@Override
	public void stayThisQuestion() {
		System.out.println("- - 不正解なので同じ問題です - -");
		
		//不正解時も、総経過時間は加算しておく
		timeLimit -= tk.calculateTime();
	}

	@Override
	public int calcScore() {
		int baseScore = 100;
		return baseScore * ans.getAnswers().size();
	}

	@Override
	public void printScore() {
    	System.out.println("正解数は　" + Integer.toString(ans.getAnswers().size()) + "　問です。");
    	System.out.println("得点は　" + Integer.toString(this.calcScore()) + "　点です。");
	}
}
