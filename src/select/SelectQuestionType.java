package select;

import java.io.BufferedReader;

import read.*;

public class SelectQuestionType extends Select<ReadFile> {
	String choises[] = {"単語ごとに出題",
						"行ごとに出題"};    // 出題方法を増やしたい場合は、ここに選択肢を追加

	public SelectQuestionType(BufferedReader reader) {
		super(reader);
		setChoises(choises);    //親クラスの選択肢配列の上書き
	}

	@Override
	void sendChoisesMessage() {
		System.out.println("出題形式を0~" + Integer.toString(this.choises.length-1) + "の中から選んでください。");
	}
	
	// 出題方法を増やしたい場合は、更にここで新しく作ったクラスをnewすれば良い
	// ファイルを読み込むクラスを返す
	@Override
	public ReadFile getChoised() {
		if(this.choised==0) {
			return new ReadFileByWord();
		} else {
			return new ReadFileByRow();
		}
	}
}
