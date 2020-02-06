import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import read.*;
import operation.*;
import select.*;

public class Main {

	public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {	
        	
        	SelectFile sf = new SelectFile(reader);
        	sf.input();    // ファイルの選択
        	
        	SelectQuestionType sqt = new SelectQuestionType(reader);
        	sqt.input();    // 出題形式の選択
        	
        	ReadFile rf = sqt.getChoised();
        	rf.setFilename(sf.getChoised());
        	rf.inputQuestions();
        	rf.shuffleQuestions();
        	
        	SelectMode sm = new SelectMode(reader);
        	sm.input();    // ゲーム形式の選択
        	
        	Operation ope = sm.getChoised();
        	ope.setRf(rf);    // 問題のクラスをset
		
        	while(ope.doQuestionOrNot()) {
        		ope.printRemain();    // 残りを表示
        		ope.printQuestion();    // 問題を表示
        		ope.setAnswer(ope.inputAnswer());    // 解答を入力
        		
        		if(ope.nextOrNot()) {
        			ope.moveNextQuestion();
        		} else {
        			ope.stayThisQuestion();
        		}
        	}

        	ope.printResult();
        	ope.printScore();
            
        } catch (IOException e) {
			System.out.println(e);
        }
		
	}

}
