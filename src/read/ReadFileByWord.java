package read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileByWord extends ReadFile {

	//行ごとに問題を読み込み、単語に分割
	@Override
	public void inputQuestions() {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(filename)))){
			String tmp = "";
			
			while((tmp=reader.readLine()) != null) {
				String[] buffer = tmp.split(" ");
				for(String word: buffer) {
					if(!word.isEmpty()) {					
						questions.add(word);
					}
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println(filename+ "がありません");
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
