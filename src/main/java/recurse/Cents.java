package recurse;

import java.util.ArrayList;
import java.util.List;

public class Cents {

	/*
	 * def countChange(money: Int, coins: List[Int]): Int = {
	 * 
	 * def cc(money: Int, coins: List[Int], curCoin: Int, curTotal: Int): Int =
	 * { if ( money <= 0 ) (curTotal+1) else curTotal + coins.filter ( c =>
	 * (money >= c && c >= curCoin) ) .map ( x => cc(money - x, coins, x, 0) )
	 * .fold(0)(_+_) }
	 * 
	 * cc(money, coins.sorted.reverse, -1, 0) }
	 */
	/*
	 * Given an infinite number of quarters (25 cents), dimes (10 cents),
	 * nickels (5 cents) and pennies (1 cent), write code to calculate the
	 * number of ways of representing n cents
	 */
	static final int[] COINS = { 25, 10, 5, 1 };

	static void internChange(int n, int[] current, int curCoin,
			List<int[]> retlist) {

		if (n == 0) {
			retlist.add(current);
		} else {
			if (curCoin < COINS.length) {
				for (int i = 0; i * COINS[curCoin] <= n; i++) {
					int[] curCopy = new int[COINS.length];
					System.arraycopy(current, 0, curCopy, 0, COINS.length);
					curCopy[curCoin] += i;
					internChange(n - i * COINS[curCoin], curCopy, curCoin + 1,
							retlist);
				}
			}
		}
	}

	static List<int[]> change(int n) {
		List<int[]> retlist = new ArrayList<int[]>();
		int[] current = new int[COINS.length];
		internChange(n, current, 0, retlist);
		// todo filter duplicates
		return retlist;
	}

	public static void main(String[] args) {
		List<int[]> out = change(35);
		for (int[] c : out) {
			System.out.println("25x" + c[0] + " 10x" + c[1] + " 5x" + c[2]
					+ " 1x" + c[3]);
		}
		System.out.println(out.size());
	}
}
