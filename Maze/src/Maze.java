import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private Scanner asker;
	private Scanner inputFile;

	private String userInput;

	private char[][] mazeArr;

	public Maze() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.readFile();
	}

	public void readFile() {
		asker = new Scanner(System.in);
		System.out.println("Enter the name of the maze file:");
		userInput = asker.next();

		File file = new File("src/" + userInput + ".txt"); // finds file

		try {
			inputFile = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			readFile();
		}

		int rows = inputFile.nextInt();
		int cols = inputFile.nextInt();
		int startRow = inputFile.nextInt();
		int startCol = inputFile.nextInt();
		int endRow = inputFile.nextInt();
		int endCol = inputFile.nextInt();
		
		//initialize char array:
		mazeArr = new char[rows][cols];
		
		// Read lines from the file until no more are left.
		int row = 0;
		inputFile.nextLine();
		while (inputFile.hasNextLine()) {
			// Read the next name.
			String line = inputFile.nextLine();
			for(int i = 0; i < cols; i++) {
				mazeArr[row][i] = line.charAt(i);
			}
			
			// Display the last name read.
			System.out.println(line);
			//System.out.println(line.length());
			row++;
			
		}
		inputFile.close();

		//print out 2dArr
		System.out.println("\n");
		for(int i= 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(mazeArr[i][j]);
			}
			System.out.println("");
		}
	}
}
