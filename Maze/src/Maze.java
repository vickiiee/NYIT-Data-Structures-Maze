//Author: Vickie Wu and Rosenaldie Beauvais
// 12-10-19 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private boolean[][] visit;
	
	private char[][] mazeArr;

	private int endRow;
	private int endCol;

	private LocationQueue queue;

	private Scanner asker;
	private Scanner inputFile;

	private String userInput;

	public boolean[][] getVisit() {
		return visit;
	}

	public Maze() {
		queue = new LocationQueue();
		asker = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.getQueue().getMazeClass(maze);
		maze.readFile();
		
		System.out.println("\nMaze in 2D Array:");
		maze.printArray();
		
		// TESTING
		//maze.getQueue().displayQueue();
		//maze.printPath();
		//maze.findRouteRecursion(maze.getQueue().getFirst());
		
		maze.findRouteQ(maze.getQueue().getFirst());
		
		//maze.findRouteLinkList(maze.getQueue().getFirst());
		
		System.out.println("\nPath in maze:");
		maze.printArray();
		
		//maze.printPath();
		//maze.getQueue().displayQueue();
	}

	public void findRouteQ(Location first) { 
		//int counter = 0;
		while (queue.isEmpty() == false) {
			Location current = queue.dequeue();

			//TESTING
			//System.out.println("\nCOUNTER: " + counter);
			//System.out.println("	reached = false: " + visit[current.getRowLocation()][current.getColLocation()]);
			//System.out.println("	Current location: (" + current.getRowLocation() + "," + current.getColLocation() + ")");
			
			/**coordinate has been visited**/
			mazeArr[current.getRowLocation()][current.getColLocation()] = '.';
			
			/**if current location/coordinate is end, you found the end**/
			if (current.getRowLocation() == endRow && current.getColLocation() == endCol) {
				//System.out.println("--------------------------------You did it! You found the end!--------------------------------------------------");
				break;
			} else {
				/**add possible next coordinates from current**/	

				/**check top**/
				if (current.getRowLocation() != 0) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation() - 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() - 1][current.getColLocation()] == true) {
						//System.out.println("	top");			
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation() - 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() - 1, current.getColLocation());
						queue.enqueue(k);
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						//counter++;
					}
				}

				/**check right**/
				if (current.getColLocation() != mazeArr[0].length - 1) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation()][current.getColLocation() + 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() + 1] == true) {
						//System.out.println("	right");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation()][current.getColLocation() + 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() + 1);
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
					}
				}

				/**check bottom**/
				if (current.getRowLocation() != mazeArr.length - 1) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation() + 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() + 1][current.getColLocation()] == true) {
						//System.out.println("	bottom");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation() + 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() + 1, current.getColLocation());
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
					}
				}

				/**check left**/
				if (current.getColLocation() != 0) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation()][current.getColLocation() - 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() - 1] == true) {
						//System.out.println("	left");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation()][current.getColLocation() - 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() - 1);
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
					}
				}
			}
		}
	}

	public void findRouteLinkList(Location current) {
		/**breadth first search**/
		//int counter = 0;
		while (current != null) {
			//System.out.println("\nCOUNTER: " + counter);
			//System.out.println("	reached = false: " + visit[current.getRowLocation()][current.getColLocation()]);
			
			//System.out.println("	Current location: (" + current.getRowLocation() + "," + current.getColLocation() + ")");

			/**coordinate has been visited**/
			mazeArr[current.getRowLocation()][current.getColLocation()] = '.';
			
			/**if current location/coordinate is end, you found the end**/
			if (current.getRowLocation() == endRow && current.getColLocation() == endCol) {
				//System.out.println("--------------------------------You did it! You found the end!--------------------------------------------------");
				break;
			} else {
				/**add possible next coordinates from current**/

				/**check top**/
				if (current.getRowLocation() != 0) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation() - 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() - 1][current.getColLocation()] == true) {
						//System.out.println("	top");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation() - 1][current.getColLocation()] = false; 
						
						Location k = new Location(current.getRowLocation() - 1, current.getColLocation());
						queue.enqueue(k);
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						//counter++;
					}
				}

				/**check right**/
				if (current.getColLocation() != mazeArr[0].length - 1) {
					
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation()][current.getColLocation() + 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() + 1] == true) {
						//System.out.println("	right");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation()][current.getColLocation() + 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() + 1);
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");	
					}
				}
				
				/**check bottom**/
				if (current.getRowLocation() != mazeArr.length - 1) {
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation() + 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() + 1][current.getColLocation()] == true) {
						//System.out.println("	bottom");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation() + 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() + 1, current.getColLocation());
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
					}
				}

				/**check left**/
				if (current.getColLocation() != 0) {
					/**if coordinate has not been visited and it has not been reached before:**/
					if (mazeArr[current.getRowLocation()][current.getColLocation() - 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() - 1] == true) {
						System.out.println("	left");
						
						/**coordinate has been reached; make it false**/
						visit[current.getRowLocation()][current.getColLocation() - 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() - 1);
						queue.enqueue(k);
						//counter++;
						//System.out.println("		increased counter: " + counter);
						//System.out.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
					}
				}
				current = current.getNext();
				queue.dequeue();
			}
		}
	}
	
	
	public void readFile() { 
		System.out.println("Enter the name of the maze file:");
		userInput = asker.next();

		File file = new File(userInput); /** finds file ---> ("src/" + userInput + ".txt");**/
		//src/maze2.txt
		//src/maze3.txt
		//src/mazetest1.txt
		//src/mazetester2.txt
		
		try {
			inputFile = new Scanner(file);

			int rows = inputFile.nextInt();
			int cols = inputFile.nextInt();
			int startRow = inputFile.nextInt();
			int startCol = inputFile.nextInt();
			endRow = inputFile.nextInt();
			endCol = inputFile.nextInt();

			/** initialize char array:**/
			mazeArr = new char[rows][cols];
			visit = new boolean[rows][cols];
			
			/** add entrance into queue**/
			Location start = new Location(startRow, startCol);
			queue.enqueue(start);
			
			/** Read lines from the file until no more are left.**/
			System.out.println("\nMaze from your file:");
			inputFile.nextLine();
			int row = 0;
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				for (int i = 0; i < cols; i++) {
					
					/** for every char in line place it into respective place in 2darray**/
					mazeArr[row][i] = line.charAt(i);
					
					/** all ' ' in mazeArr is a possible path from start to finish; mark it as true in the corresponding places in visit[][]**/
					if(line.charAt(i) == ' ') {
						visit[row][i] = true;
					}
				}
				/** Display the line read. **/
				System.out.println(line);
				row++;
			}
			
			/**mark entrance as reached**/
			visit[startRow][startCol]= false;
			
			inputFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			readFile();
		}
	}

	public void printArray() { 
		/**prints char array /maze**/
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[0].length; j++) {
				System.out.print(mazeArr[i][j]);
			}
			System.out.println("");
		}

		/**Testing: prints out visit boolean[][] **/
		/*System.out.println("\n");
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[0].length; j++) {
				if(visit[i][j] == true) {
					System.out.print(visit[i][j]+ "  |");
				}else {
					System.out.print(visit[i][j] +" |");
				}
			}
			System.out.println("");
		}*/
	}

	public void printPath() { 
		/**TESTING**/
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[0].length; j++) {
				/**unvisited**/
				if (mazeArr[i][j] == ' ') {
					if (i < 10) {
						System.out.print("(" + i + " ,");
						if (j < 10) {
							System.out.print(j + " )");
						} else {
							System.out.print(j + ")");
						}
					} else {
						System.out.print("(" + i + ",");
						if (j < 10) {
							System.out.print(j + " )");
						} else {
							System.out.print(j + ")");
						}
					}
				/**visited**/
				} else if (mazeArr[i][j] == '.') {
					System.out.print("(.....)");
				} else {
					System.out.print("(     )");
				}
			}
			System.out.println("");
		}
	}
 

	public char[][] getMazeArr() {
		return mazeArr;
	}
	
	public LocationQueue getQueue() {
		return queue;
	}
}
