import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListOfNumbers {
    private List rawNumbers = Collections.emptyList();
    private ArrayList<ProcessedNumber> processedNumbers = new ArrayList<ProcessedNumber>();
    private String path;
    private int totalValueOfPalindromes = 0;

    public ListOfNumbers(String fileName) {
        path = System.getProperty("user.dir") + "\\" + fileName;
        readFileInList(path);
        processNumbers();
        calculateTotalValue();
    }

    private void readFileInList(String fileName) {
        try {
            rawNumbers = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void processNumbers() {
        Iterator<String> itr = rawNumbers.iterator();
        while(itr.hasNext()) {
            processedNumbers.add(new ProcessedNumber(itr.next()));
        }
    }

    private void calculateTotalValue() {
        int i = 0;
        while(i < processedNumbers.size()) {
            ProcessedNumber current = processedNumbers.get(i);
            if(current.getIsPalindrome()) {
                totalValueOfPalindromes = totalValueOfPalindromes + current.getDecimalValue();
            }
            i++;
        }
    }

    public int getTotalValueOfPalindromes() {
        return totalValueOfPalindromes;
    }

}
