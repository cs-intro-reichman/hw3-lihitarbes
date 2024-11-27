// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(-2,-4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(9,2));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(101));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			x1 = minus(x1, -x2);
		}
		for(int i=0; i < x2; i++){
			x1++;
		}
		return x1;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 < 0){
			x1 = plus(x1, -x2);
		} 
		else{

		for( int i = 0; i<x2; i++){
			x1--;
		}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int newx = x1;
		if((x1 == 0) || (x2 == 0)){
			return 0;
		}
		if(x2>0){
		for(int i = 1; i<x2; i++){
			newx = plus(newx, x1);
		}
		}
		else{
			for( int i = 1; i>x2; i--){
				System.out.println(newx);
				newx = minus(newx, x1);
		}
		}
	return newx;
}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if( n == 0){
			return 1;
		}
		 int powx = x;
		for(int i = 1; i < n; i++){
			powx = times(powx, x);
		}
		return powx;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		
		int count = 0;
		int isnegetive = 0;

		if(x1 == 0){
			return 0;
		}
		if (x1 < 0){
			x1 = minus(0, x1);
			isnegetive++;
		}
		if (x2 < 0){
			x2 = minus(0, x2);
			isnegetive++;
		}
		int divx = x1;
		 while (divx > 0){
			divx = minus(divx,x2);	
			count ++;
		 }
		 if(divx < 0){
			count = minus(count ,1);
		 }
		 if (isnegetive == 1){
			return minus(0, count);
		 }
		 return count;
		}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divaction = div(x1, x2);
		int timesaction = times(divaction, x2);
		int minusaction = minus(x1, timesaction);
		return minusaction;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
	int result = 0;
	while (times(result, result) <= x){
		result++;
	}
		return minus(result, 1) ;
	}	  	  
}