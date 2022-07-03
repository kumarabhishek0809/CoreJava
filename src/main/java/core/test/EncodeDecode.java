package core.test;

import java.util.Base64;

public class EncodeDecode {
    public static void main(String[] args) {
        String originalInput = "P@ssw0r$";
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("encodedString ::::"+encodedString);


        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println("decodedString ::::"+decodedString);


    }
}
