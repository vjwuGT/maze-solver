/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		wl.add(maze.start);
		maze.start.visit();
		while (!wl.isEmpty()) {
			Square current = wl.remove();
			if (current.equals(maze.finish)) {
				return current;
			}
			else {
				availableNeighbor(maze.contents, current, -1, 0, wl);
				availableNeighbor(maze.contents, current, 1, 0, wl);
				availableNeighbor(maze.contents, current, 0, 1, wl);
				availableNeighbor(maze.contents, current, 0, -1, wl);
			}
		}
		return null;
	}

	 /* Add any helper methods you want */
	
	// Will check if the square next to it is an available neighbor (contained in the maze, not a wall, and not visited)
	// if it is, the square will be marked as visited, have it's previous be current, and added to the worklist
	// if it is not, nothing will happen
	static void availableNeighbor(Square[][] contents, Square s, int rowOffset, int colOffset, SearchWorklist wl) {
		try {
			Square neighbor = contents[s.getRow() + rowOffset][s.getCol() +colOffset];
			if (!neighbor.isVisited()) {
				if (!neighbor.getIsWall()) {
					neighbor.visit();
					neighbor.setPrevious(s);
					wl.add(neighbor);
				}
			}
		}
		catch (Exception ArrayIndexOutOfBoundsException){
		}

	}

} 
