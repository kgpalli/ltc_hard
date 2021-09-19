


public class Practice {





    public static void main(String[]args){

        int primes = 20;

        for(int i=2;i<primes;i++){
            boolean isPrime=true;
            for(int j=2;j<i;j++ ){
                if(i%j==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                System.out.println("Prime number is : " + i);

            }
        }


    }

}
