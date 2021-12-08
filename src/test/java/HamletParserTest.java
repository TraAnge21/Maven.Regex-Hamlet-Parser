import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() throws FileNotFoundException {

        String nameTobeReplaced ="Hamlet";
        String firstName= "Leon";
        hamletText=hamletParser.replacement(firstName,nameTobeReplaced);
        hamletParser.fileWriting(hamletText);

        // check if it is true or false
        Assert.assertTrue(hamletText.contains("Hamlet"));
        Assert.assertFalse(hamletText.contains("Leon"));

    }

    @Test
    public void testChangeHoratioToTariq() throws FileNotFoundException {
        String nameTobeReplaced ="Hamlet";
        String firstName= "Tariq";
        hamletText=hamletParser.replacement(firstName,nameTobeReplaced);
        hamletParser.fileWriting(hamletText);

        // check if it is true or false
        Assert.assertTrue(hamletText.contains("Hamlet"));
        Assert.assertFalse(hamletText.contains("Tariq"));


    }

    @Test
    public void testFindHoratio() {

        Assert.assertTrue(hamletParser.isNameFound("Horatio"));

    }

    @Test
    public void testFindHamlet() {

        Assert.assertTrue(hamletParser.isNameFound("Hamlet"));


    }
}