import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceWords {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        checkArgument(args);
        BufferedReader input = null;
        PrintWriter output = null;

        try {
            input = new BufferedReader(new FileReader(fileName));
            output = new PrintWriter(new FileWriter("temp.txt"));
            String line;
            while ((line = input.readLine()) != null) {
                line = line.replaceAll("\\b(the)\\b", "ze");
                output.println(line);
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }

    private static void checkArgument(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: CountLines <file name>");
            System.exit(1);
        }
    }
}

