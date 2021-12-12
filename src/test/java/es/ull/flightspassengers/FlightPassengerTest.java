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
                    () -> assertTrue(flight.addPassenger(paco)),
                    () -> assertEquals(1, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(juan)),
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

        @Test
        @DisplayName("Se pueden eliminar pasajeros del vuelo")
        public void testFlightRemovePassenger() {
            assertAll("Verificando que se pueden eliminar pasajeros del vuelo",
                    () -> assertEquals(0, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(paco)),
                    () -> assertEquals(1, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.addPassenger(juan)),
                    () -> assertEquals(2, flight.getNumberOfPassengers()),
                    () -> assertTrue(flight.removePassenger(paco)),
                    () -> assertEquals(1, flight.getNumberOfPassengers())
            );
        }
    }

    @Nested
    @DisplayName("Funciones de los pasajeros")
    class PassengerMethods {

        @Test
        @DisplayName("Se puede ver el vuelo al que esta asignado un determinado pasajero")
        public void testPassengerFlight() {
            assertAll("Verificando que se puede ver el vuelo de un pasajero",
                    () -> assertTrue(flight.addPassenger(juan)),
                    () -> assertEquals(flight, juan.getFlight())
            );
        }
    }

}
