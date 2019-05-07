// Java code for adding elements in Set 
/**
https://www.geeksforgeeks.org/set-in-java/
https://beginnersbook.com/2014/08/difference-between-hashset-and-treeset/
*/
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 import java.util.StringTokenizer;
import java.util.*; 
import java.util.Scanner;  // Import the Scanner class
public class SetCalculator 
{ 
	public static void main(String[] args) 
	{ 

    System.out.println("Valid Examples:\n[12,2,3]+[3,44,2]\n[30,4,5]*[7,4,2]\n[3,42,5]-[74,4,2]\nEnter your string");
    Scanner scanner = new Scanner(System.in);  // Create a Scanner object
    String userStringIn = scanner.nextLine();  // Read user input
    String regexString = "\\[\\d{1,2}(,\\d{1,2})*\\](\\+|\\*|\\-)\\[\\d{1,2}(,\\d{1,2})+\\]";
    while(!Pattern.matches(regexString, userStringIn)){
      if(userStringIn.matches("Q")){
        scanner.close();
        System.exit(0);
      } 
      System.out.println("Your input is Invalid: " + userStringIn);
      System.out.println("Type in Q if you are a quiter:");
      System.out.println("Valid Examples:\n[12,2,3]+[3,44,2]\n[30,4,5]*[7,4,2]\n[3,42,5]-[74,4,2]\nEnter your string");
      userStringIn = scanner.nextLine();
    }
    scanner.close();
    System.out.println("User input String is: " + userStringIn);  // Output user input

    int operatorIndex = 0;
    char[] userCharsArray = userStringIn.toCharArray();
    for (int i = 0; i < userCharsArray.length; i ++) {

        char c = userStringIn.toCharArray()[i];
        if(c == '+' || c == '*' || c == '-'){
            operatorIndex = i;
            break;
        }
    }
    
    Set<Integer> a = new TreeSet<Integer>();
    for(int i = 1; i < operatorIndex-1; i ++){
        if(userCharsArray[i] != ','){
            a.add(Integer.parseInt(String.valueOf(userCharsArray[i])));
        }
      
    }
    Set<Integer> b = new TreeSet<Integer>();
    for(int i = operatorIndex + 2; i < userCharsArray.length-1; i ++){
      if(userCharsArray[i] != ','){
            b.add(Integer.parseInt(String.valueOf(userCharsArray[i])));
        }
    }
    
    switch(userCharsArray[operatorIndex]){
        case '+':
            // To find union 
            Set<Integer> union = new TreeSet<Integer>(a); 
            union.addAll(b); 
            System.out.print("Union of the two Set"); 
            System.out.println(union); 
            break;
        case '*':
            // To find intersection 
            Set<Integer> intersection = new TreeSet<Integer>(a); 
            intersection.retainAll(b); 
            System.out.print("Intersection of the two Set"); 
            System.out.println(intersection);
            break;
        case '-':
            // To find the symmetric difference 
            Set<Integer> difference = new TreeSet<Integer>(a); 
            difference.removeAll(b); 
            System.out.print("Difference of the two Set"); 
            System.out.println(difference);  
            break;
            
    }
}
 }