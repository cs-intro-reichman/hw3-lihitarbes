/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String prestr1 = preProcess(str1);
		String prestr2 = preProcess(str2);
		String snew1 = "";
		String snew2 = "";
		for (int i = 0; i < prestr1.length(); i++){
			if((prestr1.charAt(i) >= 'a' && prestr1.charAt(i) <= 'z')){
				snew1 = snew1 + prestr1.charAt(i);
			}
		}
		for (int i = 0; i < prestr2.length(); i++){
			if((prestr2.charAt(i) >= 'a' && prestr2.charAt(i) <= 'z')){
				snew2 = snew2 + prestr2.charAt(i);
			}
		}
		if (snew1.length() != snew2.length()){
			return false;
		}
		int placeHolder = 0;
		for (int i=0; i<snew1.length(); i++){
			boolean isana = false;
			for (int j=0; j < snew2.length(); j++){
				if(snew1.charAt(i) == snew2.charAt(j)){
					isana = true;
					placeHolder = j;
				}
			}
			if (isana == false){
				return false;
			}
			snew2 = snew2.substring(0, placeHolder) + snew2.substring(placeHolder + 1);
		}
		return true;
		}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();	
		String str1 = "";
		for(int i = 0; i < str.length(); i++)	
			if ((str.charAt(i) == 32) || str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
			str1 = str1 + str.charAt(i)	;
			}
		return str1;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newstr = "";
		int strlength = str.length();
		int random = 0;
		for(int i=0; i < strlength; i++){
			random = (int)(str.length() * Math.random());
			newstr += str.charAt(random);
			str = str.substring(0, random) + str.substring(random + 1);
		}
		return newstr;
	}
}
