import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */
	
	@Test
	public void testBasicQueueandStack() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "#___",
	            "__F_",
	            "S##_",
	            "____"
	        });
		String[] expected = {
				"#___",
				"**F_",
				"S##_",
				"____"
				};

		checkMaze(qwl, m, expected);
		
		
	}
	@Test
	public void testBasicStack() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "#___",
	            "__F_",
	            "S##_",
	            "____"
	        });
		String[] expected = {
				"#___",
				"__F*",
				"S##*",
				"****"
				};

		checkMaze(swl, m, expected);
	}
	@Test
	public void testStoppedEarly() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "#___",
	            "__F_",
	            "S##_",
	            "__#_"
	        });
		String[] expected = {
				"#___",
				"**F_",
				"S##_",
				"__#_"
				};
		checkMaze(swl, m, expected);
	}
	@Test
	public void testLotOfWalls() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "####",
	            "#___",
	            "#_#_",
	            "S_#F"
	        });
		String[] expected = {
				"####",
	            "#***",
	            "#*#*",
	            "S*#F"
				};
		checkMaze(qwl, m, expected);
	}
	@Test
	public void testNoWallsandCorner() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "___F",
	            "____",
	            "____",
	            "S___"
	        });
		String[] expected = {
				"___F",
	            "___*",
	            "___*",
	            "S***"
				};
		checkMaze(swl, m, expected);
	}
	@Test
	public void testGoingWestStack() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "____",
	            "___S",
	            "F___",
	            "____"
	        });
		String[] expected = {
				 "____",
		            "***S",
		            "F___",
		            "____"
				};
		checkMaze(swl, m, expected);
	}	
	@Test
	public void testGoingWestQueue() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "____",
	            "___S",
	            "F___",
	            "____"
	        });
		String[] expected = {
				 "____",
		            "___S",
		            "F***",
		            "____"
				};
		checkMaze(qwl, m, expected);
	}	
	@Test
	public void testNoWallsandCornerQueue() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "___F",
	            "____",
	            "____",
	            "S___"
	        });
		String[] expected = {
				"***F",
	            "*___",
	            "*___",
	            "S___"
				};
		checkMaze(qwl, m, expected);
	}
	@Test 
	public void testDiagonalandNull() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "###F",
	            "##_#",
	            "#_##",
	            "S###"
	        });
		checkMaze(swl, m, null);
	}
	@Test
	public void testNextToEachOther() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "____",
	            "____",
	            "_SF_",
	            "____"
	        });
		String[] expected = {
				 "____",
		            "____",
		            "_SF_",
		            "____"
		};
		checkMaze(qwl,m,expected);
	}
	@Test
	public void testFunkyQueue() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "___S",
	            "__#_",
	            "__#_",
	            "__F_"
	        });
		String[] expected = {
				"___S",
	            "__#*",
	            "__#*",
	            "__F*"
				};
		checkMaze(qwl, m, expected);
	}
	@Test
	public void testFunkyStack() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
	            "___S",
	            "__#_",
	            "__#_",
	            "__F_"
	        });
		String[] expected = {
				"***S",
	            "*_#_",
	            "**#_",
	            "_*F_"
				};
		checkMaze(swl, m, expected);
	}
	@Test
	public void testFunkyQueue2() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
	            "___F",
	            "__#_",
	            "__#_",
	            "__S_"
	        });
		String[] expected = {
				"___F",
	            "__#*",
	            "__#*",
	            "__S*"
				};
		checkMaze(qwl, m, expected);
	}
}




