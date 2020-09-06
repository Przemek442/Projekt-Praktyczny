package pl.sda.racing;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceDataReaderTest {
    @Test
    void shouldReadOnePigeon() throws IOException {
// given
        RaceDataReader raceDataReader = new RaceDataReader("D:\\javawwa30\\Projekt-Praktyczny\\src\\test\\resources\\pigeon.test.csv");
//when
        List<Pigeon> pigeonList = raceDataReader.getPigeons();
//then
        assertEquals(1, pigeonList.size());
        Pigeon pigeon = pigeonList.get(0);
        assertEquals("KOT", pigeon.getName());
        assertEquals("Texas Outlaws", pigeon.getOwner());
        assertEquals("19633-AU15-FOYS", pigeon.getBirdId());
    }
}