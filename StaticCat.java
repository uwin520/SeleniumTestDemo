public class StaticCat{
	private static int sid = 0;
	private String name;
	int id;
	StaticCat(String name){
		this.name = name;
		id = sid++;
	}
	public void info(){
		System.out.println
			("name:"+name+","+"NO."+id);
	}
	public static void main(String arg[]){
		StaticCat.sid = 100;
		StaticCat mimi = new StaticCat("mimi");
		StaticCat pipi = new StaticCat("pipi");
		mimi.info();
		pipi.info();
	}
}