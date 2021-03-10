import org.junit.jupiter.api.*;

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
    public void testLetters(){
        testPassword = new Password("asdfgASDFG");
        Boolean expected = true;
        Boolean actual = testPassword.checkLetters();
    }

}
