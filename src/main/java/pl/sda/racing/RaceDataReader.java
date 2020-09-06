package pl.sda.racing;

import javax.persistence.Entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
@Entity
public class RaceDataReader {
    private final String filePath;
    public RaceDataReader(String filePath) {
        this.filePath = filePath;
    }
    //    public List<Pigeon> getPigeons() throws FileNotFoundException {
//////        Scanner scanner = new Scanner(new File(filePath));
//////        scanner.nextLine();
//////        List<Pigeon> pigeonList = new ArrayList<>();
//////        while (scanner.hasNext()) {
//////            String line = scanner.nextLine();
//////            Pigeon pigeon = asPigeon(line);
//////            pigeonList.add(pigeon);
//////
//////        }
//////        return pigeonList;
    public List<Pigeon> getPigeons() throws IOException {
        return Files.readAllLines(Paths.get(filePath)).stream()
                .map(line-> line.split(","))
     //           .map(this::asPigeon)
                .map(this::asPigeon)
                .collect(Collectors.toList());

    }
    private Pigeon asPigeon(String asTablePigeon [] ) {
        return  new Pigeon(asTablePigeon[2], asTablePigeon[3], asTablePigeon[1]);
    }
}