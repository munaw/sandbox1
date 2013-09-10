package recurse;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
	static List<String> parentheses(int n){
		List<String> retlist = new ArrayList<String>();
		if ( n < 1) {
			// ADD NOTHING
		} else if ( n == 1 ){
			retlist.add("()");
		} else {
			List<String> paren = parentheses(n-1);
			/*
			 () -> ()(), (())
			 ()() -> ()()(), (())(), ()(())
			 */
			for (String p: paren){
				String [] parts = p.split("\\)\\(");
				for (int i = 0; i < parts.length-1; i++) {
					parts[i] = parts[i] + ")";
				}
				for (int i = 1; i < parts.length; i++) {
					parts[i] =  "(" + parts[i];
				}
				
				for (int i = 0; i < parts.length; i++) {
					String tmp =  "(" + parts[i] + ")";
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < i; j++) {
						sb.append(parts[j]);
					}
					sb.append(tmp);
					for (int j = i+1; j < parts.length; j++) {
						sb.append(parts[j]);
					}
					if ( ! retlist.contains(sb.toString())) { // cost?
						retlist.add(sb.toString());
					}
				}
				String tmp = p + "()";
				if ( ! retlist.contains(tmp)) {
					retlist.add(tmp);
				}
			}
		}
		return retlist;
	}
	public static void main(String[] args) {
		List<String> combs = parentheses(12);
		for (String s: combs){
			System.out.println( s );
		}
		System.out.println(combs.size());
	}
}
