package select;

import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.IOException;

public abstract class Select<T> {
	BufferedReader reader;
	int choised = 0;
	String choises[] = {}; 
	
	public Select(BufferedReader reader) {
		this.reader = reader;
	}
	
	// 選択肢配列にset
	void setChoises(String[] choises) {
		this.choises = choises;
	}
	
	// 選択肢を選ぶように促す文言
	// 選択内容によって文言が違うので、抽象メソッド
	abstract void sendChoisesMessage();
	
	// 選択を受け取り、choisedに入れる
	public void input() {
		sendChoisesMessage();
		System.out.println("上記以外の数字を指定した場合は、自動的に0とします。");
		for(int x=0; x<choises.length; x++) {
			System.out.println(Integer.toString(x) + "：" + choises[x]);
		}

		String selectedNum = "";
        try {
        	selectedNum = reader.readLine();
        } catch (IOException e) {
			System.out.println(e);
        }
        
        // 数字以外が入力された時は、強制的に0を選択
        try {
        	this.choised = Integer.valueOf(selectedNum);
        } catch(NumberFormatException e) {
        	this.choised = 0;
        }
        
        if(0 <= this.choised && this.choised < choises.length) {
        } else {
        	this.choised = 0;
        	// 選択肢以外の数字だったら、0
        }
        
		System.out.println(choises[choised] + "  を選択しました。");
		System.out.println();
	}

	// 選択に応じて、クラスを返す
	// 選択内容によって返すクラスが違うので、総称体型を返す、抽象メソッド
	abstract public T getChoised(); 
}
