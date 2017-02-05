import java.awt.Color;
import java.awt.Graphics;


public class Bar {
	public Point position;
	public Point velocity;
	public int width;
	public int height;
	
	public Bar (int width) {
		position = new Point();
		velocity = new Point();
		this.width = width;
		height = 15;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(Math.round(position.x - width/2), Math.round(position.y - height/2), width, height);
	}
}
