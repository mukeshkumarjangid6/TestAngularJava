package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class StringOperation {
	String[] text = {
			"All over the world, leading companies and brands place their trust in Censhare in integrating and automating their communication.",
			"Our customer and project portfolio encompasses virtually all sectors and company sizes.",
			"These activities are driven and advanced by more than 270 employees across the world, with subsidiaries in Germany, Switzerland, UK, France, USA, the Netherlands, Sweden and India.",
			"We are working with highly motivated, competent colleagues coming from more than 30 different nations using cutting-edge technologies across cultures." };

	Map<String, String> countryCode = new HashMap<>();

	public void StringOperation() {
		countryCode.put("Germany", "DE");
		countryCode.put("Switzerland", "CH");
		countryCode.put("UK", "UK");
		countryCode.put("France", "FR");
		countryCode.put("USA", "US");
		countryCode.put("Netherlands", "NL");
		countryCode.put("Sweden", "SE");
		countryCode.put("India", "IN");
	}

	public void reverseString() {
		for (int k = 0; k < text.length; k++) {
			String words[] = text[k].split("\\s");
			String reversedString = "";

			// Reverse each word's position
			for (int i = 0; i < words.length; i++) {
				if (i == words.length - 1)
					reversedString = words[i] + reversedString;
				else
					reversedString = " " + words[i] + reversedString;
			}

			// Displaying the string after reverse
			System.out.print(reversedString);
			System.out.println();
			// text[k] = reversedString;
		}
	}

	public void replaceCountryCode() {
		for (Map.Entry<String, String> entry : countryCode.entrySet()) {
			text[2] = text[2].replace(entry.getKey(), entry.getValue());
		}
	}

	public void swapLines() {
		String swapLine;
		swapLine = text[2];
		text[2] = text[3];
		text[3] = swapLine;
	}

	public void maxOccureWord() {
		String text1 = String.join(". ", text[0], text[1], text[2], text[3]);
		text1 = text1.replace(".", " ");
		String[] occureWord = text1.split(" ");

		List<String> list = Arrays.asList(occureWord);
		Map<String, Integer> counts = list.parallelStream()
				.collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum));
		int maxValue = Collections.max(counts.values());
		for (Entry<String, Integer> entry : counts.entrySet()) { // Iterate through HashMap
			if (entry.getValue() == maxValue) {
				System.out.println(entry.getKey() + " " + maxValue); // Print the key with max value
			}
		}

	}

	public void display() {
		replaceCountryCode();
		swapLines();
		reverseString();

		maxOccureWord();
	}
}