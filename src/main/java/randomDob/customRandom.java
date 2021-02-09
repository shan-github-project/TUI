package randomDob;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

	public class customRandom {
	

	    public static LocalDate Getdate() {
	        int hundredYears = 100 * 365;
	        return LocalDate.ofEpochDay(ThreadLocalRandom
	          .current().nextInt(-hundredYears, hundredYears));
	    }
	    
	    public static LocalDate Getyear() {
	    	int startYear=1990;
			int endYear=2020;
	        return LocalDate.ofEpochDay(ThreadLocalRandom
	          .current().nextInt(-startYear, endYear));
	    }
	
	    public static int Gettele(int start,int end) {
	    	int randomTele = 0;
	    	for (int i=0; i<10; i++){
	    randomTele = ThreadLocalRandom
	                .current()
	                .nextInt(start,end + 1);
					
	    	}
	         return randomTele;
	    }
	    
	    /*//"generating random number in range" + " ( 1- 10) using ThreadLocalRandom")
	    for (int i = 0; i < 10; i++)
	    { 
	    	int randomBetweenOneTo100 = ThreadLocalRandom .current() .nextInt(1,10 + 1); 
	    	System.out.print(randomBetweenOneTo100 + " "); 
	    } */
	

	    
	
}
	
	
	

