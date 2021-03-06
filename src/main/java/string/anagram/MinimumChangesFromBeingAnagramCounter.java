package src.main.java.string.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumChangesFromBeingAnagramCounter {

	public static Integer countMinimumChangesForBeingAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) return -1;
		
		Map<Character, Integer> occurencesFirst = new HashMap<Character, Integer>();
		for (char c : str1.toCharArray()) {
			if (occurencesFirst.containsKey(c))
				occurencesFirst.put(c, occurencesFirst.get(c) + 1);
			else
				occurencesFirst.put(c, 1);
		}
		
		
	    Map<Character, Integer> occurencesSecond = new HashMap<Character, Integer>();
		for (char c : str2.toCharArray()) {
			if (occurencesSecond.containsKey(c))
				occurencesSecond.put(c, occurencesSecond.get(c) + 1);
			else
				occurencesSecond.put(c, 1);
		}


		Integer result = 0;

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (char c : alphabet.toCharArray()) {
			Integer occFirst = occurencesFirst.containsKey(c) ? occurencesFirst.get(c) : 0;
			Integer occSecond = occurencesSecond.containsKey(c) ? occurencesSecond.get(c) : 0;
			result = result + Math.abs(occFirst - occSecond);
		}
		
		result = result / 2;
		return result;
	}
	
	public static Integer countMinimumChangesForBeingAnagramWithCountingTheSameChar(String str1, String str2) {
		if (str1.length() != str2.length()) return -1;
		
		Map<Character, Integer> occurences = new HashMap<Character, Integer>();
		for (char c : str1.toCharArray()) {
			if (occurences.containsKey(c))
				occurences.put(c, occurences.get(c) + 1);
			else
				occurences.put(c, 1);
		}
		
		Integer countTheSameChar = 0;
		for (char c : str2.toCharArray()) {
			if (occurences.containsKey(c) && occurences.get(c) != 0) {
				occurences.put(c, occurences.get(c) - 1);
				countTheSameChar = countTheSameChar + 1;
			}
		}

		Integer result = str1.length() - countTheSameChar;
		return result;
	}
	
	public static Integer countMinimumChangesForBeingAnagramWithSingleLoop(String str1, String str2) {
		if (str1.length() != str2.length()) return -1;
		
		int[] occurences = new int[26];
		
		for (int i = 0 ; i < str1.length() ; i = i + 1) {
			occurences[str1.charAt(i) - 'a']++;
			occurences[str2.charAt(i) - 'a']--;
		}
		
		return Arrays.stream(occurences).filter(i -> i > 0).sum();
	}
	
	public static void main(String[] args) {	
		// full testcase: https://www.hackerrank.com/challenges/anagram/problem
	}
	
}
