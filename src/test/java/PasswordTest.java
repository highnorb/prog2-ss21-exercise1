import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @BeforeAll
    static void setUpAll(){}

    @BeforeEach
    void setUp(){}

    Password testPassword;

    @DisplayName("Test Constructor.")
    @Test
    public void testCreatePassword(){
        testPassword = new Password("testPassword");
        String actual = testPassword.getPw();
        String expected = "testPassword";
        assertEquals(actual, expected);
    }

    @DisplayName("Length is right")
    @Test
    public void testRightLength(){
        testPassword = new Password("asdfsadfsadfsdf");
        //Boolean expected = true;
        //Boolean actual = testPassword.checkLength();
        //assertEquals(expected, actual);
        assertTrue(testPassword.checkLength());
    }

    @DisplayName("Length is too short")
    @Test
    public void testTooShort(){
        testPassword = new Password("asd");
        assertFalse(testPassword.checkLength());
    }

    @DisplayName("Length is too long.")
    @Test
    public void testTooLong(){
        testPassword = new Password("1234567890adfghjadgdgdfgadfgaertsdadsf");
        Assertions.assertFalse(testPassword.checkLength());
    }

    @DisplayName("Letters small and capital included.")
    @Test
    public void testLettersBoth(){
        testPassword = new Password("asdfgASDFG");
        Boolean actual = testPassword.checkLetters();
        assertTrue(actual);
    }

    @DisplayName("Just small letters included.")
    @Test
    public void testLettersSmall(){
        testPassword = new Password("asdfgasdfsadf");
        Boolean actual = testPassword.checkLetters();
        assertFalse(actual);
    }

    @DisplayName("Just capital letters included.")
    @Test
    public void testLettersCapital(){
        testPassword = new Password("ASDFGHJKLJJGHSFD");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("Just numbers included.")
    @Test
    public void testLettersNumbers(){
        testPassword = new Password("1234567890");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("Empty password.")
    @Test
    public void testLettersNothing(){
        testPassword = new Password("");
        assertFalse(testPassword.checkLetters());
    }

    @DisplayName("No numbers inside.")
    @Test
    public void testNumbersNotInside(){
        testPassword = new Password("asdffadffjgkj");
        assertFalse(testPassword.checkNumbersInside());
    }

    @DisplayName("Some numbers inside.")
    @Test
    public void testNumbersInside(){
        testPassword = new Password("asdffadffs345678jgkj");
        assertTrue(testPassword.checkNumbersInside());
    }

    @DisplayName("No numbers, but signs inside.")
    @Test
    public void testNumbersNotSignsInside(){
        testPassword = new Password("asdffadffs!=)345678jgkj");
        assertTrue(testPassword.checkNumbersInside());
    }

    @DisplayName("All special signs included.")
    @Test
    public void testSpecialsignsAllInside(){
        testPassword = new Password("asdf()#$?!%/@");
        assertTrue(testPassword.checkSpecialsignsGood());
    }

    @DisplayName("No special signs included.")
    @Test
    public void testSpecialsignsNotInside(){
        testPassword = new Password("asdfwertzuio");
        assertFalse(testPassword.checkSpecialsignsGood());
    }

    @DisplayName("Some special signs included.")
    @Test
    public void testSpecialsignsPartlyInside(){
        testPassword = new Password("asdfwer?!tzuio");
        assertTrue(testPassword.checkSpecialsignsGood());
    }

    @DisplayName("Special sign - included.")
    @Test
    public void testSpecialsignBad1(){
        testPassword = new Password("-asdfwer?!tzuio");
        assertFalse(testPassword.checkSpecialsignsBad());
    }

    @DisplayName("Special sign § included.")
    @Test
    public void testSpecialsignBad2(){
        testPassword = new Password("§asdfwer?!tzuio");
        assertFalse(testPassword.checkSpecialsignsBad());
    }

    @DisplayName("All bad special signs included.")
    @Test
    public void testSpecialsignBadAll(){
        testPassword = new Password("-§&=`´+*~'{}²³_.:,;µ|<>€");
        assertFalse(testPassword.checkSpecialsignsBad());
    }

    @DisplayName("Numberline included.")
    @Test
    public void testNumberlineIncluded(){
        testPassword = new Password("asdfsad123");
        assertFalse(testPassword.checkNumberline());
    }

    @DisplayName("Numberline not included.")
    @Test
    public void testNumberlineNotIncluded(){
        testPassword = new Password("asdfsad1k2k3k");
        assertTrue(testPassword.checkNumberline());
    }

    @DisplayName("Unity-Numberline included.")
    @Test
    public void testUnitynumberlineIncluded(){
        testPassword = new Password("asdfsad1111");
        assertFalse(testPassword.checkUnitynumberline());
    }

    @DisplayName("Unity-Numberline not included.")
    @Test
    public void testUnitynumberlineNotIncluded(){
        testPassword = new Password("asdfsad111stfhh");
        assertTrue(testPassword.checkUnitynumberline());
    }


}
