package com.syntacticsugar.vooga.util.tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Paths {
	private Set<Path> paths;
	private Random rand;
	private List<Path> pathsList;

	public Paths(List<Stack<Point>> paths) {
		rand = new Random(1234); // TODO remove seed in production
		this.paths = new HashSet<Path>();
		pathsList = new ArrayList<Path>();
		for (int i = 0; i < paths.size(); i++) {
			Path path = new Path(paths.get(i));
			;
			this.paths.add(path);
			this.pathsList.add(path);
		}
	}

	public Set<Path> getAllPaths() {
		return paths;
	}

	public Set<Path> getRandomPaths(int num) {
		List<Path> duplicatePath = new ArrayList<Path>();
		duplicatePath.addAll(pathsList);
		Collections.shuffle(duplicatePath);
		if (num < 0 || num >= pathsList.size()) {
			num = pathsList.size();
		}
		Set<Path> returnSet = new HashSet<Path>();
		for (int i=0; i<num; i++) {
			returnSet.add(pathsList.get(i));
		}
		return returnSet;
	}

	public Set<Path> getRandomPaths() {
		return getRandomPaths(1);
	}

	public Path getPath() {
		int size = paths.size();
		int item = rand.nextInt(size);
		int i = 0;
		for (Path obj : paths) {
			if (i == item)
				return obj;
			i = i + 1;
		}
		return new Path(new Stack<Point>()); // TODO check
	}
}
