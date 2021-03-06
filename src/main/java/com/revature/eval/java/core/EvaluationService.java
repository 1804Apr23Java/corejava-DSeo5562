package com.revature.eval.java.core;


import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String capitalize = phrase.toUpperCase();
		String[] array = capitalize.split("[ +-]");
		String acronym = "";
		int n = array.length;
		for (int i=0; i < n; i++)
		{
			acronym += array[i].charAt(0);
		}
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideOne == sideThree)
			{
				return true;
			}
			else
			{
				return false;
			}	
			//return false;
		}
		
		public boolean isIsosceles() {
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
			{
				return true;
			}
			else
			{
				return false;
			}	
			//return false;
		}

		public boolean isScalene() {
			if (sideOne == sideTwo || sideOne == sideThree || sideTwo == sideThree)
			{
				return false;
			}
			else
			{
				return true;
			}
			//return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		string = string.toLowerCase();
		//System.out.println(string);
		for (char c: string.toCharArray())
		{
			switch(c)
			{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':
				score++;
				break;
			case 'd':
			case 'g':
				score = score + 2;
				break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				score = score + 3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				score = score + 4;
				break;
			case 'k':
				score = score + 5;
				break;
			case 'j':
			case 'x':
				score = score + 8;
				break;
			case 'q':
			case 'z':
				score = score + 10;
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String array = string.replaceAll("[ +-.)(]", "");
		//String cleanedNumber = "";
		char[] testInvalids = array.toCharArray();
		
		if (array.length() > 10)
		{
			//System.out.println("no");
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < array.length(); i++)
		{
			if (!Character.isDigit(testInvalids[i]))
			{
				throw new IllegalArgumentException();
			}
		}

		//string= string.replace("[ +)(-.]", "");
		//System.out.println(cleanedNumber);
		return array;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		string = string.replaceAll("\\r|\\n", "");
		//System.out.println(string);
		String[] wordSet = string.split("[ \\W]");
		//System.out.println(wordSet);
		Map<String, Integer> mapSet = new HashMap<>();
		Integer wordCount = null;
		for (int i = 0; i < wordSet.length; i++)
		{
			wordCount = mapSet.get(wordSet[i]);
			//if empty, put it in map, set wordCount to 1
			if(mapSet.get(wordSet[i]) == null)
			{
				mapSet.put(wordSet[i], 1);
			}
			//if in map, increase wordCount
			else
			{
				wordCount++;
				mapSet.put(wordSet[i], wordCount);
			}

			
		}
		//System.out.println(mapSet);
		return mapSet;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		/*
		 * Just took Binary search code online and modified to fit
		 * 
		 * https://stackoverflow.com/questions/32895969/create-a-binary-search-function-returning-the-index-of-the-leftmost-occurence-of
		 * https://stackoverflow.com/questions/1774095/how-do-i-search-for-a-string-in-an-array-of-strings-using-binarysearch-or-anothe
		 */
		public int indexOf(T t) {

			int lo = 0;
			int hi = sortedList.size() - 1;
			int checked = Integer.parseInt(t.toString());
		
			while(lo <= hi) {
				int middle = (lo + hi)/2;
				int result = Integer.parseInt(sortedList.get(middle).toString());
				if(result == checked) {
					return middle;
				} else if (result < checked) {
					lo = middle + 1;
				} else if (result > checked) {
					hi = middle - 1;
				}
			}
			return 0;
		}
		
		
		
		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}


	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// Didn't want to completely refactor for sentences.
		String latined = "";
		int stringLength = string.length();
		String[] sentenced = string.split(" ");
		for (int l = 0; l < sentenced.length; l++)
		{
			switch(sentenced[l].charAt(0))
			{
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				latined = sentenced[l] + "ay";
				break;
			default:
				for (int i = 0; i < sentenced[l].length(); i++)
				{
					//Checking for the first consonant break
					if (sentenced[l].charAt(i) == 'a' || sentenced[l].charAt(i) == 'e' || sentenced[l].charAt(i) == 'i' || sentenced[l].charAt(i) == 'o' || sentenced[l].charAt(i) == 'u')
					{
						//adding body to front of string
						for (int j = i; j < stringLength; j++)
						{
							latined = latined + sentenced[l].charAt(j);
						}
						//adding consonants back to end of string
						for (int k = 0; k < i; k++)
						{
							latined = latined + sentenced[l].charAt(k);
						}
						//adding 'ay' to end of string
						latined = latined + "ay";
						//System.out.println(latined);
						//consonant = true;
					break;
					}	
				}
				//latined = latined + " ";
			}

			//break;
		}
		//System.out.println(latined);
		return latined;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		int storage = input;
		int calculatednumber = 0;
		int length = String.valueOf(input).length();
		LinkedList<Integer> list = new LinkedList<Integer>();
		while (input > 0) {
			list.push( input % 10);
			input = input / 10;
			
		}
		
		while (!list.isEmpty()) {
			int x = list.pop();
			calculatednumber = (int) (calculatednumber + java.lang.Math.pow(x, length));

		}
		
		if (storage == calculatednumber)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		int i = 2;
		//System.out.println("Number: " + l);
		List<Long> primeList = new ArrayList<>();
		while (i <= l)
		{
			//System.out.println(i);
			//System.out.println(l);
			if ( l % i == 0)
			{
				primeList.add((long) i);
				l = l / i;
				i = 2;
			}
			else
			{
				i++;
			}
			

		}
		
		//System.out.println("List: " + primeList);
		return primeList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//System.out.println(string);
			String cipheredString = "";
			int stringLength = string.length();
			char c = '\0';
			
			for (int i = 0; i < stringLength; i++)
			{
				
				if (!Character.isLetter(string.charAt(i)))
				{
					c = string.charAt(i);
				}
				else //character
					{
						c =  (char) (string.charAt(i) + key);
						
						if (Character.isUpperCase(string.charAt(i))) //Upper overflow
						{
								c = (char) ((c - 65 ) % 26 + 65);

						}
						else if (Character.isLowerCase(string.charAt(i))) //Lower overflow
						{

								c = (char) ((c - 97 ) % 26 + 97);

						}	
					}
				
				
				cipheredString = cipheredString + c;
			}
			//System.out.println(cipheredString);
			return cipheredString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		//System.out.println("Input: " + i);
		int currentNumberPrime = 1;
		int currentNumber = 3;
		int checkedPrimeNumber = 2;
		if (i == 0)
		{
			//System.out.println("illegal");
			throw new IllegalArgumentException();
		}
		if (i == 1)
		{
			//System.out.println(checkedPrimeNumber);
			return checkedPrimeNumber;
		}
		
		while (currentNumberPrime < i)
		{
			for (int x = 2; x < currentNumber; x++)
			{
				if (!(currentNumber % x == 0) && x == (currentNumber - 1))
				{
					checkedPrimeNumber = currentNumber;
					currentNumberPrime++;
					if (currentNumberPrime == i)
					{
						break;
					}
					x = 2;
					currentNumber++;
					break;
				}
				else if (currentNumber % x == 0)
				{
					currentNumber++;
					break;
				}
			}
			
		}
		//System.out.println("Nth prime: " + checkedPrimeNumber);
		return checkedPrimeNumber;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		static String normal = "abcdefghijklmnopqrstuvwxyz";
		static char[] normalized = normal.toCharArray();
		static String reverse = "zyxwvutsrqponmlkjihgfedcba";
		static char[] reversed = reverse.toCharArray();
		
		public static String encode(String string) {
			//System.out.println(string);
			String cleanedString = string.replaceAll("[ -,.]", "");
			//System.out.println(cleanedString);
			cleanedString = cleanedString.toLowerCase();
			
			for (int i = 5; i < cleanedString.length(); i+=6)
			{
				cleanedString = cleanedString.substring(0, i) + " " + cleanedString.substring(i);
			}
			
			char[] unciphered = cleanedString.toCharArray();
			
			for (int i = 0; i < cleanedString.length(); i++)
			{

				if (Character.isLetter(unciphered[i]))
				{
					//System.out.println(unciphered[i]);
					int test = (unciphered[i] - 97);
					//System.out.println(test);
					int j = 25 - test;
					//System.out.println("j: " + j);
					unciphered[i] = normalized[j];
					//System.out.println("Reverse" + normal[j]);
					//System.out.println(unciphered[i]);
				}
				
			}
			//System.out.println(String.valueOf(unciphered));
			return String.valueOf(unciphered);

		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			//System.out.println(string);
			String cleanedString = string.replaceAll("[ -,.]", "");
			//System.out.println(cleanedString);
			char[] unciphered = cleanedString.toCharArray();
			
			for (int i = 0; i < cleanedString.length(); i++)
			{

				if (Character.isLetter(unciphered[i]))
				{
					//System.out.println(unciphered[i]);
					int test = (unciphered[i] - 97);
					//System.out.println(test);
					int j = 25 - test;
					//System.out.println("j: " + j);
					unciphered[i] = normalized[j];
					//System.out.println("Reverse" + normal[j]);
					//System.out.println(unciphered[i]);
				}
				
			}
			//System.out.println(String.valueOf(unciphered));
			return String.valueOf(unciphered);
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		//System.out.println(string);
		String cleanedString = string.replaceAll("-", "");
		char[] cleanedChar = cleanedString.toCharArray();
		int[] cleanedInt = new int[string.length()];
		int total = 0;
		
		if (!(cleanedString.length() == 10))
		{
			return false;
		}
		
		for (int i = 0; i < 10; i++)
		{
			if (Character.isLetter(cleanedChar[i]) && i < 9)
			{
				//System.out.println("false");
				return false;
			}
			if (i == 9)
			{
				if (cleanedChar[i] == 'X')
				{
					cleanedInt[9] = 10;
					break;
				}
				else if (Character.isLetter(cleanedChar[i]))
				{
					//System.out.println("too false");
					return false;
				}
				else
				{
					cleanedInt[i] = cleanedChar[i] - '0';
				}
			}
			cleanedInt[i] = cleanedChar[i] - '0';
		}
		
		//System.out.println();
		for (int i = 0; i < 10; i++)
		{
			total = total + (cleanedInt[i] * (10-i));
		}
		
		if (total % 11 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
			
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		string = string.toLowerCase().replaceAll("[ ,.-]", "");
		Map<Character, Integer> alphabetMap = new HashMap<>();
		//System.out.println(string);
		char[] insertion = string.toCharArray();
		for (int i = 0; i < string.length(); i++)
		{
			if(!alphabetMap.containsKey(insertion[i]))
			{
			    alphabetMap.put(insertion[i], 1);
			}else
			{
			    alphabetMap.put(insertion[i], alphabetMap.get(insertion[i]) + 1);
			}
		}
		//System.out.println(insertion);
		//System.out.println(alphabetMap.size());
		if (alphabetMap.size() == 26)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {

		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		//System.out.println(i);
		//System.out.println(set);
		int multiples = 1;
		HashSet<Integer> uniqueMultiples = new HashSet<Integer>();
		//Iterator<Integer> sum = uniqueMultiples.iterator();
		int total = 0;
		
		for (int x = 0; x < set.length; x++)
		{
			while (set[x] * multiples < i)
			{
				uniqueMultiples.add(set[x] * multiples);
				multiples++;
			}
			multiples = 1;
		}
		for (Integer s : uniqueMultiples)
		{
			total = total + s;
		}
		//System.out.println(uniqueMultiples);
		//System.out.println(total);
		return total;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String cleanedString = string.replaceAll("[ -]", "");
		//System.out.println(string);
		char[] cleanedChar = cleanedString.toCharArray();
		int sum = 0;
		
		for (int i = 0; i < cleanedString.length(); i++)
		{
			if (Character.isLetter(cleanedChar[i]))
			{
				return false;
			}
		}
		
		int[] cleanedInt = new int[cleanedChar.length];
		for (int i = 0; i < cleanedChar.length; i++)
		{
			cleanedInt[i] = cleanedChar[i] - '0';
		}
		for (int i = 1; i < cleanedString.length(); i++)
		{
			cleanedInt[i] = cleanedInt[i] * 2;
			if (cleanedInt[i] > 10)
			{
				//System.out.println(cleanedInt[i]);
				cleanedInt[i] = cleanedInt[i] - 9;
			}
			i++;
		}
		
		for (int i = 0; i < cleanedString.length(); i++)
		{
			sum = sum + cleanedInt[i];
		}
		if (sum % 10 == 0)
		{
			//System.out.println(sum);
			//System.out.println("nice");
			return true;
		}
		else
		{
			//System.out.println("not nice");
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		string = string.replace("?", "");
		String[] parsed = string.split(" ");
		//String operation = "";
		int first = 0;
		int second = 0;
		int result = 0;
		int continueSearch = 0;
		
		
		for (int i = 0; i < parsed.length; i++)
		{
			if (parsed[i].matches(".*\\d+.*"))
			{
				first = Integer.parseInt(parsed[i]);
				continueSearch = i;
				break;
			}
		}
		
		
		for (int i = continueSearch + 1; i < string.length(); i++)
		{
			if (parsed[i].matches(".*\\d+.*"))
			{
				second = Integer.parseInt(parsed[i]);
				break;
			}
		}
		
		
		for (int i = 0; i < parsed.length; i++)
		{
			switch (parsed[i])
			{
			case "plus": 
				result = first + second;
				break;
			case "minus": 
				result = first - second;
				break;
			case "multiplied": 
				result = first * second;
				break;
			case "divided": 
				result = first / second;
				break;
			}
			
		}
		//System.out.println(result);
		return result;
		
	}

}
