package util;


public class RetiraCaracter {

    public String retiraChar(String digitado) {
        String Result = "";

        for (int i = 0; i < digitado.length(); i++) {
            for (Integer j = 0; j < 10; j++) {

                if (("" + digitado.charAt(i)).equals(("" + j))) {
                    Result += digitado.charAt(i);
                }
            }
        }
        return Result;
    }
}
