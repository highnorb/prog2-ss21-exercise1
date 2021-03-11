import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @BeforeAll
    static void init(){}

    @BeforeEach
    void setUp(){}

    Password testPassword;

    @DisplayName("Test Constructor")
    @Test
    public void testCreatePassword(){
        testPassword = new Password("testPassword");
        String actual = testPassword.getPw();
        String expected = "testPassword";
        assertEquals(actual, expected);
    }

    @DisplayName("Length right")
    @Test
    public void testRightLength(){
        testPassword = new Password("asdfsadfsadfsdf");
        //Boolean expected = true;
        //Boolean actual = testPassword.checkLength();
        //assertEquals(expected, actual);
        assertTrue(testPassword.checkLength());
    }

    @DisplayName("PW is too short")
    @Test
    public void testTooShort(){
        testPassword = new Password("asd");
        assertFalse(testPassword.checkLength());
    }

    @DisplayName("PW is too long")
    @Test
    public void testTooLong(){
        testPassword = new Password("1234567890adfghjadgdgdfgadfgaertsdadsf");
        Assertions.assertFalse(testPassword.checkLength());
    }

    @DisplayName("Letters small and capital")
    @Test
    public void testLettersBoth(){
        testPassword = new Password("asdfgASDFG");
        Boolean actual = testPassword.checkLetters();
        assertTrue(actual);
    }

    @DisplayName("Just small letters")
    @Test
    public void testLettersSmall(){
        testPassword = new Password("asdfgasdfsadf");
        Boolean actual = testPassword.checkLetters();
        assertFalse(actual);
    }

    @DisplayName("Just capital letters")
    @Test
    public void testLettersCapital(){
        testPassword = new Password("ASDFGHJKLJJGHSFD");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("Just numbers")
    @Test
    public void testLettersNumbers(){
        testPassword = new Password("1234567890");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("Nothing")
    @Test
    public void testLettersNothing(){
        testPassword = new Password("");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("No numbers inside")
    @Test
    public void testNumbersNotInside(){
        testPassword = new Password("asdffadffjgkj");
        assertFalse(testPassword.checkNumbersInside());
    }

    @DisplayName("Numbers inside")
    @Test
    public void testNumbersInside(){
        testPassword = new Password("asdffadffs345678jgkj");
        assertTrue(testPassword.checkNumbersInside());
    }

    @DisplayName("No numbers, but signs inside")
    @Test
    public void testNumbersNotSignsInside(){
        testPassword = new Password("asdffadffs!=)345678jgkj");
        assertTrue(testPassword.checkNumbersInside());
    }

    @DisplayName("All special signs included")
    @Test
    public void testSpecialsignsAllInside(){
        testPassword = new Password("asdf()#$?!%/@");
        assertTrue(testPassword.checkSepcialsigns());
    }

    @DisplayName("No special signs included")
    @Test
    public void testSpecialsignsNotInside(){
        testPassword = new Password("asdfwertzuio");
        assertFalse(testPassword.checkSepcialsigns());
    }

    @DisplayName("Special Signs not included")
    @Test
    public void testSpecialsignsPartlyInside(){
        testPassword = new Password("asdfwer?!tzuio");
        assertTrue(testPassword.checkSepcialsigns());
    }


}
