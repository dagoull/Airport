package es.ull.flights;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/*****************************************************************************
 * @class FlightTest
 * @brief Pruebas para comprobar los metodos y atributos de la clase Flight
 * @author alu0101202556
 * @version 1.0
 ****************************************************************************/
@DisplayName("Pruebas para los vuelos")
@Nested
public class FlightTest {
    private Flight flight;

    @BeforeEach
    void setUp() {
        //Se crea un vuelo adecuado para cada prueba
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
