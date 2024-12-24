import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a task:");
        System.out.println("1. Catalan Numbers");
        System.out.println("2. Shortest Path");
        System.out.println("3. Find the sum of the digits in the number n!");


        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            task1();
        } else if (choice == 2) {
            task2();
        } else if (choice == 3) {
            task3();
        } else {
            System.out.println("Invalid choice");
        }

        scanner.close();
    }

    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("N: ");
        int n = scanner.nextInt();
        CatalanNumbers catalanNumbers = new CatalanNumbers(n);

        if (n < 0) {
            System.out.println("Cannot be negative");
        } else {
            System.out.println("For " + n + " = " + catalanNumbers.getRes());
        }

        scanner.close();
    }

    public static void task2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input:\n");
        // Read the number of test cases
        int tests = Integer.parseInt(input.nextLine());
        // List to store the outcomes for all test cases
        List<Integer> outcomes = new ArrayList<>();

        for (int test = 0; test < tests; test++) {
            int citiesCount = Integer.parseInt(input.nextLine());
            // Create a mapping of city names to their indices
            Map<String, Integer> cityMap = new HashMap<>();
            int[][] matrix = new int[citiesCount][citiesCount];
            // Initialize the adjacency matrix with maximum values (representing infinity)
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            for (int i = 0; i < citiesCount; i++) {
                String cityName = input.nextLine();
                cityMap.put(cityName, i);

                int neighborsCount = Integer.parseInt(input.nextLine());
                // Read the neighbors and their distances
                for (int j = 0; j < neighborsCount; j++) {
                    String[] neighborData = input.nextLine().split(" ");
                    int neighbor = Integer.parseInt(neighborData[0]) - 1;
                    int weight = Integer.parseInt(neighborData[1]);
                    matrix[i][neighbor] = weight;
                }
            }

            int queriesCount = Integer.parseInt(input.nextLine());

            for (int query = 0; query < queriesCount; query++) {
                // Read the query (start and end city names)
                String[] queryData = input.nextLine().split(" ");
                String start = queryData[0];
                String end = queryData[1];

                int source = cityMap.get(start);
                int destination = cityMap.get(end);

                int cost = ShortestPathCalculator.findShortestCost(matrix, source, destination);
                if (cost == Integer.MAX_VALUE) {
                    outcomes.add(-1);
                } else {
                    outcomes.add(cost);
                }
            }

            if (test < tests - 1) input.nextLine();
        }

        System.out.println("\nOutput:");
        outcomes.forEach(System.out::println);
    }

    public static void task3() {
        BigInteger fact = BigInteger.ONE;

        Scanner input = new Scanner(System.in);
        System.out.println("Input:\n");
        int num = Integer.parseInt(input.nextLine());

        for (int i = 1; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String factStr = fact.toString();
        int digitSum = 0;

        for (char digit : factStr.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }

        System.out.println(digitSum);
    }

}
