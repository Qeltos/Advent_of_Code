package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayOne {

	public static void main(String[] args) {
		List<Integer> leftCol = new ArrayList<>();
		List<Integer> rightCol = new ArrayList<>();
		File input = new File("data/day1/input.txt");

		try {
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				leftCol.add(scanner.nextInt());
				rightCol.add(scanner.nextInt());
			}

			scanner.close();

			leftCol.sort(null);
			rightCol.sort(null);

			System.out.println("Part two: " + partTwo(leftCol, rightCol));
			System.out.println("Part one: " + partOne(leftCol, rightCol));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int partOne(List<Integer> colx, List<Integer> coly) {
		int distance = 0;

		for (int i : colx) {
			distance += Math.abs(i - coly.removeFirst());
		}
		return distance;
	}

	public static int partTwo(List<Integer> colx, List<Integer> coly) {
		int occurences = 0;
		int sum = 0;

		for (int i : colx) {
			for (int j : coly) {
				if (i == j) {
					occurences++;
				}
			}
			sum += i * occurences;
			occurences = 0;
		}

		return sum;
	}

}
