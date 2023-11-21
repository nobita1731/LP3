import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = scanner.nextInt();

        System.out.print("Enter Second Number: ");
        int b = scanner.nextInt();

        System.out.print("Enter Number: ");
        int n = scanner.nextInt();

        System.out.print(a + " " + b + " ");

        while (n - 2 > 0) {
            int c = a + b;
            a = b;
            b = c;
            System.out.print(c + " ");
            n = n - 1;
        }

        scanner.close();
    }
}
