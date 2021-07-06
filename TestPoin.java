class Point{
	double x,y,z;
	
	Point(double _x, double _y, double _z){
		x = _x;
		y = _y;
		z = _z;
		
	}
	void setX (double _x){
		x = _x;
	}
	
	void setY (double _y){
		y = _y;
	}
	
	void setZ (double _z){
		z = _z;
	}
	
	double getDistance(Point p){
		return(x - p.x)*(x - p.x)+(y - p.y)*(y - p.y)+(z - p.z)*(z - p.z);
		
	}
}

public class TestPoin{
	public static void main(String[] args){
		 Point p = new Point(2.0,4.0,5.0);
		 Point p1 = new Point(1.0,1.0,1.0);
		 System.out.println(p.getDistance(p1));
		 
		 p.setX(5.0);
		 System.out.println(p.getDistance(new Point(1.0,1.0,1.0)));
		 
		 p.setY(3.0);
		 System.out.println(p.getDistance(new Point(2.0,2.0,2.0)));
		 
		 p.setZ(8.0);
		 System.out.println(p.getDistance(new Point(3.0,3.0,3.0)));
	} 
	
}