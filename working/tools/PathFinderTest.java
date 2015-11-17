package tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PathFinderTest {
	public static void main(String args[]) {
		int rows = 10;
		int cols = 10;
		Map<Point, Boolean> map = generateMap(rows, cols);
		

		List<Point> start = new ArrayList<Point>();
		start.add(new Point(0, 0));
		List<Point> end = new ArrayList<Point>();
		end.add(new Point(7, 8));

		long startTime = System.currentTimeMillis();
		
		PathFinder pf = new PathFinder(map, rows, cols, start, end);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		Paths paths = pf.getPaths();
		// Set<Path> sP = paths.getRandomPaths(4);
		Set<Path> sP = paths.getAllPaths();

		for (Path pp : sP) {
			printPath(pp.getList(), rows, cols);
		}
		
		//pf.fillDistances(new Point(1,0), new Point(4,2));
		//Map<Point,  Integer> dM = pf.getDistanceMap();
		
		//printDistances(dM, rows, cols);

		//printPath(paths.getPath().getList(), rows, cols);
		
		System.out.printf("%15s: %d\n", "Numpaths", sP.size());
		System.out.printf("%15s: %d ms\n", "Time", time);

	}

	private static Map<Point, Boolean> generateMap(int rows, int cols) {
		Map<Point, Boolean> map = new HashMap<Point, Boolean>();
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Point p = new Point(c, r);
				map.put(p, true);
			}
		}
		return map;
	}

	private static void printPath(List<Point> path, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Point p = new Point(c, r);
				if (path.contains(p)) {
					System.out.printf("%2d ", path.indexOf(p) + 1);
				} else {
					System.out.printf("%2s ", "x");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void printDistances(Map<Point, Integer> dM, int rows, int cols) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Point p = new Point(c, r);
				if (dM.containsKey(p)) {
					System.out.printf("%2d ", dM.get(p));
				} else {
					System.out.printf("%2s ", "x");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
