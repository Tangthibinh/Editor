package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditorModel {
    private List<String> lines;

    public TextEditorModel() {
        this.lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    public boolean saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            lines.forEach(line -> {
                try {
                    writer.write(line);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean loadFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            lines.clear();
            reader.lines().forEach(lines::add);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteLines() {
        lines.clear();
    }
}