package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        int num = 0;
        for (Character item : s.toCharArray()) {
            if (Character.isDigit(item)) {
                num++;
            }
        }
        return s.length() - num < num;
    }
}
