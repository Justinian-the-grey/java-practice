package dynamic_programming.fibonacci;

public class FibonacciSolver {

    private final int MAX = 10000;
    private long[] array = new long[MAX];

    private long simpleBruteForce(int num) {
        if (num == 1) return 1;
        if (num == 0) return 0;
        else return (simpleBruteForce(num - 1) + simpleBruteForce(num - 2));
    }

    private long dynamically(int num) {
        if (num == 1) return 1;
        if (num == 0) return 0;

        if (array[num] != 0) return array[num];
        else {
            array[num] = dynamically(num - 1) + dynamically(num - 2);
            return array[num];
        }
    }

    public void compareMethods(int num) {
        System.out.println("Starting brute force recursive method:");
        long startBrut = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            System.out.print(simpleBruteForce(i) + ", ");
        }

        System.out.println("\nFor the simple recursion method it took " +
                (System.currentTimeMillis() - startBrut) +
                "ms");

        System.out.println("\nStarting dynamic recursive method:");
        long startDynamic = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            System.out.print(dynamically(i) + ", ");
        }

        System.out.println("\nFor the dynamic recursion method it took " +
                (System.currentTimeMillis() - startDynamic) +
                "ms");
    }
}
