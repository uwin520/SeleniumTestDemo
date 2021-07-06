class Point{
	private double x;
	private double y;
	Point (double _x, double _y){
		x = _x;
		y = _y;
	}
	public double getX(){return x;}
	public double getY(){return y;}
	public void setX(double i){x = i;}
	public void setY(double i){y = i;}
}

class Circle{
	private Point o;
	private double radius;
	Circle(Point p, double r){
		o = p;
		radius = r;
	}
	Circle(double r){
		o = new Point(0.0,0.0);
		radius = r;
	}
	boolean contains(Point p){
		double x = p.getX() - o.getX();
		double y = p.getY() - o.getY();
		if (x*x + y*y > radius*radius) return false;
		else return true;
	}
	public void getO(){return o;}
	public double getRadius(double r){
		radius = r;
	}
	public double area(){
		return 3.14 * radius *radius;
	}
}


public class TestCircle{
	public static void main(String area[]){
		Circle c1 = new Circle(new Point(1.0,2.0),2.0);
		Circle c2 = new Circle(5.0);
		System.out.println("c1:("+c1.getO().getX()+","+c1.getO().getY()+"),"+c1.getRadius());
		System.out.println("c2:("+c2.getO().getX()+","+c2.getO().getY()+"),"+c2.getRadius());
		System.out.println("c1 area ="+c1.area());
		System.out.println("c2 area ="+c2.area());
		c1.setO(5,6);
		C2.setRadius(9.0);
		System.out.println("c1:("+c1.getO().getX()+",");
		System.out.println("c2:("+c2.getO().getY()+",");
		
		Point p1 = new Point(5.2,6.5);
		System.out.println(c1.contains(p1));
		System.out.println(c2.contains(new Point(10.0,9.0)));
	} 
}