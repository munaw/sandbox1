package recurse;

import java.util.ArrayList;
import java.util.List;

public class StrPermutation {

	static List<String> permutations(String str){
		List<String> retlist = new ArrayList<String>();
		if ( str.length() <= 1) {
			retlist.add(str);
			return retlist;
		} else {
			/*
			 abc
			 a bc
			 bc -> b c -> bc, cb
			 a (bc, cb)
			 abc bac bca ... 
			 */
			String s1 = str.substring(0, 1);
			String s2 = str.substring(1, str.length());
			List<String> inperms = permutations(s2);
			for(String p: inperms){
				for (int i = 0; i <= p.length(); i++) {
					String tmp = p.substring(0,i)
							+ s1
							+ p.substring(i, p.length());
					retlist.add(tmp);
				}
			}
		}
		return retlist;
	}
	public static void main(String[] args) {
		List<String> ret = permutations("abcde");
		System.out.println( ret );
		System.out.println( ret.size() );
	}
}
