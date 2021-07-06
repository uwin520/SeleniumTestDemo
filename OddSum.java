public class OddSum {
    public static void main (String args[]){
		
		long R = 0;
		for (int i = 1;i<=99;i+=2){
			R += i;
		}
		
		System.out.println("R="+R);
	}
}