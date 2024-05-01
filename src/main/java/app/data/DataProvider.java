package app.data;

import app.utils.DataOutput;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DataProvider {

    public static int choice = 0;


    public static void startApp() {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        try {
            do {
                System.out.println("""
                        Temperature checking device.
                        Choose option :
                        1) Input device temperature.
                        0) Exit.""");
                choice = input.nextInt();
            } while (choice < 0 || choice > 1);
        } catch (InputMismatchException exception) {
            System.out.println("ERROR: Please, input int value next time!!!");
        }

        DataOutput.getOutput(DataHandler.handleData());

        input.close();
    }

    public double getTemperature(int choice) {

        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.ENGLISH);

        try {
            if (choice == 1) {
                System.out.print("Please, input temperature value: ");
                return input.nextDouble();
            } else {
                System.exit(0);
            }
        } catch (InputMismatchException exception) {
            System.out.println("ERROR: Please, input double or int value next time!!!");
        }
        return 0;
    }
}
