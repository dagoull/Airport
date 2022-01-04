/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

/*****************************************************************************
 * @class Flight
 * @brief Flight que sirve para manejar el numero y los datos de pasajeros de un vuelo determinado
 * @author alu0101202556
 * @version 1.0
 ****************************************************************************/
public class Flight {

    private String flightNumber;
    private int seats;
    private Set<Passenger> passengers = new HashSet<>();

    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * Constructor de la clase
     * @param flightNumber  Numero del vuelo, la cadena debe de seguir la expresion regular de flightNumberRegex
     * @param seats         Numero de asientos que pueden ser ocupados por pasajeros
     */
    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     * Metodo para conseguir el atributo privado flightNumber
     * @return  Devuelve el numero del vuelo
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Metodo para conseguir el numero de pasajeros que estan asignados al vuelo
     * @return  Devuelve el numero de pasajeros asignados al vuelo
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * Agrega un pasajero al vuelo, si el numero de pasajeros es superior al de los asientos devuelve
     * un error
     * @param passenger El pasajero que será añadido al vuelo
     * @return          Si el pasajero fue añadido exitosamente devuelve un booleano en true
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * Elimina un pasajero del vuelo
     * @param passenger El pasajero que quiere ser eliminado
     * @return          Si la accion acurrio de forma exitosa, devuelve true
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}
