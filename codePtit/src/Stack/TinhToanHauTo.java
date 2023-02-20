package stack;
import java.util.*;

public class TinhToanHauTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.nextLine();
            System.out.println(tinhGiaTri(s));
        }
    }
    public static long tinhGiaTri(String str){
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<str.length();i++){
            if(str.charAt(i)=='+'||str.charAt(i)=='-'||str.charAt(i)=='*'||str.charAt(i)=='/'||str.charAt(i)=='^'||str.charAt(i)=='%'){
                int a = stack.pop(), b = stack.pop();
                int temp = 0;
                switch(str.charAt(i)) {
                        case '+': temp = b+a; break;
                        case '-': temp = b-a; break;
                        case '*': temp = b*a; break;
                        case '/': temp = b/a; break;
                        case '^': temp = (int)Math.pow(b, a); break;
                        case '%': temp = b%a; break;
                        
                }
                stack.push(temp);
            }else {
                stack.push(Integer.parseInt(str.charAt(i) + ""));
            }
        }
        return stack.peek();
    }
}