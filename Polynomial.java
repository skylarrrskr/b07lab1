public class Polynomial{
      double[]  coefficients ;

       public Polynomial(){
      coefficients= new double[1];
    }

     public Polynomial(double[] incoefficients){
         coefficients = new double[incoefficients.length];
         for(int i=0;i<coefficients.length;i++){
         // incoefficients[i] = coefficients[i];

           coefficients[i] = incoefficients[i];

                } 
    }

    public   Polynomial add( Polynomial  inPolynomial){
          //Polynomial outPolynomial = new Polynomial ();
          double [] newcoefficient;
          if(inPolynomial.coefficients.length>=coefficients.length){
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
          }
               Polynomial newpolynomial = new Polynomial(newcoefficient);
             
                return  newpolynomial ;
     }

     public   double evaluate(double x ){
       double result = 0.0;
       for(int i=0;i<coefficients.length;i++){
       double d = Double.valueOf(i);
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

    }