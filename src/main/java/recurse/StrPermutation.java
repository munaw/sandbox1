package recurse;

import java.util.ArrayList;
import java.util.List;

public class StrPermutation {

	static List<String> permutations(String str) {
		List<String> retlist = new ArrayList<String>();
		if (str.length() <= 1) {
			retlist.add(str);
			return retlist;
		} else {
			/*
			 * abc a bc bc -> b c -> bc, cb a (bc, cb) abc bac bca ...
			 */
			String s1 = str.substring(0, 1);
			String s2 = str.substring(1, str.length());
			List<String> inperms = permutations(s2);
			for (String p : inperms) {
				for (int i = 0; i <= p.length(); i++) {
					String tmp = p.substring(0, i) + s1
							+ p.substring(i, p.length());
					retlist.add(tmp);
				}
			}
		}
		return retlist;
	}

	public static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	/* Suggested soln */
	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> permutations = new ArrayList<String>();
		if (s == null) { // error case
			return null;
		} else if (s.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}

		char first = s.charAt(0); // get the first character
		String remainder = s.substring(1); // remove the first character
		ArrayList<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				// put 'first' at all possible positions in the word
				permutations.add(insertCharAt(word, first, j));
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		List<String> ret = permutations("abcde");
		System.out.println(ret);
		System.out.println(ret.size());
	}
}
