
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class BangChuDonCode {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomKey() {
        char[] key = ALPHABET.toCharArray();
        Random random = new Random();

        for (int i = key.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Đổi chỗ các ký tự
            char temp = key[i];
            key[i] = key[index];
            key[index] = temp;
        }
        return new String(key);
    }

    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        plainText = plainText.toLowerCase(); // Chuyển đổi về chữ thường

        for (char character : plainText.toCharArray()) {
            if (Character.isLetter(character)) {
                int index = ALPHABET.indexOf(character);
                cipherText.append(key.charAt(index));
            } else {
                cipherText.append(character); // Giữ nguyên các ký tự không phải chữ
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();
        cipherText = cipherText.toLowerCase(); // Chuyển đổi về chữ thường

        for (char character : cipherText.toCharArray()) {
            if (Character.isLetter(character)) {
                int index = key.indexOf(character);
                plainText.append(ALPHABET.charAt(index));
            } else {
                plainText.append(character); // Giữ nguyên các ký tự không phải chữ
            }
        }
        return plainText.toString();
    }
}