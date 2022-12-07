import java.util.Scanner;

public class DataCenter{

public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.close();

    double sqrt = Math.sqrt(n);

    if(Math.ceil(sqrt)==Math.floor(sqrt))
        System.out.println(4*(int)sqrt);
    else{

        int a = (int)sqrt;
        int min = Integer.MAX_VALUE;

        for(int i=1;i<=a;i++){
            if(n%i==0){
                min = Math.min(min, (2*i+2*(n/i)));
            }
        }
        System.out.println(min==Integer.MAX_VALUE?(n*2+2):min);
    }

}

}