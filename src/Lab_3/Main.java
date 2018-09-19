package Lab_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String num = bufferedReader.readLine();
        if(num==null || num.length()==0){
            System.out.println("Wrong input");
            System.exit(0);
        }
        int n=0;
        try{
            n = Integer.parseInt(num);
        }catch(NumberFormatException e){
            System.out.println("Wrong input");
            System.exit(0);
        }
        if(n<=0){
            System.out.println("Wrong size");
            System.exit(0);
        }
        Random r = new Random();
        int[][] arr = new int[n][n];
        System.out.println("Initial:");
        for(int i = 0;i < n;++i){
            for(int j = 0;j < n;++j){
                arr[i][j] = r.nextInt()%(n+1);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Changed:");
        for(int i = 0;i < n;++i){
            for(int j = i;j < n;++j){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        for(int i = 0;i < n;++i){
            for(int j = 0;j < n;++j){
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
        bufferedReader.close();
    }
}
