import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){

        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

            try ( Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    result.append(line).append("\n");
                }

            } catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();

    }

    public String getHamletData(){

        return hamletData;
    }


    // A method to find the nameToBeReplaced

    public Boolean isNameFound ( String nameTobeReplaced) {

        Pattern ptInText= Pattern.compile(nameTobeReplaced);
        Matcher nameMatcher= ptInText.matcher(hamletData);
        return nameMatcher.find();
    }

    // A method to replace the nameToBeReplaced.
    public String replacement ( String firstName, String nameTobeReplaced) {

        Pattern ptInText = Pattern.compile(firstName);
        Matcher nameMatcher = ptInText.matcher(hamletData);
        return nameMatcher.replaceAll(nameTobeReplaced);

    }


    // A method to write the file text containing the Hamlet.txt

     public void fileWriting ( String hamletText) throws FileNotFoundException {

        String textFileName = "hamlet.txt";
        FileOutputStream outputStream = new FileOutputStream(textFileName);
        Formatter formatter= new Formatter(outputStream);
        formatter.format(hamletText);

    }




}
