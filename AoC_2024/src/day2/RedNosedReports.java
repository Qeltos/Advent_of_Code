package day2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedNosedReports {

	public static void main(String[] args) {
		File input = new File("data/day2/input.txt");
		List<Integer> list = new ArrayList<>();
		String[] line;
		int safeReports = 0;

		try {
			Scanner scanner = new Scanner(input);

			while (scanner.hasNextLine()) {
				line = scanner.nextLine().split(" ");
				for (String s : line) {
					list.add(Integer.parseInt(s));
				}
				if (reportController(list)) {
					safeReports++;
				} else {
					if (dampener(list)) {
						safeReports++;
					}
				}
				list.clear();
			}

			scanner.close();
			System.out.println(safeReports);

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public static boolean reportController(List<Integer> s) {

		boolean increasing = false;
		boolean decreasing = false;

		for (int i = 0; i < s.size() - 1; i++) {
			int diff = s.get(i) - s.get(i + 1);

			if (diff > 0) {
				decreasing = true;
			}

			if (diff < 0) {
				increasing = true;
			}

			diff = Math.abs(diff);
			if (diff < 1 || diff > 3 || decreasing && increasing) {
				return false;
			}
		}
		return true;
	}

	public static boolean dampener(List<Integer> s) {

		int removedItem;

		for (int i = 0; i < s.size(); i++) {
			removedItem = s.remove(i);

			if (reportController(s)) {
				return true;
			}

			s.add(i, removedItem);
		}

		return false;
	}

}
