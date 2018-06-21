
package mynumbersystem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yash
 */


public class TheYashCode {
    static{
        System.out.println("Enter Base of Number System");
    }
    static int base=new java.util.Scanner(System.in).nextInt();
    
    static int yashToDec(String str){
        int ans=0;
        for(int i=str.length()-1,j=0;i>=0;i--,j++) {
            ans += Math.pow(base,j)*((int)str.charAt(i) - 'a' );
        }
        return ans;
    }
    
    
    static int digitCount(int x) {
        int count=0;
       while(x>0) {
           count++;
           x/=10;
       } 
       return count;
    }
    
    static String appendA(String str){
        if(str.length()<base){
         String aays = "";
         for(int i=0;i<base-str.length();i++){
             aays += "a";
         }
         return aays+str;
        }
        
        else return str;
    }
    
    static boolean charAreDistinct(String x) {
        boolean ans = true;
        
        Map< Character , Integer > myMap = new HashMap< Character , Integer >();
          
        for(int i=0;i<x.length();i++) {
            
            if(myMap.containsKey(x.charAt(i))){
                ans = false;
                break;
            }
            
            else {
                myMap.put(x.charAt(i),1);
            }
        }
        
        return ans;
    }
    
    static String decToYash(int num) {
        return numToString(decToYashNum(num));
    }
  
    static String numToString(int arr[]) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            ans.append((char)( arr[i] + 'a' ));
        }
        return ans.toString();
    }
    
    static int[] decToYashNum(int n) {
        
        if(n==0) {
            int ans[] = new int[1];
            ans[0]=0;
            return ans;
        }
        
        else {
            StringBuilder sb = new StringBuilder();

            while(n>0) {
                sb.append(n%base);
                n/=base;
            }
            
            int yash[] = new int[sb.length()]; 
            
            for(int i=0;i<sb.length();i++){
                yash[i]= Character.getNumericValue(sb.charAt(sb.length()-i-1));
            }

            return yash;
            
        }
        
    }
    
    public static void main(String[] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int i=0;
        while(decToYash(i).length() <= base){
            
            if(charAreDistinct(appendA(decToYash(i)))) {
                System.out.println(appendA(decToYash(i)));
            }
            i++;
        }
        
        
    }
    
}
