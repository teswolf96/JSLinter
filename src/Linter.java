/**
 * @author Thomas Shaw
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Linter {
	//Test
	public static void main(String[] args){
		try {
			Scanner readIn = new Scanner(new FileReader(args[0]));
			int lineNum=0;
			boolean allGood = true;
			while(readIn.hasNextLine()){
				boolean success = true;
				lineNum++;
				String newLine = readIn.nextLine();
				success = checkLine(newLine ,lineNum);
				if(!success){
					allGood = false;
				}
			}
			if(allGood)
				System.out.println("Operation completed successfully");
			readIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

	}
	
	public static boolean checkLine(String line, int lineNum){
		if(line.matches("\\s*$")){
			//System.out.println("Whitespace");
			return true;
		}
		else if(line.matches(".*;$")){
			//System.out.println("Proper semi usage!");
			return true;
		}
		else if(line.matches(".*\\{$")){
			//System.out.println("OPEN BRACE!");
			return true;
		}
		
		else if(line.matches("\\}$")){
			//System.out.println("CLOSE BRACE!");
			return true;
		}
		else if(line.matches(".*;\\s+$")){
			System.out.println(lineNum + ". Whitepace at end of line");
			return false;
			
		}
		else if(line.matches(".*$")){
			System.out.println(lineNum + ". Statement should end in a semicolon");
			return false;
		}else if(line.matches(".*\\z")){
			System.out.println(lineNum + ". cats");
			return false;
		}
		return false;
		//System.out.println("NO SEMICOLON LOSER");
		//return false;
	}
	
	public static boolean checkEOF(String line, int lineNum){
		if(line.matches("\\z")){
			System.out.println("EOF PROBLEM");
			return false;
		}
		return true;
	}
}
