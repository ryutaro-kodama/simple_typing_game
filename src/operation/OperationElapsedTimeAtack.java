package operation;

import java.io.BufferedReader;

// ElapsedTimeAtack(一定数の問題を解くのに何秒かかったかをスコア化)
public class OperationElapsedTimeAtack extends Operation {
	int remain = 10;
	double totalTime = 0;

	public OperationElapsedTimeAtack(BufferedReader reader) {
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
		totalTime += tk.calculateTime();
		remain -= 1;
	}
	
	@Override
	public void stayThisQuestion() {
		System.out.println("- - 不正解なので同じ問題です - -");
		
		//不正解時も、総経過時間は加算しておく
		totalTime += tk.calculateTime();
	}

	@Override
	public int calcScore() {
		int baseScore = 1000;
		return (int)(baseScore - totalTime * totalTime);
	}

	@Override
	public void printScore() {
    	System.out.println("経過時間は　" + Double.toString(totalTime) + "　秒です。");
    	System.out.println("得点は　" + Integer.toString(this.calcScore()) + "　点です。");
	}

}
