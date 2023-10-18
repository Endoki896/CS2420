package labs.lab06;

import assignments.assign01.MathVector;

import java.util.*;

/**
 * This class demonstrates how to use iterators, for Lab 6.
 * 
 * @author CS 2420 course staff
 * @version September 29, 2023
 */
public class IteratorDemo {
	public static void main(String[] args) {
		SortedSet<Integer> ss = new TreeSet<>();

		// How we like to see this
		for (int element : ss) {
			System.out.println(element);
		}

		// But this is what it is really doing
		Iterator<Integer> iter = ss.iterator();
		while (iter.hasNext()) {
			int element = iter.next();
			System.out.println(element);
		}

		// Same thing, different loop
		for (Iterator<Integer> it = ss.iterator(); it.hasNext();) {
			int element = it.next();
			System.out.println(element);
		}

		// this works for ANY collection:
		Collection<Integer> collection = new ArrayList<>();
		collection = new LinkedList<Integer>();
		collection = new HashSet<>();
		collection = new Vector<>();
		collection = new PriorityQueue<>();

		Queue<Integer> q = new LinkedList<>();
		q = new PriorityQueue<>();

		Stack<Integer> stack = new Stack<>();

		Iterator<Integer> iterator;
		iterator = collection.iterator();
		iterator = q.iterator();
		iterator = stack.iterator();

		for (int whatever : collection) {
			System.out.println(whatever);
		}

		for (int something : q) {
			System.out.println(q);
		}

		for (int nothing : stack) {
			System.out.println(stack);
		}

		List<MathVector> list = new ArrayList<>();
		list.add(new MathVector(new double[][]{{0, 2, 5}}));
		list.add(new MathVector(new double[][]{{10}, {9}, {-4}}));
		list.add(new MathVector(new double[][]{{36, 8, 52}}));
		list.add(new MathVector(new double[][]{{-46}, {42}, {987}}));
		list.add(new MathVector(new double[][]{{43110}, {80085}, {40404040}}));
		for(Iterator<MathVector> mathIterator = list.iterator(); mathIterator.hasNext();)
		{
			MathVector e = mathIterator.next();
			System.out.println("Before:\n" + e);
			e = e.transpose();
			System.out.println("After:\n" + e);
		}
	}
}
