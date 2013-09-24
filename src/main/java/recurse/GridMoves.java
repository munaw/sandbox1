package recurse;

import java.awt.Point;
import java.util.ArrayList;

public class GridMoves {
	static boolean debug = false;
	
	public static void getPaths(int x, int y, ArrayList<Point> current_path) {
		if ( debug ) {
			System.out.println(" IN: x: " + x + " y: " + y + " curpath: " + current_path);
		}
		Point p = new Point(x, y);
		current_path.add(p);
		if (0 == x && 0 == y){
			System.out.println(current_path);
		} else {
			if (x >= 1) { // Try right
				getPaths(x - 1, y, current_path); 
			}
			if (y >= 1) { // Try down
				getPaths(x, y - 1, current_path);
			}
		}
		current_path.remove(p);
		if ( debug ) {
			System.out.println("OUT: x: " + x + " y: " + y + " curpath: " + current_path);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Point> current_path = new ArrayList<Point>();
		getPaths(2, 1, current_path);
	}
}
