import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n1 = sc.nextLong();
        long n2 = sc.nextLong();

        long min = Math.min(n1, n2);
        long max = Math.max(n1, n2);

        if (min == max) {
            System.out.println(0);
        } else {
            System.out.println(max - min - 1);
            for (long i = min + 1; i < max; i++) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
