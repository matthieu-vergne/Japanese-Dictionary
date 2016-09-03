package fr.vergne.japdict.util;

import java.util.LinkedList;
import java.util.List;

public class StringUtil {

	/**
	 * 
	 * @param string
	 * @return the ordered list of {@link Character}s contained in the string
	 */
	public static List<Character> split(String string) {
		LinkedList<Character> characters = new LinkedList<>();
		for (char character : string.toCharArray()) {
			characters.add(character);
		}
		return characters;
	}
}
