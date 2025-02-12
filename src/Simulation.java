//diferent diagram than UML
package src;

import aircrafts.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private static int cycles;
    private final static List<Aircraft> aircrafts_li = new ArrayList<>();

    public static class SimulationException extends Exception {
        public SimulationException(String message) {
            super(message);
        }
    }

    private static void loadAircrafts(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null)
        {
            String[] data = line.split("\\s+");
            String type = data[0];
            String name = data[1];
            int longitude = Integer.parseInt(data[2]);
            int latitude = Integer.parseInt(data[3]);
            int height = Integer.parseInt(data[4]);
            Aircraft aircraft = null;
            switch (type.toLowerCase()) {
                case "jetplane" -> aircraft = new JetPlane(type, name, longitude, latitude, height);
                case "helicopter" -> aircraft = new Helicopter(type, name, longitude, latitude, height);
                case "baloon" -> aircraft = new Baloon(type, name, longitude, latitude, height);
            }
            aircrafts_li.add(aircraft);
        }
    }

    private static void initSimulation(BufferedReader br) throws SimulationException{
        try {
            String line = br.readLine();
            if (line != null)
                cycles = Integer.parseInt(line);
            else
                throw new SimulationException("Empty file or wrong format");
        } catch (IOException e) {
            throw new SimulationException("Cannot read file");
        }
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ajav_laucher.Simulation <file.txt>");
        }

        String fname = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(fname))){
            initSimulation(br);
            loadAircrafts(br);
            System.out.println("WEATHER CHANGE NOW");
            WeatherTower weatherTower = new WeatherTower();
            weatherTower.register(aircrafts_li);
            while (cycles > 0)
            {
                String weather = weatherTower.changeWeather();
                for (Aircraft aircraft : aircrafts_li) {
                    aircraft.reactToWeather(weather, weatherTower);
                    if (weatherTower.isRegistered(aircraft))
                        System.out.println(aircraft.getWeatherMsg(weather));
                }
                cycles--;
            }
        } catch (SimulationException e) {
            System.out.println("Simulation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read .txt");
        }
    }
}