package ajav_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import ajav_launcher.aircrafts.*;

public class Simulation {
    //pasarla dentro del main
    private static int cycles;
    private static List<Aircraft> aircrafts_li = new ArrayList<>();

    public static class SimulationException extends Exception {
        public SimulationException(String message) {
            super(message);
        }
    }

    private static void loadAircrafts(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null)
        {
            String[] data = line.split("\\s+"); //divide por 1 o + espacios vacios
            // for (String word : data)
            //     System.out.println(word);
            String type = data[0];
            String name = data[1];
            int longitude = Integer.parseInt(data[2]);
            int latitude = Integer.parseInt(data[3]);
            int height = Integer.parseInt(data[4]);
            System.out.println("TYPE: " + type + " | NAME: " + name + " | LONG: " + longitude + " | LAT: " + latitude + " | HE: " + height);
            Aircraft aircraft = null;
            switch (type.toLowerCase()) {
                case "jetplane":
                    aircraft = new JetPlane(type, name, longitude, latitude, height);
                    break;
            }
            aircrafts_li.add(aircraft);
            System.out.println("Creado: " + aircraft);
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
            System.out.println("CYCLES: " + cycles);
            //funcion que cambia el tiempo
            loadAircrafts(br);
            System.out.println("WEATHER CHANGE NOW");
            WeatherTower weatherTower = new WeatherTower();
            while (cycles > 0)
            {
                weatherTower.changeWeather();
                System.out.println("-------------");
                cycles--;
            }
        } catch (SimulationException e) {
            System.out.println("Simulation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read .txt");
        }
    }
}