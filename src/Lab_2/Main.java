package Lab_2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String str;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\Lab_2\\Text.txt"))){
            while((str = bufferedReader.readLine())!=null){
                String res = "";
                for(int i = 0;i < str.length()-1;++i){
                    int j=i+1;
                    if(str.charAt(i)==str.charAt(j)){
                        while(j<str.length() && str.charAt(j)==str.charAt(i)){++j;}
                        if((j-i)>res.length()){
                            res = str.substring(i,j);
                        }
                        i = j;
                    }

                }
                System.out.println(res);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
