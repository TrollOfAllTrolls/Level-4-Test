import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class WordFinder {
	String word;
	File file = new File("/Users/league/eclipse-workspace/Level 4 Test/src/words.txt");

	public WordFinder() {
	}

	public void findAnagrams() {
		word = JOptionPane.showInputDialog("What word do you want to find the anagram of?");
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String placement = scan.nextLine();
				if (isEqual(placement, word)) {
					System.out.println("An anagram of " + word + " is " + placement);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean isEqual(String wordOne, String wordTwo) {
		char[] firstArray = wordOne.toCharArray();
		char[] secondArray = wordTwo.toCharArray();

		int count = 0;

		boolean isEqual = false;

		if (wordOne.equals(wordTwo)) {
			isEqual = false;
		} else if (firstArray.length == secondArray.length) {
			for (int i = 0; i < secondArray.length; i++) {
				for (int j = 0; j < secondArray.length; j++) {
					if (firstArray[i] == secondArray[j] && firstArray[i] != ' ') {
						count++;
						firstArray[i] = ' ';
						secondArray[j] = ' ';
					}
				}
			}
			if (count == firstArray.length) {
				isEqual = true;
			}
		}

		return isEqual;
	}
}
