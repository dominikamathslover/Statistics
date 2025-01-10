package PACKAGE_NAME;

import java.util.*;
public class Statistics {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        int sum = 0;

        for(int i =0;i<n;i++){
            numbers[i]= scanner.nextInt();
            sum = sum + numbers[i];
        }
        Arrays.sort(numbers);



        double mean = (double)sum/n;

        double median = 0;

        if(n%2==1){
            median = numbers[(n-1)/2];
        }else{
            median =(double) (numbers[n/2-1]+numbers[n/2])/2;
        }

        double sum2 =0;

        for(int i =0;i<n;i++){
            sum2 = sum2 + Math.pow(numbers[i],2);
        }

        double SD = (double) Math.sqrt(sum2/n - Math.pow(mean,2));

        int count =1;
        int countMax=1;
        int number = numbers[0];
        int mode =numbers[0];

        for(int i =1;i<n;i++){
            if(numbers[i]==number){
                count++;
                if(countMax< count){
                    countMax = count;
                    mode = number;
                }
            }else{
                number = numbers[i];
                count =1;
            }

        }

        double lower =(double) mean - SD/Math.sqrt(n)*1.96 ;
        double upper =(double) mean + SD/Math.sqrt(n)*1.96 ;



        System.out.printf("Mean %.1f\n",mean);
        System.out.printf("Median %.1f\n",median);
        System.out.println("Mode "+mode);
        System.out.printf("SD %.1f\n",SD);
        System.out.printf("Lower %.1f\s",lower);
        System.out.printf("Upper %.1f",upper);


    }
}

