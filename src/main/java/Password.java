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


    public Boolean checkLength() {
        if(this.pw.length() >= 8 && this.pw.length() <= 25) {
            return true;
        }
        return false;
    }

    public Boolean checkLetters() {
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
}

