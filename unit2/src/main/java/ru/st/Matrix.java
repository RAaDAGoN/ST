package ru.st;

public class Matrix {
    private double[][] data;
    private int rows;
    private int cols;

    // Конструктор для создания матрицы заданного размера
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Метод для установки значения элемента
    public void setValue(int i, int j, double value) {
        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            data[i][j] = value;
        } else {
            System.out.println("Неверные индексы матрицы");
        }
    }

    // Метод для сложения матриц
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            System.out.println("Матрицы разных размеров нельзя сложить");
            return null;
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Метод для умножения матрицы на число
    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    // Метод для умножения матриц
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            System.out.println("Число столбцов первой матрицы должно равняться числу строк второй матрицы");
            return null;
        }

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // Метод для вывода матрицы на печать
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f", data[i][j]);
            }
            System.out.println();
        }
    }
}

class testingMatrix{
    public void testMatrix(){
        // Создаем матрицы
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix2 = new Matrix(2, 3);
        Matrix matrix3 = new Matrix(3, 2);

        // Заполняем матрицы значениями
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1.setValue(i, j, i + j);
                matrix2.setValue(i, j, (i + 1) * (j + 1));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                matrix3.setValue(i, j, i - j);
            }
        }

        System.out.println("Матрица 1:");
        matrix1.print();

        System.out.println("\nМатрица 2:");
        matrix2.print();

        System.out.println("\nМатрица 3:");
        matrix3.print();

        // Демонстрация сложения матриц
        System.out.println("\nСумма матриц 1 и 2:");
        Matrix sum = matrix1.add(matrix2);
        if (sum != null) {
            sum.print();
        }

        // Демонстрация умножения матрицы на число
        System.out.println("\nМатрица 1 умноженная на 2.5:");
        matrix1.multiply(2.5).print();

        // Демонстрация умножения матриц
        System.out.println("\nПроизведение матриц 1 и 3:");
        Matrix product = matrix1.multiply(matrix3);
        if (product != null) {
            product.print();
        }
    }
}
