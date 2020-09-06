package pl.sda.racing;


import pl.sda.racing.Pigeon;
import pl.sda.racing.RaceDataReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
public class Application {
    public static void main(String[] args) throws IOException {
        RaceDataReader raceDataReader = new RaceDataReader("pigeon-racing.csv");
        List <Pigeon> pigeons = raceDataReader.getPigeons();
    }
}