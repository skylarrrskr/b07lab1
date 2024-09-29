
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class Polynomial{
      double[]  coefficients ;
      int[]  exponents;

      public Polynomial(){
      coefficients= new double[1];
      exponents = new int[1];
     // z[0]=0.0;
      //coeffecients= z;


    }
     public Polynomial(double[] incoefficients , int[] inexponents){
         coefficients = new double[incoefficients.length];
         exponents = new int[inexponents.length];
         for(int i=0;i<coefficients.length;i++){
           coefficients[i] = incoefficients[i];
                } 
           for(int j=0;j<exponents.length;j++){
           exponents[j] = inexponents[j];
                } 

    }
     
     
 
     /*public Polynomial(File file) throws IOException {
 		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line =br.readLine();
  
			ArrayList<String> polynomial_items = parsingItems(line);
				int items_num = polynomial_items.size();
			      
			this.coefficients = new double[items_num];
			this.exponents = new int[items_num];
			
			int idx = 0;
  
    for(String item: polynomial_items){
			 String[] params = item.split("[a-z]", -1);
			 
			 this.coefficients[idx] = Double.parseDouble(params[0]);
			 this.exponents[idx] = params.length==1 ? 0 : (params[1].length()==0 ? 1 : Integer.parseInt(params[1]));
			 
			 idx ++;
    }
		} //catch (NumberFormatException e) {
			//e.printStackTrace();
	//	}
	}*/
     public Polynomial(File file) throws FileNotFoundException  {
    	 Scanner input = new Scanner (file);
 		 String line =input.nextLine();
 		 input.close();
 		 String modify_line = line.replace("-", "+-");
 		// int count = modify_line.length() - modify_line.replace("+", "").length();
 		 String[] split1_line = modify_line.split("\\+");
 		 int valid_items =0;
 		 for(int i =0;i< split1_line.length;i++ ) {
 			 if( split1_line[i].length() == 0){
 				 continue;
 		 }
 			valid_items++;
 	       }
 		
 		this.coefficients= new double[valid_items];
 		 this.exponents =new int[valid_items];
 	     int index =0;
 		for(int i=0;i<split1_line.length;i++) {
 			 System.out.println(split1_line[i]);
 			if( split1_line[i].length() == 0){
 	 	    	  continue;
 	 	       }
 			String[] params = split1_line[i].split("x");
 	        System.out.println(params[0]);
 	    if( params[0].length()>0){
 	    	if( params[0].length()==1 && params[0].compareTo("-") == 0){
			this.coefficients[index] = -1;
			}
 	    	else {
 	    		this.coefficients[index] = Double.parseDouble(params[0]);
 	    	}
 	    }
 	    else {
 	    	this.coefficients[index] = 1;
 	    }
 	     if( params.length >=2){
 	    	 this.exponents[index] = Integer.parseInt(params[1]);
 			}
			 //this.exponents[idx] = params.length==1 ? 0 : (params[1].length()==0 ? 1 : Integer.parseInt(params[1]));
 	     else if( split1_line[index].contains("x")==true ) {
				this.exponents[index] = 1;
			}
			else{
			 this.exponents[index] = 0;
			}
			index ++;
			}
 		}
 	
 		
   
 /*private ArrayList<String> parsingItems(String line){
     ArrayList<String> items = new ArrayList<String>();
     
     String rule = "(?<item>\\-?\\d+(\\.\\d+)?(\\w\\d*)?)";
     Pattern pattern = Pattern.compile(rule);
     Matcher matcher = pattern.matcher(line);
     
     while(matcher.find()) {
     	String item_str = matcher.group("item");
     	items.add(item_str);
     }
     
     return items;
 }*/
	

    public   Polynomial add( Polynomial  inPolynomial){
          //Polynomial outPolynomial = new Polynomial ();
          double [] newcoefficient;
          int [] newexponent;
          int repeatnum = 0 ;
          int len_ex = 0;
          ArrayList<Integer> list = new ArrayList<Integer>();
          for(int i= 0; i<inPolynomial.exponents.length;i++ ){
        	  for(int j= 0; j<exponents.length;j++ ){
              if(inPolynomial.exponents[i]== exponents[j]){
            	 repeatnum++ ;
            	 }
              }
          }
          len_ex = inPolynomial.exponents.length + exponents.length - repeatnum;
          newexponent = new int[len_ex];
          newcoefficient = new double[len_ex];
          //for(int i= 0; i<inPolynomial.exponents.length;i++ ){
        	//  for(int j= 0; j<exponents.length;j++ ){
            //  if(inPolynomial.exponents[i]== exponents[i]){
            	// repeatnum++ ;
            	// }
              //}
        //  }
          for(int i=0;i<inPolynomial.exponents.length;i++ ) {
  			list.add(inPolynomial.exponents[i]);			
  		}
  		for(int i=0;i<exponents.length;i++ ) {
  			if(list.contains(exponents[i])==false) {
  				list.add(exponents[i]);
  			}
  		}	
  		 Collections.sort(list);
         
 		for(int i=0;i<list.size();i++) {
 			newexponent[i] = list.get(i);
 		}
 		
 		for(int i=0;i<exponents.length;i++) {
 			for(int j=0;j<newexponent.length;j++) {
 				if(exponents[i]==newexponent[j]) {
 					newcoefficient[j] = coefficients[i];					
 				}
 			}
 		}
 		for(int i=0;i<inPolynomial.exponents.length;i++) {
 			for(int j=0;j<newexponent.length;j++) {
 				if(inPolynomial.exponents[i]==newexponent[j]) {
 					newcoefficient[j] += inPolynomial.coefficients[i];					
 				}
 			}
 		}

          
         
      /*  if(inPolynomial.coefficients.length>=coefficients.length){
          newcoefficient = new double[inPolynomial.coefficients.length];
         for(int i= 0; i<inPolynomial.coefficients.length;i++ ){
         newcoefficient [i]= inPolynomial.coefficients[i] ;
         }

          for(int i= 0; i<coefficients.length;i++ ){
         newcoefficient [i]= newcoefficient[i] + coefficients[i];
          }
          }
          else{
           newcoefficient = new double[coefficients.length];
           for(int i= 0; i<coefficients.length;i++ ){
         newcoefficient [i]= coefficients[i];
       
          }
          for(int i= 0; i<inPolynomial.coefficients.length;i++ ){
         newcoefficient[i]= inPolynomial.coefficients[i]+ newcoefficient[i];
          }
          }*/

              Polynomial newpolynomial = new Polynomial(newcoefficient, newexponent);
             
                return  newpolynomial ;
     }




     public   double evaluate(double x ){
       double result = 0.0;
       for(int i=0;i<coefficients.length;i++){
       double d = Double.valueOf(exponents[i]);
       result = result + coefficients[i]*Math.pow(x, d);
        } 
       return result;
       
     }

    public  boolean   hasRoot(double root){
      if(evaluate(root)==0){
         return true;
         }
          return false;
     }

public Polynomial multiply(Polynomial inPolynomial) {
	Polynomial result = new Polynomial();
	for(int i=0;i<exponents.length;i++) {
		
		int[] new_exponents = new int[inPolynomial.exponents.length];
		double[] new_coefficients = new double[inPolynomial.exponents.length];
	
		for(int j=0;j<inPolynomial.exponents.length;j++) {
			new_exponents[j] = exponents[i]+inPolynomial.exponents[j];
			new_coefficients[j] = coefficients[i]*inPolynomial.coefficients[j];
		}
		Polynomial single = new Polynomial(new_coefficients,new_exponents);
		
		result = result.add(single);
	}

	return result;
}

public void saveToFile(String file)throws IOException{
    FileWriter writer = new FileWriter(file);
    writer.write(this.toString());
    writer.close();
}

public String toString(){
    String exp = "";
    for(int i=0; i<exponents.length; i++){
        exp += (i>0 && coefficients[i]>0 ? "+" : "") + coefficients[i];
        if(exponents[i]!=0) exp += "x" + (exponents[i]>1 ? exponents[i] : "");
    }
    return exp;
}
    

}
