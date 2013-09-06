package recurse;

import java.util.ArrayList;
import java.util.List;

public class Powerset {

	/*
	 {1,2,3}
	 1, {2,3}
	 2,3 -> 2, 3, {2,3}
	 1 x { 2, 3, {2,3}} -> 1, 2, 3, {2,3}, {1,2}, {1,3}, {1,2,3}
	 
	 */
	static List<Object> innerPowerset(List<Object> inset){
		int sz = inset.size();
		if ( sz == 0 || sz == 1 ){
			return inset;
		}
		Object one = inset.remove(0);
		List<?> pset = innerPowerset(inset);
		List<Object> retset = new ArrayList<Object>();
		
		retset.add(one);
		retset.addAll(pset);
		
		for(Object o: pset){
			List<Object> tmpset = new ArrayList<Object>();
			tmpset.add(one);
			if ( o instanceof List ){
				tmpset.addAll((List<Object>)o);
			} else {
				tmpset.add(o);
			}
			retset.add(tmpset);
		}
		return retset;
	}
	static List<Object> powerset(List<Object> inset){
		List<Object> tmpset = innerPowerset(inset);
		tmpset.add(new ArrayList<Object>());
		return tmpset;
	}
	
	public static void main(String[] args) {
		List<Object> tmpset = new ArrayList<Object>();
		tmpset.add(new Integer(1));
		tmpset.add(new Integer(2));
		tmpset.add(new Integer(3));
		tmpset.add(new Integer(4));
		tmpset.add(new Integer(5));
		List<?> pset = powerset(tmpset);
		System.out.println(pset);
		System.out.println("Size: " + pset.size());
	}
}
