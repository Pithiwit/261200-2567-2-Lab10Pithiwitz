import java.io.*;
import java.util.regex.*;

public class ReadText {
    public static void inputFile(String filePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            int lineNumber = 0;//

            Pattern check = Pattern.compile("^\\s*\\d+\\s*([+\\-*/%]\\s*\\d+\\s*)*$");

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim(); //    ff     // --> //ff//

                if (!check.matcher(line).matches()) {
                    String invalidMessage = "Invalid line at " + lineNumber + ": " + line;
                    System.out.println(invalidMessage);
                    writer.write(invalidMessage);
                    writer.newLine();
                    continue;
                }

                try {
                    String sanitizedLine = line.replaceAll("\\s+", "");
                    int result = Calculator.evaluateExpression(sanitizedLine);
                    String resultMessage =  line + " = " + result;
                    System.out.println(resultMessage);
                    writer.write(resultMessage);
                    writer.newLine();
                } catch (Exception e) {
                    String errorMessage = "Error evaluating line " + lineNumber + ": " + line + " - " + e.getMessage();
                    System.out.println(errorMessage);
                    writer.write(errorMessage);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
}