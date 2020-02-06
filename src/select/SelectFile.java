package select;

import java.io.BufferedReader;

public class SelectFile extends Select<String> {
	String choises[] = {"loremIpsum.txt",
						"whatIsLoremIpsum.txt",
						"baseEnglishWords30.txt"};    // ファイルを増やしたい場合は、ここにファイル名を足せば良い

	public SelectFile(BufferedReader reader) {
		super(reader);
		setChoises(choises);    //親クラスの選択肢配列の上書き
	}

	@Override
	void sendChoisesMessage() {
		System.out.println("出題形式を0~" + Integer.toString(this.choises.length-1) + "の中から選んでください。");
	}
	
	// ファイル名を返す
	@Override
	public String getChoised() {
		return choises[choised];
	}
}
