import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        whole:
        while(true){
        String str = br.readLine();
        if(str.charAt(0)=='.'){break;}
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }
            else if(str.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    System.out.println("no");
                    continue whole;
                }
                else{stack.pop();}
            }
            else if(str.charAt(i)=='['){
                stack.push('[');
            }
            else if(str.charAt(i)==']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    System.out.println("no");
                    continue whole;
                }
                else{stack.pop();}
            }
        }
        if(!stack.isEmpty()){System.out.println("no");}
        else{System.out.println("yes");}
        }
    }
}