import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        int value = 1;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '(') {
                stack.push('(');
                value *= 2;
            }
            else if(line.charAt(i) == '[') {
                stack.push('[');
                value *= 3;
            }
            else if(line.charAt(i) == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                else if(line.charAt(i - 1) == '(') {
                    answer += value;
                }
                stack.pop();
                value /= 2;
            }
            else if(line.charAt(i) == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                else if(line.charAt(i - 1) == '[') {
                    answer += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        System.out.println(stack.isEmpty() ? answer : 0);
    }
}
