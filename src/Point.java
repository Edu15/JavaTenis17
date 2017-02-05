
public class Point {
	
	public float x;
	public float y;

	public Point() {
		x = 0;
		y = 0;
		// TODO Auto-generated constructor stub
	}

	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public double dist(Point p) {
		return Math.sqrt( Math.pow(p.x - x, 2) +  Math.pow(p.y - y, 2));
	}


}