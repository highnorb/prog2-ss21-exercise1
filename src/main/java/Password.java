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
        return false;
    }
}

