package Test;

import Pr2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Создание списка данных
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            data.add(i);
        }

        // Вывод минимума и максимума
        int min = ParallelProcessingDemo.findMin(data);
        int max = ParallelProcessingDemo.findMax(data);
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
        
        // Создание нового Scanner для считывания варианта отображения
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\nSelect display option (1 - Text table, 2 - HTML table):");
        int displayOption = inputScanner.nextInt();
        inputScanner.close(); // Закрытие Scanner после использования

        scanner.close(); // Закрытие Scanner после считывания всех данных

        // Расчет и вывод общей энергии
        double totalEnergy = EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        System.out.println("Total Energy: " + totalEnergy);

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
}