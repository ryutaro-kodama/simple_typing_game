package operation;

import java.io.BufferedReader;
import java.util.ArrayList;

import editDistance.EditDistance;

// AccuracyAtack(編集距離からタイピングの正確性をスコア化)
public class OperationAccuracyAtack extends Operation {
	int remain = 10;
	int totalEditDistance = 0;

	public OperationAccuracyAtack(BufferedReader reader) {
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
		System.out.println("＊＊＊　次の問題へ行きます　＊＊＊");
		rf.moveNext();
		ans.addAnswer(answer);
		et.addElapsedTime(tk.calculateTime());
		remain -= 1;
	}
	
	@Override
	public void stayThisQuestion() {
		//常に次の問題へ移るので、このメソッドは使わない
	}

	@Override
	public int calcScore() {
		int baseScore = 1000;
		
		return baseScore - totalEditDistance * 10;
	}
	
	// 編集距離のtotalを計算し、set
	private void setTotalEditDistance() {
		ArrayList<String> questions = rf.getQuestions();
		ArrayList<String> answers = ans.getAnswers();
		EditDistance ed = new EditDistance();
		
		for(int x=0; x<answers.size(); x++) {
			ed.setString(questions.get(x), answers.get(x));
			ed.setArray();
			ed.init();
			ed.makeArray();
			
			totalEditDistance += ed.getEditDistance();
		}
	}

	@Override
	public void printScore() {
		setTotalEditDistance();
    	System.out.println("総編集距離は　" + Integer.toString(totalEditDistance) + "　です。");
    	System.out.println("得点は　" + Integer.toString(this.calcScore()) + "　点です。");	
    }

	
	
	// 常に次の問題に遷移するようにオーバーライド
	public boolean nextOrNot() {
		return true;
	}
}
