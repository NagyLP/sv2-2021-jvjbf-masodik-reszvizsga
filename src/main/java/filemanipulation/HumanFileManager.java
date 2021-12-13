package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private final List<Human> humans = new ArrayList<>();

    public HumanFileManager() {
    }

    public void readHumansFromFile(Path path) {
        try {
            List<String> fileLines = Files.readAllLines(path);
            for (String item : fileLines) {
                String[] fileLinesPiece = item.split(";");
                humans.add(new Human(fileLinesPiece[0],
                        fileLinesPiece[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> fileLines = new ArrayList<>();
        for (Human item : humans) {
            if (isHumanMale(item)) {
                fileLines.add(item.getName() + ";" + item.getIdentityNumber());
            }
        }
        try {
            Files.write(path, fileLines);
        } catch (IOException ioe) {
            throw new IllegalStateException("Writening Error.", ioe);
        }
    }

    private boolean isHumanMale(Human human) {
        char idFirstChar = human.getIdentityNumber().charAt(0);
        if (idFirstChar == '1' || idFirstChar == '3') {
            return true;
        }
        return false;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
