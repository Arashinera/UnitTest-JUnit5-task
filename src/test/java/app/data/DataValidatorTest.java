package app.data;

import app.exceptions.DeviceException;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class DataValidatorTest {

    DataValidator validator;

    @BeforeEach
    void setUp() {
        validator = new DataValidator();
    }

    @ParameterizedTest
    @ValueSource(doubles = { -7.8, 23.48, 29.811 })
    @Order(2)
    @DisplayName("Test if temperature is in bounds.")
    void test_If_Temperature_Is_In_Bounds(double value) throws DeviceException {
        assertEquals("Temperature is OK. Device can work now.",
                validator.validateTemperature(value));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -11.9, 45.23, 118.457 })
    @Order(1)
    @DisplayName("Test if invalid temperature throws exception.")
    void test_If_Invalid_Temperature_Throws_Exception(double value) {
        assertThrows(DeviceException.class, () ->
                validator.validateTemperature(value), "No exception.");
    }

    @AfterEach
    void tearDown() {
        validator = null;
    }
}