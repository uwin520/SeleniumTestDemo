public class TestBreak{	
	public static void main(String args[]){
		int stop = 4;
		for (int i=1;i<=10;i++){
			if (i == stop)
			break;
			System.out.println("i="+i);
		}
		int skip = 6;
		for (int i=1; i<=10; i++){
			if (i == skip)
			continue;
			System.out.println("i="+i);
		}
		for (int i=101; i<200; i+=2){
			boolean f = true;
			for (int j = 2; j < i; j++){
				if (i%j == 0){
					f = false;
					break;
				}
			}
			if (!f){continue;}
			System.out.print(""+i);
			
		}
	}
}