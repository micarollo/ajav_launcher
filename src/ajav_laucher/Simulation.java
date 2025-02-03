package ajav_launcher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ajav_laucher.Simulation <file.txt>");
        }

        String fname = args[0];
        try (BufferedReader br = new BufferedReader(new FileReader(fname))){
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}