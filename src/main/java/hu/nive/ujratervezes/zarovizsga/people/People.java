package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    public int getNumberOfMales(String s) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(s))) {
            String line = br.readLine();
            int sum = 0;
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(",");
                if (tmp[4].equals("Male")) {
                    sum++;
                }
            }
            return sum;
        } catch (IOException e) {
            throw new IllegalStateException("file error", e);
        }
    }
}
