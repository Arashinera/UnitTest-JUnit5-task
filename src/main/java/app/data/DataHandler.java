package app.data;

import app.exceptions.DeviceException;

public class DataHandler {

    public static String handleData() {
        DataProvider provider = new DataProvider();
        DataValidator validator = new DataValidator();

        try {
            return validator.validateTemperature(provider.getTemperature(DataProvider.choice));
        } catch (DeviceException exception) {
            return exception.getMessage();
        }
    }
}
