public class Other {
    public static void main(String[] args) {

        // Declaration and Initialization
        int[][] matrix = new int[3][3];

        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // Accessing Elements
        int value = matrix[1][2]; // Accesses the element in the second row and third column (value is 6)

        // Iterating Over a 2D Array
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println(); // Move to the next row
        }

        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == j) {
                    // Perform some action for diagonal elements
                    System.out.println(i + j);
                }
            }
        }

    }
}
