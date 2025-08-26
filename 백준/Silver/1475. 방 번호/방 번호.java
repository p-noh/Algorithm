import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String num = br.readLine();
        
        int[] nums = new int[10];
        for(int i = 0; i < num.length(); i++){
            nums[num.charAt(i) - '0']++;
        }
        int tmp = nums[6] + nums[9];
        nums[6] = tmp % 2 == 0? tmp/2 : tmp/2 + 1;
        nums[9] = nums[6];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){max = nums[i];}
        }
        System.out.println(max);
    }
}