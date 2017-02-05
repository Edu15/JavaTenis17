import java.awt.Color;
import java.awt.Graphics;

public class Box {
	public Point position;
	public int size;
	public boolean hidden;
	
	public Box(int size) {
		position = new Point();
		this.size = size;
		hidden = false;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(Math.round(position.x - size/2), Math.round(position.y - size/2), size, size);
	}
	
	public boolean isInSamePlaceAs(Box o) {
		if (o.position.x == position.x && o.position.y == position.y) 
			return true;
		else 
			return false;
	}
}
