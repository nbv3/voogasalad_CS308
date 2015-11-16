package tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Path {
	List<Point> list;
	Stack<Point> stack;
	public Path(Stack<Point> path) {
		list = new ArrayList<Point>();
		stack = path;
		list.addAll(stack);
	}
	
	public List<Point> getList() {
		return list;
	}
	
	public Stack<Point> getStack() {
		return stack;
	}
}
