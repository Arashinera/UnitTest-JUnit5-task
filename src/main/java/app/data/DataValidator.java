package app.data;

import app.exceptions.DeviceException;
import app.utils.Constants;
public class DataValidator {
    public String validateTemperature(double temperature)
            throws DeviceException {
        if (temperature >= Constants.MIN_TEMPERATURE_RANGE
                & temperature <= Constants.MAX_TEMPERATURE_RANGE) {
            return "Temperature is OK. Device can work now.";
        } else {
            throw new DeviceException("Temperature is out of bounds! Device can't work now.");
        }
    }

}
