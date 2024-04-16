package Pr2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParallelProcessingDemo {
    public static void main(String[] args) {
        // Создание списка данных
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            data.add(i);
        }

        // Вывод минимума и максимума
        int min = findMin(data);
        int max = findMax(data);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);

        // Ввод данных пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mass:");
        double mass = scanner.nextDouble();
        System.out.println("Enter velocity:");
        double velocity = scanner.nextDouble();
        System.out.println("Enter height:");
        double height = scanner.nextDouble();
        scanner.close();

        // Расчет и вывод общей энергии
        double totalEnergy = EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        System.out.println("Total Energy: " + totalEnergy);

        // Выбор варианта отображения
        int displayOption = 1; // Для простоты примера выберем текстовую таблицу

        CalculationResultRenderer renderer;
        if (displayOption == 1) {
            renderer = new TextTableRenderer();
        } else {
            renderer = new HTMLResultRenderer();
        }

        // Создание объекта результата
        CalculationResult result = new CalculationResult(mass, velocity);

        // Отображение результата
        String renderedResult = renderer.render(result, displayOption);
        System.out.println("Rendered Result:\n" + renderedResult);
    }

    // Метод для поиска минимума
    public static int findMin(List<Integer> data) {
        return data.parallelStream().min(Integer::compareTo).orElse(0);
    }

    // Метод для поиска максимума
    public static int findMax(List<Integer> data) {
        return data.parallelStream().max(Integer::compareTo).orElse(0);
    }
}