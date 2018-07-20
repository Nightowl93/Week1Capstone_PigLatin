package co.grandcircus.capstone1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week1CapstonePigLatin {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		String userWord;
		String translatedWord;
		String userResponse;
		boolean keepGoing = false;
		
		System.out.println("Hi there! Today, we will learn Pig Latin!\nAll you have to do is enter an English word and "
				+ "the Pig Latin translation will be shown. \nLet's get started! :)\n");
		
		do {
		System.out.println("Please enter a word: ");
		userWord = scnr.next().trim();
		
		System.out.println("English: " + userWord);
		userWord = userWord.toLowerCase();
		
		translatedWord = pigLatin(userWord);
		System.out.println("Pig Latin: " + translatedWord);
		
		System.out.println("Would you like to learn another word? (y/n)");
		userResponse = scnr.next();
		
		if (userResponse.startsWith("y")) {
			keepGoing = true;
		}
		
		else {
			keepGoing = false;
			System.out.println("Thank you for learning with me! Goodbye! :)");
			System.out.println("ankthay ouyay orfay earninglay ithway emay! oodbyeGay! :)");
		}
		
		}
		while (keepGoing);
		
		scnr.close();
	}

	public static String pigLatin(String english) {
		
		String pigLatin = "";
		String wordEnd;
		String wordStart;
		String consonantsBeforeVowel = "[^aeiou]+";
		String regexVowel = "[aeiou]";
		
		int consonantEnd;
		int consonantStart;
		int vowelStart;
		
				
		Pattern vowels = Pattern.compile(regexVowel);
		Matcher matchVowels = vowels.matcher(english);
		
		Pattern consonants = Pattern.compile(consonantsBeforeVowel);
		Matcher matchConsonants = consonants.matcher(english);
		
		
		if (matchVowels.find()) {
			vowelStart = matchVowels.start();
			
			if (vowelStart == 0) {
				pigLatin = english + "way";
			}
		}
		
		if (matchConsonants.find()) {
			consonantStart = matchConsonants.start();
			consonantEnd = matchConsonants.end();
			
			if (consonantStart == 0) {
			
			wordEnd = english.substring(consonantStart, consonantEnd) + "ay";
			
				if (english.length() > consonantEnd) {
					wordStart = english.substring(consonantEnd);
					pigLatin = wordStart + wordEnd;
				}
				
				else {
					pigLatin = wordEnd;
				}
			}
		}
		
		return pigLatin;
		}
	
}