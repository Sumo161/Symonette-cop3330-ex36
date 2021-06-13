package ex36;

/*
 *  UCF COP3330 Summer 2021 Assignment 2 Solution
 *  Copyright 2021 Nyles Symonette
 */

// imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        //user input requested
        while (true) {
            System.out.print("Enter a number: ");
            String userInput = inputScanner.nextLine();
            if (userInput.toLowerCase().equals("done")) {
                break;
            }
            numbers.add(Integer.parseInt(userInput));
        }
        printNumbers(numbers);

        // double min,max, etc
        double mean = average(numbers);
        double minimum = min(numbers);
        double maximum = max(numbers);
        double standardDeviation = std(numbers);

        // println to user ; min,max,avg, and deviation
        System.out.println("The average is: " + mean);
        System.out.println("The minimum is: " + minimum);
        System.out.println("The maximum is: " + maximum);
        System.out.println("The standard deviation is: " + standardDeviation);

        inputScanner.close();
    }

    private static void printNumbers(ArrayList<Integer> numbers) {
        System.out.print("Numbers: ");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i < numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    // priv static double min - avg & std
    private static double average(ArrayList<Integer> numbers) {
        double total = 0.0;
        for (Integer number : numbers) {
            total += number;
        }

        return total / numbers.size();
    }

    private static int min(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(0);
    }

    private static int max(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.get(numbers.size() - 1);
    }

    private static double std(ArrayList<Integer> numbers) {
        double standardDeviation = 0.0;
        double mean = average(numbers);

        for (int num : numbers) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / numbers.size());
    }
}
