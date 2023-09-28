package introToJava;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3(1.3, 2, 3, 4, 5);
    }

    private static void task1() {
        System.out.println("Hello\nOlga Novikova");
    }

    private static void task2() {
        System.out.println(-5 + 8 * 6);
        double operation = 20 + (double) (-3 * 5) / 8;
        System.out.println(operation);
    }

    private static void task3(double first, double second, double third, double forth, double fifth) {
        double multiplication = first * second * third * forth * fifth;
        System.out.printf("%.2f * %.2f * %.2f * %.2f * %.2f equals %.2f",
                first, second, third, forth, fifth, multiplication);
    }
}