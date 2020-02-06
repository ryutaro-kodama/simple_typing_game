package select;

import java.io.BufferedReader;
//import java.io.IOException;

import operation.*;

public class SelectMode extends Select<Operation> {
	String choises[] = {"AccuracyAtack(編集距離からタイピングの正確性をスコア化)",
						"ElapsedTimeAtack(一定数の問題を解くのに何秒かかったかをスコア化)",
						"TimeAtack(制限時間内の解答数をスコア化)",
						"TypeSpeedAtack(1秒間のタイプ速度をスコア化)"};    // ゲーム形式を増やしたい場合は、ここに選択肢を追加

	public SelectMode(BufferedReader reader) {
		super(reader);
		setChoises(choises);    //親クラスの選択肢配列の上書き
	}

	@Override
	void sendChoisesMessage() {
		System.out.println("ゲーム形式を0~" + Integer.toString(this.choises.length-1) + "の中から選んでください。");
	}

	@Override
	// ゲーム形式を増やしたい場合は、更にここで新しく作ったクラスをnewすれば良い
	// 出題などを操作するクラスを返す
	public Operation getChoised() {
		if(this.choised==0) {
			return new OperationAccuracyAtack(reader);
		} else if(this.choised==1) {
			return new OperationElapsedTimeAtack(reader);
		} else if(this.choised==2) {
			return new OperationTimeAtack(reader);
		} else {
			return new OperationTypeSpeedAtack(reader);
		}
	}

}
