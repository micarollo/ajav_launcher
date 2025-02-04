package ajav_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {
    private static int cycles;
    
    public static class SimulationException extends Exception {
        // private static final long serialVersionUID = 1L;
        public SimulationException(String message) {
            super(message);
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
            System.out.println(cycles);
            //funcion que cambia el tiempo
            WeatherTower weatherTower = new WeatherTower();
            while (cycles > 0)
            {
                weatherTower.changeWeather();
                cycles--;
            }
        } catch (SimulationException e) {
            System.out.println("Simulation error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read .txt");
        }
    }
}