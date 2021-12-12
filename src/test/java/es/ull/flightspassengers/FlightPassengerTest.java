package es.ull.flightspassengers;

import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas para los métodos de Flight y Passenger")
@Nested
public class FlightPassengerTest {
    private Flight flight;
    private Passenger paco;
    private Passenger juan;

    @BeforeEach
    void setUp() {
        flight = new Flight("DV123", 100);
        paco = new Passenger("01","Paco","US");
        juan = new Passenger("02","Juan","US");
    }

    @Nested
    @DisplayName("Funciones de los vuelos")
    class FlightMethods {

        @Test
        @DisplayName("Se pueden añadir pasajeros al vuelo")
        public void testFlightAddPassenger() {
            assertAll("Comprobando que se pueden añadir pasajeros de la forma correcta",
                    () -> assertEquals(0, flight.getNumberOfPassengers()),
                    () -> assertEquals(true, flight.addPassenger(paco)),
                    () -> assertEquals(1, flight.getNumberOfPassengers()),
                    () -> assertEquals(true, flight.addPassenger(juan)),
                    () -> assertEquals(2, flight.getNumberOfPassengers())
            );
        }

        @DisplayName("No se pueden añadir más de una vez un mismo pasajero")
        @RepeatedTest(5)
        public void testFlightAddPassenger5(RepetitionInfo repetitionInfo) {
            for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                flight.addPassenger(juan);
            }
            assertAll("Verificando que no se pueden añadir mas de un mismo pasajero",
                    () -> assertEquals(1, flight.getNumberOfPassengers())
            );
        }
    }

}
