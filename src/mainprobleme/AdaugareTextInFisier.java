package mainprobleme;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AdaugareTextInFisier {
    public static void main(String[] args) {
        try {

            Path path = Paths.get("C:\\Users\\constantinb\\Documents\\ana.txt");

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

            int position = 4;
            String extraLine = "aicijkgf";

            lines.add(position, extraLine);
            Files.write(path, lines, StandardCharsets.UTF_8);


            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


