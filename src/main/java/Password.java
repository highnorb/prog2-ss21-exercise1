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

    //REGEX-Patterns for Task 4.
    public final Pattern textPatternSpecialsignsGood = Pattern.compile("[()#$?!%/@]");
    public final Pattern textPatternSpecialsignsBad = Pattern.compile("[-§&=`´+*~'{}²³_.:,;µ|<>€]");
    public final Pattern textPatternNumberline = Pattern.compile("123|234|345|456|567|678|789|890|012");
    public final Pattern textPatternUnitynumberline = Pattern.compile("1111|2222|3333|4444|5555|6666|7777|8888|9999|0000");


    //If pattern finds signs --> true
    public boolean checkSpecialsignsGood(){
        return textPatternSpecialsignsGood.matcher(this.pw).find();
    }

    //if pattern finds signs is true, return false. Else, return true.
    public boolean checkSpecialsignsBad(){
        if(textPatternSpecialsignsBad.matcher(this.pw).find()){
            return false;
        }
        return true;
    }

    public boolean checkNumberline(){
        if(textPatternNumberline.matcher(this.pw).find()){
            return false;
        }
        return true;
    }

    public boolean checkUnitynumberline() {
        if(textPatternUnitynumberline.matcher(this.pw).find()){
            return false;
        }
        return true;
    }

}

