import java.util.Scanner;

public class SquareMatrixMultiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] matrixA = new int[size][size];
        int[][] matrixB = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrixA[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrixB[i][j] = sc.nextInt();
            }
        }

        int[][] result;
        result = squareMatrixMultiply_recursive(matrixA, matrixB, 0, size - 1, 0, size - 1, 0, size - 1, 0, size - 1);
//        result = squareMatrixMultiply_Strassen(matrixA, matrixB, 0, size - 1, 0, size - 1, 0, size - 1, 0, size - 1);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] squareMatrixMultiply_recursive(int[][] matrixA,int[][] matrixB, int rowStartA, int rowEndA, int columnStartA, int columnEndA, int rowStartB, int rowEndB, int columnStartB, int columnEndB) {
        if(rowStartA == rowEndA && columnStartA == columnEndA && rowStartB == rowEndB && columnStartB == columnEndB) {
            return new int[][] {{matrixA[rowStartA][columnStartA] * matrixB[rowStartB][columnStartB]}};
        }
        else if(rowStartA > rowEndA || columnStartA > columnEndA || rowStartB > rowEndB || columnStartB > columnEndB) {
            int[][] result = new int[Integer.max(rowEndA - rowStartA + 1, 1)][Integer.max(columnEndB - columnStartB + 1, 1)];
            for(int i = 0; i < result.length; i++) {
                for(int j = 0; j < result[0].length; j++) {
                    result[i][j] = 0;
                }
            }
            return result;
        }
        else {
            int rowMidA = (rowStartA + rowEndA) / 2;
            int columnMidA = (columnStartA + columnEndA) / 2;
            int rowMidB = (rowStartB + rowEndB) / 2;
            int columnMidB = (columnStartB + columnEndB) / 2;
            int[][] result = new int[rowEndA - rowStartA + 1][columnEndB - columnStartB + 1];

            int[][] resultA11B11 = squareMatrixMultiply_recursive(matrixA, matrixB, rowStartA, rowMidA, columnStartA, columnMidA, rowStartB, rowMidB, columnStartB, columnMidB);
            int[][] resultA12B21 = squareMatrixMultiply_recursive(matrixA, matrixB, rowStartA, rowMidA, columnMidA + 1, columnEndA, rowMidB + 1, rowEndB, columnStartB, columnMidB);
            int[][] resultA11B12 = squareMatrixMultiply_recursive(matrixA, matrixB, rowStartA, rowMidA, columnStartA, columnMidA, rowStartB, rowMidB, columnMidB + 1, columnEndB);
            int[][] resultA12B22 = squareMatrixMultiply_recursive(matrixA, matrixB, rowStartA, rowMidA, columnMidA + 1, columnEndA, rowMidB + 1, rowEndB, columnMidB + 1, columnEndB);
            int[][] resultA21B11 = squareMatrixMultiply_recursive(matrixA, matrixB, rowMidA + 1, rowEndA, columnStartA, columnMidA, rowStartB, rowMidB, columnStartB, columnMidB);
            int[][] resultA22B21 = squareMatrixMultiply_recursive(matrixA, matrixB, rowMidA + 1, rowEndA, columnMidA + 1, columnEndA, rowMidB + 1, rowEndB, columnStartB, columnMidB);
            int[][] resultA21B12 = squareMatrixMultiply_recursive(matrixA, matrixB, rowMidA + 1, rowEndA, columnStartA, columnMidA, rowStartB, rowMidB, columnMidB + 1, columnEndB);
            int[][] resultA22B22 = squareMatrixMultiply_recursive(matrixA, matrixB, rowMidA + 1, rowEndA, columnMidA + 1, columnEndA, rowMidB + 1, rowEndB, columnMidB + 1, columnEndB);

            for(int i = 0; i <= rowMidA - rowStartA; i++) {
                for(int j = 0; j <= columnMidB - columnStartB; j++) {
                    result[i][j] = resultA11B11[i][j] + resultA12B21[i][j];
                }
            }
            for(int i = 0; i < rowEndA - rowMidA; i++) {
                for(int j = 0; j <= columnMidB - columnStartB; j++) {
                    result[i + rowMidA - rowStartA + 1][j] = resultA21B11[i][j] + resultA22B21[i][j];
                }
            }
            for(int i = 0; i <= rowMidA - rowStartA; i++) {
                for(int j = 0; j < columnEndB - columnMidB; j++) {
                    result[i][j + columnMidB - columnStartB + 1] = resultA11B12[i][j] + resultA12B22[i][j];
                }
            }
            for(int i = 0; i < rowEndA - rowMidA; i++) {
                for(int j = 0; j < columnEndB - columnMidB; j++) {
                    result[i + rowMidA - rowStartA + 1][j + columnMidB - columnStartB + 1] = resultA21B12[i][j] + resultA22B22[i][j];
                }
            }
            return result;
        }
    }

//    static int[][] squareMatrixMultiply_Strassen(int[][] matrixA,int[][] matrixB, int rowStartA, int rowEndA, int columnStartA, int columnEndA, int rowStartB, int rowEndB, int columnStartB, int columnEndB) {
//
//    }
}
