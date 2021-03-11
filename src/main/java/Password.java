import java.util.regex.Pattern;


public class Password {

    String pw;

    public Password(String pw){
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }


    public final Pattern textPatternSpecialsigns = Pattern.compile("[()#$?!%/@]");


    public boolean checkLength() {
        if(this.pw.length() >= 8 && this.pw.length() <= 25) {
            return true;
        }
        return false;
    }

    public boolean checkLetters() {
        char[] letters = this.pw.toCharArray();
        boolean small = false;
        boolean capital = false;

        for (int i = 0; i < letters.length; i++) {
            if(letters[i] <= 122 && letters[i] >= 97){
                small = true;
            }

            if(letters[i] <= 90 && letters[i] >= 65){
                capital = true;
            }

            if (small == true && capital == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkNumbersInside() {
        char[] numbers = this.pw.toCharArray();

        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] <= 57 && numbers[i] >= 49){
                return true;
            }
        }
        return false;
    }

    public boolean checkSepcialsigns(){
        return textPatternSpecialsigns.matcher(this.pw).find();
    }


}

