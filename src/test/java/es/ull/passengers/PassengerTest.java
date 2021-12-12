package es.ull.passengers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Prueba para los pasajeros")
@Nested
public class PassengerTest {
    private Passenger passenger;

    @BeforeEach
    void setUp() {
        passenger = new Passenger("01","Paco","US");
    }

    @Nested
    @DisplayName("Existe un pasajero")
    class NormalPassanger {

        @Test
        @DisplayName("Se comprueban sus atributos")
        public void testAtributosPassenger() {
            assertAll("Asegurando que los atributos estan bien inicializados",
                    () -> assertEquals("01", passenger.getIdentifier()),
                    () -> assertEquals("Paco", passenger.getName()),
                    () -> assertEquals("US", passenger.getCountryCode())
            );
        }
    }
}
