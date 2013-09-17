package recurse;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

	static List<ArrayList<Object>> powerset(List<Object> inset){
		List<ArrayList<Object>> retSubsets = new ArrayList<ArrayList<Object>>();
		int sz = inset.size();
		if ( sz == 0 ){
			retSubsets.add(new ArrayList<Object>());
			return retSubsets;
		} else {
			Object one = inset.remove(0);
			List<ArrayList<Object>> innerSubsets = powerset(inset);
			
			for(ArrayList<Object> s: innerSubsets){
				ArrayList<Object> tmpSet = new ArrayList<Object>();
				tmpSet.add(one);
				tmpSet.addAll(s);
				
				retSubsets.add(tmpSet);
			}
			
			retSubsets.addAll(innerSubsets);
			
		}
		return retSubsets;
	}


	public static void main(String[] args) {
		List<Object> tmpset = new ArrayList<Object>();
		tmpset.add(new Integer(1));
		tmpset.add(new Integer(2));
		tmpset.add(new Integer(3));
		List<?> pset = powerset(tmpset);
		System.out.println(pset);
		System.out.println("Size: " + pset.size());
	}
}
