package stack;
import java.util.*;
public class DaoTu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        while(t-->0){
            String s = in.nextLine();
            daotu(s);
        }
    }
    public static void daotu(String s){
        Stack<Character> st = new Stack<>();
        Scanner sc = new Scanner(s);
        while(sc.hasNext()){
            String word = sc.next();
            for(int i = 0; i < word.length(); i++){
                st.push(word.charAt(i));
            }
            while(!st.empty()){
                System.out.print(st.peek());
                st.pop();
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}

