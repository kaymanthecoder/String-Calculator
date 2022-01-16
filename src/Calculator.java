import java.util.Scanner;

public class Calculator {
	
	//This is for solving Factorial number
	public static long fact(long num) {
		if(num == 0) {
			return 1;
			}else {
				return num * fact(num - 1);
				}
		}
	
	//This is for solving Prime number
	static long maxPrimeFactors(long prime) {
		long maxPrime = -1;
		
		while(prime%2==0) {
			maxPrime = 2;
			prime >>=1;
		}
		
		for(int i = 3; i <= Math.sqrt(prime); i+=2) {
			while(prime%i==0) {
				maxPrime = i;
				prime=prime/i;
			}
		}
		
		if(prime>2) {
			maxPrime = prime;
		}
		return maxPrime;
	}
	
	//This is for solving Fibonacci number
	public static int fib(int b) {
		// n        0,1 ,2 ,3 ,4 ,5 ,6 ,7 , 8 , 9......
		// Series 0,1 ,1 ,2 ,3 ,5 ,8 ,13 ,21 ,34......
		//nth number = Sum of (n-1)th and (n-2)th numbers
		
		//base case
		if (b <= 1) { //1st 2 numbers of the Series and n remains the same 
			return b;
		}
		//recursive case
		else {
			return fib(b-1)+fib(b-2);//line 3 numbers are used here to get line 4 numbers
		}//I made these "m" instead of "n" like below to show that they aren't the same
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Java String Calculator");
		// I failed to make this program use the math expression that was required. eg +2 3 or +3 6 8 8
		// It kept giving me problems. And i was running out of time, so I had to compromise
		System.out.println("Please enter a maths equation. Use this format(2+3) or (4+5+7-9):");
		Scanner bro = new Scanner(System.in);
		String a = bro.nextLine();
		String b = null;
		String word = null;
		
		boolean doFactorial = a.toLowerCase().contains("factorial");
		if(doFactorial) {
			b = a;
			a = "0";
			// It transfers into b than turns a zero, so that there won't be an error
			
			// It removes all the letters from the string
			b = b.replaceAll("\\D+", "");
			// It converts it into a Long
    		long num = Long.parseLong(b);
    		System.out.println("The factorial of " + b + " number is "  + fact(Long.parseLong(b)));
		}
		boolean doPrime = a.toLowerCase().contains("prime");
		if(doPrime) {
			b = a;
			a = "0";// It transfers into b than turns a zero, so that there won't be an error
			
			// It removes all the letters from the string
			b = b.replaceAll("\\D+", "");
			// It converts it into a Long
			long prime = Long.parseLong(b);
			System.out.println(maxPrimeFactors(prime));
		}
		boolean doFibonacci = a.toLowerCase().contains("fibonacci");
		if(doFibonacci) {
			b = a;
			a = "0";// It transfers into b than turns a zero, so that there won't be an error
			
			// It removes all the letters from the string
			b = b.replaceAll("\\D+", "");
			// It converts it into a Long
			System.out.println(fib(Integer.parseInt(b)));
		}
		
	    String operators[]=a.split("[0-9]+");
	    String operands[]=a.split("[/*+-]");
	    // It starts off with the first number
	    long agregate = Long.parseLong(operands[0]);
	    for(int i=1;i<operands.length;i++){
	        if(operators[i].equals("+")) {
	            agregate += Long.parseLong(operands[i]);
	            //It converts it back into a string after doing the calculations
	            word = Long.toString(agregate);
	            
	          //This prints out the answer
	    	    System.out.println(word);
	        }else if(operators[i].equals("-")) {
	            agregate -= Long.parseLong(operands[i]);
	          //It converts it back into a string after doing the calculations
	            word = Long.toString(agregate);
	            
	          //This prints out the answer
	    	    System.out.println(word);
	        }else if(operators[i].equals("*")) {
	            agregate *= Long.parseLong(operands[i]);
	          //It converts it back into a string after doing the calculations
	            word = Long.toString(agregate);
	            
	          //This prints out the answer
	    	    System.out.println(word);
	        }else if(operators[i].equals("/")) {
	            agregate /= Long.parseLong(operands[i]);
	          //It converts it back into a string after doing the calculations
	            word = Long.toString(agregate);
	            
	          //This prints out the answer
	    	    System.out.println(word);
	        }
	    }
	    System.out.println("This is the final answer!");
	}

}
