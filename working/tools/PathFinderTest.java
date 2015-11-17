package tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PathFinderTest {
	public static void main(String args[]) {
		int rows = 20;
		int cols = 20;
		Map<Point, Boolean> map = generateMap(rows, cols);
		for (int i=0; i<= 18; i++) {
			map.put(new Point(i, 10), false);
		}
		for (int i=1; i<= 10; i++) {
			map.put(new Point(10, i), false);
		}

		List<Point> start = new ArrayList<Point>();
		start.add(new Point(0, 0));
		start.add(new Point(14, 16));
		List<Point> end = new ArrayList<Point>();
		end.add(new Point(7, 8));
		end.add(new Point(19, 18));

		/*long startTime = System.currentTimeMillis();

		PathFinder pf = new PathFinder(map, rows, cols, start, end);
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		Paths paths = pf.getPaths();
		Set<Path> sP = paths.getAllPaths();

		for (Path pp : sP) {
			printPath(pp.getList(), rows, cols, map);
		}*/
		
		PathFinder pf2 = new PathFinder(map, rows, cols, new Point(0,0), new Point(12, 12));
		Path  peth = pf2.getPath();
		printPath(peth.getList(), rows, cols, map);

		// printDistances(dM, rows, cols);

		// System.out.printf("%15s: %d\n", "Numpaths", sP.size());
		// System.out.printf("%15s: %d ms\n", "Time", time);

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

	private static void printPath(List<Point> path, int rows, int cols, Map<Point, Boolean> map) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Point p = new Point(c, r);
				if (path.contains(p)) {
					System.out.printf("%2d ", path.indexOf(p) + 1);
				} else if (map.get(p)){
					System.out.printf("%2s ", "*");
				} else {
					System.out.printf("%2s ", "X");
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
