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
	
	/** Ref soln **/
	
	    public static void printPar(int l, int r, char[] str, int count) {
	        System.out.format(" **IN** l: %d r: %d count: %d str: %s\n", l, r, count, new String(str, 0, count));
	        
	        if (l < 0 || r < l) {
	            System.out.println("discard -> " + new String(str, 0, count));
	            return; // invalid state
	        }
	        if (l == 0 && r == 0) {
	            System.out.println(str); // found one, so print it
	        } else {
	
	            if (l > 0) { // try a left paren, if there are some available
	                str[count] = '(';
	                printPar(l - 1, r, str, count + 1);
	            }
	
	            if (r > l) { // try a right paren, if there’s a matching left
	                str[count] = ')';
	                printPar(l, r - 1, str, count + 1);
	            }
	
	        }
	        System.out.format("**OUT** l: %d r: %d count: %d str: %s\n", l, r, count, new String(str, 0, count));
	    }

	    public static void printPar(int count) {
	
	        char[] str = new char[count * 2];
	
	        printPar(count, count, str, 0);
	    }
    
	/** end Ref soln **/
	
	public static void main(String[] args) {
		List<String> combs = parentheses(12);
		for (String s: combs){
			System.out.println( s );
		}
		System.out.println(combs.size());
	}
}
