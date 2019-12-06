//Author: Vickie Wu and Rosenaldie Beauvais
// 12-10-19

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	private boolean[][] visit;
	private boolean stop;
	
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
		stop = false;
	}

	public static void main(String[] args) {
		Maze maze = new Maze();
		maze.getQueue().getMazeClass(maze);
		maze.readFile();

		// testing
		maze.getQueue().displayQueue();

		maze.printRoute();
		// maze.getQueue().findRouteRecursion(maze.getQueue().getFirst());
		maze.findRouteQ(maze.getQueue().getFirst());
		// maze.findRouteLinkList(maze.getQueue().getFirst());
		maze.printArray();
		maze.printRoute();
		maze.getQueue().displayQueue();
	}

	public String findRouteQ(Location first) {
		int counter = 0;
		while (queue.isEmpty() == false) {
			Location current = queue.deleteFirst();

			System.out.println("\nCOUNTER: " + counter);
			System.out.println("	Possible Path? " + visit[current.getRowLocation()][current.getColLocation()]);
			// -if current location/coordinate is end, you found the end
			System.out
					.println("	Current location: (" + current.getRowLocation() + "," + current.getColLocation() + ")");// \n
																														// endrow:
																														// "
																														// +
																														// endRow
																														// +
																														// ",
																														// end
																														// col:"
																														// +
																														// endCol);
//if (visit[current.getRowLocation()][current.getColLocation()] == true) {

			mazeArr[current.getRowLocation()][current.getColLocation()] = '.';
//visit[current.getRowLocation()][current.getColLocation()] = false;
			// deleteFirst();
			if (current.getRowLocation() == endRow && current.getColLocation() == endCol) {
				System.out.println(
						"--------------------------------You did it! You found the end!--------------------------------------------------");
				// stop = true; //recursion only
				// break;
				return "You did it! You found the end!";
			} else {
				// add possible next coordinates from current

				// check top
				if (current.getRowLocation() != 0) {
					if (mazeArr[current.getRowLocation() - 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() - 1][current.getColLocation()] == true) {
						System.out.println("	top");
//bottom commented out							
						visit[current.getRowLocation() - 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() - 1, current.getColLocation());
						queue.insertLast(k);
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						counter++;
						// }
						// findRouteQ(k);
						// current = current.getNext();
						// break;
					}
				}

				// check right
				if (current.getColLocation() != mazeArr[0].length - 1) {
					if (mazeArr[current.getRowLocation()][current.getColLocation() + 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() + 1] == true) {
						System.out.println("	right");
						visit[current.getRowLocation()][current.getColLocation() + 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() + 1);
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}

//----->		//check bottom
				if (current.getRowLocation() != mazeArr.length - 1) {
					if (mazeArr[current.getRowLocation() + 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() + 1][current.getColLocation()] == true) {
						System.out.println("	bottom");
						visit[current.getRowLocation() + 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() + 1, current.getColLocation());
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}

				// check left
				if (current.getColLocation() != 0) {
					if (mazeArr[current.getRowLocation()][current.getColLocation() - 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() - 1] == true) {
						System.out.println("	left");
						visit[current.getRowLocation()][current.getColLocation() - 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() - 1);
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}
			}
//	} else {
//				System.out.println("ELSE");
//				current = current.getNext();
//			}
		}
		return "nono";
	}

	public void readFile() { 
		System.out.println("Enter the name of the maze file:");
		userInput = asker.next();

		File file = new File("src/" + userInput + ".txt"); // finds file

		try {
			inputFile = new Scanner(file);

			
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
			visit = new boolean[rows][cols];

			// Read lines from the file until no more are left.
			inputFile.nextLine();
			int row = 0;
			while (inputFile.hasNextLine()) {
				String line = inputFile.nextLine();
				for (int i = 0; i < cols; i++) {
					//for every char in line place it into respective place in 2darray
					mazeArr[row][i] = line.charAt(i);
				}
				// Display the line read.
				System.out.println(line + " f");
				row++;

			}
			inputFile.close();
			printArray();

			//all ' ' in mazeArr is a possible path from start to finish; mark it as true in the corresponding places in visit[][]
			for (int i = 0; i < mazeArr.length; i++) {
				for (int j = 0; j < mazeArr[0].length; j++) {
					if (mazeArr[i][j] == ' ') {
						visit[i][j] = true;
					}
				}
			}

			//Testing: prints out boolean[][] 
			System.out.println("\n");
			for (int i = 0; i < visit.length; i++) {
				for (int j = 0; j < visit[0].length; j++) {
					System.out.print(visit[i][j]);
				}
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			readFile();
		}

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

		//
		System.out.println("\n");
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[0].length; j++) {
				System.out.print(visit[i][j]);
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
	}

	public String findRouteLinkList(Location current) {// more like linked list than queue
		System.out.println("-----------------------BREADTH FIRST SEARCH... KINDA--------------------------");
		// -RECURSION; no while loop just dequeue and make parameter the location class
		// Location current = first;

		int counter = 0;
		while (current != null) {
			System.out.println("\nCOUNTER: " + counter);
			System.out.println("	Possible Path? " + visit[current.getRowLocation()][current.getColLocation()]);
			// -if current location/coordinate is end, you found the end
			System.out
					.println("	Current location: (" + current.getRowLocation() + "," + current.getColLocation() + ")");// \n
																														// endrow:
																														// "
																														// +
																														// endRow
																														// +
																														// ",
																														// end
																														// col:"
																														// +
																														// endCol);
//if (visit[current.getRowLocation()][current.getColLocation()] == true) {

			mazeArr[current.getRowLocation()][current.getColLocation()] = '.';
//visit[current.getRowLocation()][current.getColLocation()] = false;
			// deleteFirst();
			if (current.getRowLocation() == endRow && current.getColLocation() == endCol) {
				System.out.println(
						"--------------------------------You did it! You found the end!--------------------------------------------------");
				// stop = true; //recursion only
				// break;
				return "You did it! You found the end!";
			} else {
				// add possible next coordinates from current

				// check top
				if (current.getRowLocation() != 0) {
					if (mazeArr[current.getRowLocation() - 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() - 1][current.getColLocation()] == true) {
						System.out.println("	top");
//bottom commented out							
						visit[current.getRowLocation() - 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() - 1, current.getColLocation());
						queue.insertLast(k);
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						counter++;
						// }
						// findRouteQ(k);
						// current = current.getNext();
						// break;
					}
				}

				// check right
				if (current.getColLocation() != mazeArr[0].length - 1) {
					if (mazeArr[current.getRowLocation()][current.getColLocation() + 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() + 1] == true) {
						System.out.println("	right");
						visit[current.getRowLocation()][current.getColLocation() + 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() + 1);
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}

//----->		//check bottom
				if (current.getRowLocation() != mazeArr.length - 1) {
					if (mazeArr[current.getRowLocation() + 1][current.getColLocation()] == ' '
							&& visit[current.getRowLocation() + 1][current.getColLocation()] == true) {
						System.out.println("	bottom");
						visit[current.getRowLocation() + 1][current.getColLocation()] = false;
						Location k = new Location(current.getRowLocation() + 1, current.getColLocation());
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}

				// check left
				if (current.getColLocation() != 0) {
					if (mazeArr[current.getRowLocation()][current.getColLocation() - 1] == ' '
							&& visit[current.getRowLocation()][current.getColLocation() - 1] == true) {
						System.out.println("	left");
						visit[current.getRowLocation()][current.getColLocation() - 1] = false;
						Location k = new Location(current.getRowLocation(), current.getColLocation() - 1);
						queue.insertLast(k);
						counter++;
						System.out.println("		increased counter: " + counter);
						System.out
								.println("		Added: " + "(" + k.getRowLocation() + "," + k.getColLocation() + ")");
						// current = current.getNext();
						// break;
						// deleteFirst();
					}
				}

				current = current.getNext();
				// current = current.getNext();
				queue.deleteFirst();
			}
//	} else {
//				System.out.println("ELSE");
//				current = current.getNext();
//			}
		}
		return "no";

	}
	
	public String findRouteRecursion(Location current) {// int endRow, int endCol, char[][] mazeArr
		System.out.println("-----------------------RECURSION--------------------------");
		// -RECURSION; no while loop just dequeue and make parameter the location class
		// Location current = first;
		// while(current != null) {
		// -if current location/coordinate is end, you found the end
		System.out.println("Current location: " + current.getRowLocation() + "," + current.getColLocation()
				+ "\n endrow: " + endRow + ", end col:" + endCol);
		mazeArr[current.getRowLocation()][current.getColLocation()] = '.';
		// deleteFirst();
		if (current.getRowLocation() ==endRow && current.getColLocation() == endCol) {
			System.out.println(
					"--------------------------------You did it! You found the end!--------------------------------------------------");
			stop = true;

			return "You did it! You found the end!";
		} else {
			// add possible next coordinates from current

			// check top
			if (current.getRowLocation() != 0 && stop == false) {
				if (mazeArr[current.getRowLocation() - 1][current.getColLocation()] == ' ') {
					System.out.println("	top");
					Location k = new Location(current.getRowLocation() - 1, current.getColLocation());
					queue.insertLast(k);
					findRouteRecursion(k);
					// deleteFirst();
					// delete first?
					// method with ^location as parameter and make possibly 2 booleans: visted and
					// in queue so no repeated location classes in it... mayb not need this bcuz
					// visited space will already b marked with '.'
				}
			}

			// check right
			if (current.getColLocation() != mazeArr[0].length - 1 && stop == false) {
				if (mazeArr[current.getRowLocation()][current.getColLocation() + 1] == ' ') {
					System.out.println("	right");
					Location k = new Location(current.getRowLocation(), current.getColLocation() + 1);
					queue.insertLast(k);
					findRouteRecursion(k);
					// deleteFirst();
				}
			}

//----->		//check bottom
			if (current.getRowLocation() != mazeArr.length - 1 && stop == false) {
				if (mazeArr[current.getRowLocation() + 1][current.getColLocation()] == ' ') {
					System.out.println("	bottom");
					Location k = new Location(current.getRowLocation() + 1, current.getColLocation());
					queue.insertLast(k);
					findRouteRecursion(k);
					// deleteFirst();
				}
			}

			// check left
			if (current.getColLocation() != 0 && stop == false) {
				if (mazeArr[current.getRowLocation()][current.getColLocation() - 1] == ' ') {
					System.out.println("	left");
					Location k = new Location(current.getRowLocation(), current.getColLocation() - 1);
					queue.insertLast(k);
					findRouteRecursion(k);
					// deleteFirst();
				}
			}

			queue.deleteFirst();
		}

		return "nononoonono";
	}

	public char[][] getMazeArr() {
		return mazeArr;
	}
	
	public LocationQueue getQueue() {
		return queue;
	}
}
