
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {

    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 6)
                    .sorted((p1, p2) -> p1[5].compareTo(p2[5]))
                    .map(parts -> parts[3]+ " (" +parts[4]+ "), " +parts[2].trim().split(" ")[0]+ ", " +parts[5])
                    .forEach(line -> System.out.println(line));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
