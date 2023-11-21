import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int nterms = scanner.nextInt();

        if (nterms <= 0) {
            System.out.println("Please Enter a Positive Integer");
        } else {
            System.out.println("Fibonacci Sequence:");
            for (int i = 0; i < nterms; i++) {
                System.out.println(recurFibo(i));
            }
        }

        scanner.close();
    }

    static int recurFibo(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recurFibo(n - 1) + recurFibo(n - 2);
        }
    }
}

