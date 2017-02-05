import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public Point position;
	public Point velocity;
	public int radius;
	
	public Ball () {
		position = new Point();
		velocity = new Point();
		radius = 10;
	}
	
	public boolean isCloseToBar(Bar o, int tolerance) {
		if ( Math.abs(position.y - o.position.y) < radius + o.height/2 + tolerance) {
			if (position.x > (o.position.x - o.width/2 - tolerance) && position.x < o.position.x + o.width/2 + tolerance) {
				return true;
			}
		}
		return false;
	}
	
	public synchronized boolean isCloseToBox(Box o) {
		if (position.dist(o.position) < radius + o.size/2) {
			return true;
		}
		
		/*if ( Math.abs(position.y - o.position.y) < radius + o.size/2 + tolerance) {
			if (position.x > (o.position.x - o.size/2 - tolerance) && position.x < o.position.x + o.size/2 + tolerance) {
				return true;
			}
		}*/
		return false;
	}
	
	public void bounceOverBox(Box b) {
		
		//	   ----0----
		//    |         |
		//	  3         1
		//	  |         |
		//     ----2----
		
		int boxRadius = b.size/2;
		
		double dist0 = Math.sqrt( Math.pow(position.x - b.position.x , 2) +  Math.pow(position.y - b.position.y - boxRadius,2 )); 
		double dist1 = Math.sqrt( Math.pow(position.x - b.position.x + boxRadius , 2) +  Math.pow(position.y - b.position.y + boxRadius, 2 ));
		double dist2 = Math.sqrt( Math.pow(position.x - b.position.x, 2) +  Math.pow(position.y - b.position.y + boxRadius, 2 ));
		double dist3 = Math.sqrt( Math.pow(position.x - b.position.x - boxRadius , 2) +  Math.pow(position.y - boxRadius - b.size/2, 2 ));
		
		double min = Math.min(dist0, Math.min(dist1, Math.min(dist2, dist3)));
		
		if (min == dist0) {
			velocity.x *= (-1);
		} else if (min == dist1) {
			velocity.y *= (-1);
		} else if (min == dist2) {
			velocity.y *= (-1);
		} else {
			velocity.x *= (-1);
		}
		
	//---
		
	}
		
	
	public void normalizeVelocity() {
		float length = (float) Math.sqrt(velocity.x*velocity.x + velocity.y*velocity.y);
		velocity.x /= length;
		velocity.y /= length;
		if (Math.abs(velocity.y) < 0.2) {
			if (velocity.x > 0)
				velocity.x -= 0.2;
			else
				velocity.x += 0.2;
			
			if (velocity.y > 0)
				velocity.y += 0.2;
			else
				velocity.y -= 0.2;
		}
	}
	 
	public void draw (Graphics g) {
		g.setColor(Color.black);	
		g.drawOval(Math.round(position.x - radius), Math.round(position.y - radius), radius*2, radius*2);
	}
	
	
}




