package editDistance;

public class EditDistance {
	int array[][];
	String s1, s2;
	
	public void setString(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
	}
	
	// 2つの文字列に応じて二次元配列を作成
	public void setArray() {
		array = new int[s1.length()+1][];
		for(int i=0; i<=s1.length(); i++) {
			array[i] = new int[s2.length()+1];
		}
	}
	
	// 配列を初期化
	public void init() {
		for(int i=0; i<=s1.length(); i++) {
			array[i][0] = i;
		}

		for(int j=0; j<=s2.length(); j++) {
			array[0][j] = j;
		}
	}
	
	// (動的計画法で)表を作る
	public void makeArray() {
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				array[i][j] = Math.min(Math.min(insert(i, j), delete(i, j)), replace(i, j));
			}
		}
	}
	
	private int insert(int i, int j) {
		return array[i-1][j] + 1;
	}

	private int delete(int i, int j) {
		return array[i][j-1] + 1;
	}
	
	private int replace(int i, int j) {
		if(s1.charAt(i-1)==s2.charAt(j-1)) {
			return array[i-1][j-1];
			
		} else {
			return array[i-1][j-1] + 1;
		}
	}
	
	// 表の一番右下の値を返す
	public int getEditDistance() {
		return array[s1.length()][s2.length()];
	}
}