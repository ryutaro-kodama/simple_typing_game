package editDistance;

public class EditDistanceDemo {
	// EditDistanceの動作チェック
	
	public static void main(String[] args) {
		String s1 = "apple";
		String s2 = "appppplet";
		
		EditDistance ed = new EditDistance();
		
		ed.setString(s1, s2);
		ed.setArray();
		ed.init();
		ed.makeArray();
		
		System.out.print(ed.getEditDistance());
	}

}
