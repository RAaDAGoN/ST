package ru.st;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("Выберите задачу(1-10):");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();

        switch (task){
            case 1:
                System.out.println(helloWorld());
                break;
            case 2:
                System.out.print("a=");
                int a = sc.nextInt();
                System.out.print("b=");
                int b = sc.nextInt();
                System.out.printf("%s / %s = %s и %s в остатке", a, b, (int)divideNumber(21, 8), a % b);
                break;
            case 3:
                System.out.print("Число n=");
                int x = sc.nextInt();
                System.out.printf("Число %s %s палиндромом", x, palindrome(x) ? "является" : "не является");
                break;
            case 4:
                System.out.print("n=");
                int n = sc.nextInt();
                System.out.printf("Сумма цифр числа %s = %s", n, sum(n));
                break;
            case 5:
                System.out.print("Вес на Земле: ");
                int weight = sc.nextInt();
                System.out.printf("Вес на Земле %s и вес на Луне %s", weight, (double)(weight * 17) / 100);
                break;
            case 6:
                System.out.print("Число = ");
                int simple = sc.nextInt();
                System.out.printf("Число %s %s простым", simple, isSimple(simple) ? "является" : "не является");
                break;
            case 7:
                System.out.print("Введите n чисел Фибоначчи(2 < n < 100):");
                int fibonacciNumber = sc.nextInt();
                int[] FN = fibonacciNumbers(fibonacciNumber);
                for (Integer q : FN){
                    System.out.print(q + " ");
                }
                break;
            case 8:
                System.out.print("Угадайте букву A-Z");
                game();
                break;
            case 9:
                System.out.println("Решение квадратного уравнения: ");
                quadraticEquations();
                break;
            case 10:
                System.out.print("Введите число: ");
                int num = sc.nextInt();
                romanNumerals(num);

        }

    }

    public static String helloWorld(){
        return "Hello World";
    }

    public static double divideNumber(double a, double b){
        return a / b;
    }

    public static boolean palindrome(int n){
        int originalNumber = n;
        int reversedNumber = 0;
        while (n != 0){
            reversedNumber = reversedNumber * 10 + n % 10;
            n /= 10;
        }
        return originalNumber == reversedNumber;
    }

    public static int sum(int n){
        int sum = 0;
        while (n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static boolean isSimple(int n){
        if(n < 2) return false;
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] fibonacciNumbers(int n){
        int[] f = new int[n];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static void game(){
        // Список букв
        List<String> listLetters = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++){
            listLetters.add(String.valueOf(c));
        }

        // Загадываем букву
        Random random = new Random();
        int randomIndex = random.nextInt(listLetters.size());
        String randomLetter = listLetters.get(randomIndex);

//        System.out.println("\nЗагаданная буква: " + randomLetter);

        Scanner sc = new Scanner(System.in);

        while (true){
            String letter = sc.nextLine();
            if (letter.equals(randomLetter)){
                System.out.println("Right");
                break;
            } else {
                int indexLetter = listLetters.indexOf(letter);
                System.out.println(indexLetter > randomIndex ? "You`re too high" : "You`re to low");
            }
        }
    }

    public static void quadraticEquations(){
        int a=1, b=3, c=-4;
        double D = Math.pow(b, 2) - 4 * a * c;
        double x1 = (-b + Math.sqrt(D)) / 2*a;
        double x2 = (-b - Math.sqrt(D)) / 2*a;
        System.out.printf("a=%s b=%s c=%s \n D=%s x1=%s x2=%s", a, b, c, D, x1, x2);
    }

    public static void romanNumerals(int number){
        if (number < 1 || number > 100){
            throw new IllegalArgumentException("Число должно быть в пределе от 1 до 100");
        }
        String[] romanSymbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder roman = new StringBuilder();

        int i =0;
        while (number > 0){
            if (number>= values[i]){
                roman.append(romanSymbols[i]);
                number -= values[i];
            } else i++;
        }

        System.out.println(roman);
    }
}