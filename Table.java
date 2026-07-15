import java.util.Scanner;
import java.util.Random;

public class Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter array size (for PxP array):");
            String s = sc.nextLine().trim();
            try {
                n = Integer.parseInt(s);
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (Eg: not 'foo').");
            }
        }

        int[][] t = new int[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = (r.nextInt(8) + 1) * 2; 
            }
        }

        System.out.println("Generated 2D array:");
        drawTable(t, -1);

        int h = 0;
        while (true) {
            System.out.print("Enter a number to highlight (even number 2-16):");
            String s = sc.nextLine().trim();
            try {
                h = Integer.parseInt(s);
                if (h >= 2 && h <= 16 && h % 2 == 0) {
                    break;
                } else {
                    System.out.println("Out of range or not an even number. Please enter an even number between 2 and 16.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (Eg: not 'foo').");
            }
        }

        System.out.println("Array with " + h + " highlighted:");
        drawTable(t, h);

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (t[i][j] == h) {
                    c++;
                }
            }
        }
        System.out.println("Number " + h + " appeared " + c + " time(s)");
        
        sc.close();
    }

    public static void drawTable(int[][] t, int h) {
        int n = t.length;
        
        System.out.print("    ");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %02d  ", i);
        }
        System.out.println();

        printSeparator(n);

        for (int i = 0; i < n; i++) {
            System.out.printf("%02d |", i);
            for (int j = 0; j < n; j++) {
                int v = t[i][j];
                if (v == h) {
                    System.out.printf("[%02d]|", v);
                } else {
                    System.out.printf(" %2d |", v);
                }
            }
            System.out.println();
            printSeparator(n);
        }
    }

    private static void printSeparator(int n) {
        System.out.print("   +");
        for (int i = 0; i < n; i++) {
            System.out.print("----+");
        }
        System.out.println();
    }
}
