//Author: Vickie Wu and Rosenaldie Beauvais

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
	private Scanner asker;
	private Scanner inputFile;

	private String userInput;

	private static char[][] mazeArr;

	private static LocationQueue queue;
	private static int endCol;
	private static int endRow;

	public Maze() {
		queue = new LocationQueue();
	}

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.getQueue().getMazeClass(maze);
		maze.readFile();
		// maze.findLocations();

		// testing
		maze.getQueue().displayQueue();
		
		//maze.findVertex();
		
		maze.printRoute();
		maze.getQueue().findRouteRecursion(queue.getFirst());
		//maze.getQueue().findRouteQ(queue.getFirst());
		maze.printArray();
		maze.printRoute();
		maze.getQueue().displayQueue();
	}

	public LocationQueue getQueue() {
		return queue;
	}

	public void setQueue(LocationQueue queue) {
		this.queue = queue;
	}

	public void findLocations() {
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[i].length; j++) {

				if (mazeArr[i][j] == ' ') {
					// System.out.println(mazeArr[i][j]);
					Location p = new Location(i, j);
					queue.insertLast(p);
				}
			}
		}
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
		endRow = inputFile.nextInt();
		endCol = inputFile.nextInt();

		Location start = new Location(startRow, startCol);
		queue.insertLast(start);
		// initialize char array:
		mazeArr = new char[rows][cols];

		// Read lines from the file until no more are left.
		int row = 0;
		inputFile.nextLine();
		while (inputFile.hasNextLine()) {
			// Read the next name.
			String line = inputFile.nextLine();
			for (int i = 0; i < cols; i++) {
				mazeArr[row][i] = line.charAt(i);
			}

			// Display the last name read.
			System.out.println(line);
			// System.out.println(line.length());
			row++;

		}
		inputFile.close();

		printArray();
	}

	public void printArray() {
		// print out 2dArr
		System.out.println("\n");
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[0].length; j++) {
				System.out.print(mazeArr[i][j]);
			}
			System.out.println("");
		}

	}

	public void printRoute() {
		// testing
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[0].length; j++) {
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

				} else if (mazeArr[i][j] == '.') {
					System.out.print("(.....)");
				} else {
					System.out.print("(     )");
				}
			}
			System.out.println("");
		}

		// queue.findRoute();
		/*
		 * while( current != null) Location current = first; //queue at start should
		 * onnly have one location! the start point //check
		 * 
		 */
		// markPath(coordinates);
	}
	
	public void findRoute() {//bfs
		//findVertex();
	}

	/*public void findVertex() {
		ArrayList<Location> vertex = new ArrayList(); // possiblt boolean
		// findLocs
		for (int i = 0; i < mazeArr.length; i++) {
			for (int j = 0; j < mazeArr[i].length; j++) {

				if (mazeArr[i][j] == ' ') {
					Location v = new Location(i, j);
					// System.out.println(mazeArr[i][j]);

					// check if it is a vertex if it has at right&top, right&bottom, left&top,left&bottom.
					
					// check top
					if (i != 0) {
						if (mazeArr[i - 1][j] == ' ') {
							System.out.println("	top");
							v.setTop(true);
						}
					}

					// check right
					if (j != mazeArr[0].length - 1) {
						if (mazeArr[i][j + 1] == ' ') {
							System.out.println("	right");
							v.setRight(true);
						}
					}

					// -----> //check bottom
					if (i != mazeArr.length - 1) {
						if (mazeArr[i + 1][j] == ' ') {
							System.out.println("	bottom");
							v.setBottom(true);
						}
					}

					// check left
					if (j != 0) {
						if (mazeArr[i][j - 1] == ' ') {
							System.out.println("	left");
							v.setLeft(true);
						}
					}
					
					if(v.isRight() == true && v.isBottom() == true || v.isRight() == true && v.isTop() == true || v.isLeft() == true && v.isBottom() == true || v.isLeft() ==true&& v.isTop() == true) {
						vertex.add(v);
					}
				}
			}
		}
		
		for(int i = 0; i < vertex.size(); i++) {
			System.out.print("Vertex @: "); 
			vertex.get(i).getCoordinates();
			System.out.println("");
		}
	}*/

	public char[][] getMazeArr() {
		return mazeArr;
	}

	public int getEndCol() {
		return endCol;
	}

	public int getEndRow() {
		return endRow;
	}
}
