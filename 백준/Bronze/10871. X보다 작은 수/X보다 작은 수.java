import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int[] nums  = new int[n];
        for(int i=0;i<n;i++) {
            nums[i] = input.nextInt();
            if (nums[i]<x){
                System.out.print(nums[i]);
                if (i!=n-1) {
                    System.out.printf(" ");
                }
            }
        }
    }
}