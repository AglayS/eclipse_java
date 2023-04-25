package transaction;

public class FileMatchTest {

	public static void main(String[] args) {
		
		FileMatch application = new FileMatch();
		
		
		application.openFiles();
		
		application.processFiles();
		
		application.closeFiles();
		

		//to check if things are correct:
		//first, execute TransactFile and enter .txt file in search box
		//second, make sure the info is there
		//third, execute FileMatchTest and enter .txt file in search box
		//congratulations, you did it!
		
	}

}
