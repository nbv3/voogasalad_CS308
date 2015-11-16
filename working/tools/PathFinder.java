package tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class PathFinder {
	public final int MAX_PATHS = 30;
	public final int SKIP = 100; // How many to skip before grabbing another - random path find

	private Map<Point, Boolean> grid;
	private List<Point> start;
	private List<Point> end;
	private List<Stack<Point>> paths;
	private Set<Point> visited;
	private Map<Point, List<Point>> memo;

	private Queue<Point> bfsQueue;

	private int rows;
	private int cols;
	private int currentPaths = 0;
	private int counter = 0;

	public PathFinder(Map<Point, Boolean> pathGrid, int rows, int cols, List<Point> start, List<Point> end) {
		grid = pathGrid;
		this.start = start;
		this.end = end;
		this.rows = rows;
		this.cols = cols;
		paths = new ArrayList<Stack<Point>>();
		visited = new HashSet<Point>();
		memo = new HashMap<Point, List<Point>>();

		bfsQueue = new PriorityQueue<Point>();
		findPaths();
		System.out.printf("%15s: %d\n", "Counter", counter);
	}

	public Paths getPaths() {
		return new Paths(paths);
	}

	private void findPaths() {
		for (Point p : start) {
			dfs(p, new Stack<Point>());
		}
	}

	private void dfs(Point p, Stack<Point> path) {
		// if p is within destination, add to Path
		if (currentPaths >= MAX_PATHS) {
			return;
		}
		visited.add(p);
		path.push(p);
		if (end.contains(p)) {
			if (counter % SKIP == 0) {
				Stack<Point> pushedStack = new Stack<Point>();
				pushedStack.addAll(path);
				paths.add(pushedStack);
				currentPaths++;
			}
			counter++;
		} else {
			for (Point n : getNeighbors(p)) {
				if (!visited.contains(n)) {
					dfs(n, path);
				}
			}
		}
		visited.remove(p);
		path.pop();
	}

	private void bfs(Point p, Stack<Point> path) {
		// TODO BFS cannot work - too slow for large grids
		bfsQueue.add(p);
		visited.add(p);
		while (!bfsQueue.isEmpty()) {
			Point front = bfsQueue.poll();

			List<Point> nb = getNeighbors(front);
			for (Point n : nb) {
				if (grid.get(n) && !visited.contains(n)) {
					bfsQueue.add(n);
					visited.add(n);
				}
			}
		}
		// Clear visited property of nodes
		visited.clear();
	}

	private List<Point> getNeighbors(Point p) {
		if (memo.containsKey(p)) {
			List<Point> ret = memo.get(p);
			Collections.shuffle(ret);
			return ret;
		}
		List<Point> validPoints = new ArrayList<Point>();
		int x = p.x;
		int y = p.y;
		if (x - 1 >= 0) {
			Point n = new Point(x - 1, y);
			if (grid.get(n)) {
				validPoints.add(n);
			}
		}
		if (x + 1 < cols) {
			Point n = new Point(x + 1, y);
			if (grid.get(n)) {
				validPoints.add(n);
			}
		}

		if (y - 1 >= 0) {
			Point n = new Point(x, y - 1);
			if (grid.get(n)) {
				validPoints.add(n);
			}

		}
		if (y + 1 < rows) {
			Point n = new Point(x, y + 1);
			if (grid.get(n)) {
				validPoints.add(n);
			}

		}
		memo.put(p, validPoints);
		Collections.shuffle(validPoints); // TODO SLOW
		return validPoints;
	}

}
