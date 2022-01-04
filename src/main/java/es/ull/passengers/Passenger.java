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
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;
/*****************************************************************************
 * @class Passenger
 * @brief Passenger que maneja los datos de los pasajeros y sus respectivos vuelos
 * @author alu0101202556
 * @version 1.0
 ****************************************************************************/
public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    /**
     * Construcor de la clase Passenger, si se pasa un codigo de pais incorrecto no se podra crear al pasajero
     * @param identifier    Identificador con el que se diferenciara a los distintos pasajeros
     * @param name          Nombre del pasajero
     * @param countryCode   Codigo del pais donde recide
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * Metodo para devolver el identificador del pasajero
     * @return  Devuelve el atributo privado identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Metodo para devolver el nombre del pasajero
     * @return  Devuelve el atributo privado name
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para devolver el codigo del pais del pasajero
     * @return  Devuelve el atributo privado countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Metodo para devolver el vuelo al que esta asignado del pasajero
     * @return  Devuelve el atributo privado flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * Metodo para cambiar el vuelo asignado de un pasajero, si el pasajero no se encuentra en ningun vuelo
     * devuelve un error, al igual que si no se utiliza un vuelo valido para la asignacion
     * @param flight    Vuelo al que se le asignara al pasajero
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * Metodo que cambia el vuelo actual por otro
     * @param flight    Nuevo vuelo que sustituira al anterior
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
