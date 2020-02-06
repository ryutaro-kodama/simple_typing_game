package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByRow extends ReadFile {
	
	//行ごとに問題を読み込む
	@Override
	public void inputQuestions() {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
			String tmp = "";
			
			while((tmp=reader.readLine()) != null) {
				if(!tmp.isEmpty()) {					
					questions.add(tmp);
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(filename+ "がありません");
		} catch(IOException e) {
			System.out.println(e);
		}
	}

}
