package co.grandcircus.capstone1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Week1CapstonePigLatin {

	public static void main(String[] args) {
		
		//Declared variables
		Scanner scnr = new Scanner(System.in);
		String userWord;
		String translatedWord;
		String userResponse;
		boolean keepGoing = false;
		
		//Welcomes users
		System.out.println("Hi there! Today, we will learn Pig Latin!\nAll you have to do is enter an English word and "
				+ "the Pig Latin translation will be shown. \nLet's get started! :)\n");
		
		//Continues the translation loop as long as user wishes
		do {
		
			//Prompts user to enter a word
			System.out.println("Please enter a word: ");
			userWord = scnr.next().trim();
			
			//Prints English word entered by user and makes it lowercase
			System.out.println("English: " + userWord);
			userWord = userWord.toLowerCase();
			
			//Calls pigLatin method and prints translated word
			translatedWord = pigLatin(userWord);
			System.out.println("Pig Latin: " + translatedWord);
			
			//Prompts user to continue or exit
			System.out.println("Would you like to learn another word? (y/n)");
			userResponse = scnr.next();
			
			//Restarts the loop
			if (userResponse.startsWith("y")) {
				keepGoing = true;
			}
			
			//Prints goodbye in pig-latin and english and terminates program
			else {
				keepGoing = false;
				System.out.println("Thank you for learning with me! Goodbye! :)");
				System.out.println("ankthay ouyay orfay earninglay ithway emay! oodbyeGay! :)");
			}
		
		}
		while (keepGoing);
		
		//Closes scanner to prevent memory leaks
		scnr.close();
	}

	//Method to convert word to piglatin
	public static String pigLatin(String english) {
		
		//Declares variables 
		String pigLatin = "";
		String wordEnd;
		String wordStart;
		String consonantsBeforeVowel = "[^aeiou]+";
		String regexVowel = "[aeiou]";
		
		int consonantEnd;
		int consonantStart;
		int vowelStart;
		
		//Creates regular expression pattern and matcher class for vowels and consonants		
		Pattern vowels = Pattern.compile(regexVowel);
		Matcher matchVowels = vowels.matcher(english);
		
		Pattern consonants = Pattern.compile(consonantsBeforeVowel);
		Matcher matchConsonants = consonants.matcher(english);
		
		//When first letter is a vowel, it translates
		if (matchVowels.find()) {
			vowelStart = matchVowels.start();
			
			if (vowelStart == 0) {
				pigLatin = english + "way";
			}
		}
		
		//When word does not start with a vowel, it translates accordingly
		
		//Searches for a consonant or consonant cluster match
		if (matchConsonants.find()) {
			
			//Stores the first and last consonants found
			consonantStart = matchConsonants.start();
			consonantEnd = matchConsonants.end();
			
			if (consonantStart == 0) {
			
			//Reorders word to fit pig latin rules
			wordEnd = english.substring(consonantStart, consonantEnd) + "ay";
			
				//Checks for words that have vowels and handles them accordingly
				if (english.length() > consonantEnd) {
					wordStart = english.substring(consonantEnd);
					pigLatin = wordStart + wordEnd;
				}
				
				//Words that have no vowel are handled accordingly
				else {
					pigLatin = wordEnd;
				}
			}
		}
		
		//Returns translated word
		return pigLatin;
		}
	
}