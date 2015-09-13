/**
 * @author Thomas Shaw
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Linter {
	public static void main(String[] args){
		try {
			Scanner readIn = new Scanner(new FileReader(args[0]));
			int lineNum=0;
			boolean allGood = true;
			while(readIn.hasNextLine()){
				boolean success = true;
				lineNum++;
				success = checkLine(readIn.nextLine());
				if(!success){
					System.out.println(lineNum + ". Statement should end in a semicolon");
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
	
	public static boolean checkLine(String line){
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
		//System.out.println("NO SEMICOLON LOSER");
		return false;
	}
}
