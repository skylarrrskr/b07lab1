import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class Driver {
public static void main(String [] args) throws FileNotFoundException  {
	try {
		File file=new File("polynomial.txt");
		Scanner sc = new Scanner (file);
		System.out.println(sc.nextLine());
		sc.close();
		}
		catch(Exception e) {
			System.out.println(" catch the expectation");
		}
		finally {
			System.out.println(" solve the problem");
		}
	   
	  Polynomial p = new Polynomial();     	   
	  System.out.println(p.evaluate(3)); 
	  

	  File file=new File("polynomial.txt");
	   Polynomial p1 = new Polynomial(file);
	 double[] c1 = {-8,1};
	 int [] e1 = {0,1}; 


	 Polynomial p5 = new Polynomial(c1,e1);	   

	   
	  double [] c2 = {6,-2,-9}; 
	  int [] e2 = {0,1,3}; 
	  Polynomial p2 = new Polynomial(c2,e2);
	
	
	
	
//Polynomial p = new Polynomial();
//System.out.println(p.evaluate(3));
//double [] c1 = {6,0,0,5};
//int [] c11= {0,1,2,3};
//Polynomial p1 = new Polynomial(c1,c11);
//double [] c2 = {0,-2,0,0,-9};
//int [] c22= {0,1,2,3};
//Polynomial p2 = new Polynomial(c2, c22);
	  Polynomial s = p1.add(p2);
	  System.out.println("s(0.1) = " + s.evaluate(0.1)); 
	   if(s.hasRoot(1)) {
	    System.out.println("1 is a root of s"); 
	   }
	   else {
	    System.out.println("1 is not a root of s"); 
	   }

	   Polynomial sss = p1.multiply(p5); 
	   try {
		//s.saveToFile("polynomial2.txt");
		sss.saveToFile("polynomial2.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      /* String str = new String("-Welcome-to-Runoob");

       System.out.println("- return character values :" );
       for (String retval: str.split("-")){
           System.out.println(retval);
       }*/
	  


}
}


