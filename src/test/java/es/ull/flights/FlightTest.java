package es.ull.flights;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para los vuelos")
@Nested
public class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        flight = new Flight("DV123", 100);
    }

    @Nested
    @DisplayName("Existe un vuelo normal")
    class NormalFlight {

        @Test
        @DisplayName("Se comprueba sus atributos")
        public void testAtributosFlight() {
            assertAll("Comprobando los atributos del vuelo",
                    () -> assertEquals("DV123", flight.getFlightNumber()),
                    () -> assertEquals(0, flight.getNumberOfPassengers())
            );
        }
    }

}
