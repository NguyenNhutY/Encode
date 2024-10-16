
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class VegenerCode {
    public static String encrypt(String plainText, String key) {
        StringBuilder cipherText = new StringBuilder();
        plainText = plainText.toUpperCase();
        key = key.toUpperCase();

        int keyLength = key.length();
        int j = 0; // Chỉ số cho khóa

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);

            // Kiểm tra xem ký tự có phải là chữ cái không
            if (Character.isLetter(c)) {
                // Tính chỉ số mã hóa
                char encryptedChar = (char) (((c + key.charAt(j) - 2 * 'A') % 26) + 'A');
                cipherText.append(encryptedChar);
                j = (j + 1) % keyLength; // Chuyển sang ký tự tiếp theo trong khóa
            } else {
                cipherText.append(c); // Giữ nguyên ký tự không phải chữ cái
            }
        }

        return cipherText.toString();
    }

    // Hàm giải mã văn bản
    public static String decrypt(String cipherText, String key) {
        StringBuilder plainText = new StringBuilder();
        cipherText = cipherText.toUpperCase();
        key = key.toUpperCase();

        int keyLength = key.length();
        int j = 0; // Chỉ số cho khóa

        for (int i = 0; i < cipherText.length(); i++) {
            char c = cipherText.charAt(i);

            // Kiểm tra xem ký tự có phải là chữ cái không
            if (Character.isLetter(c)) {
                // Tính chỉ số giải mã
                char decryptedChar = (char) (((c - key.charAt(j) + 26) % 26) + 'A');
                plainText.append(decryptedChar);
                j = (j + 1) % keyLength; // Chuyển sang ký tự tiếp theo trong khóa
            } else {
                plainText.append(c); // Giữ nguyên ký tự không phải chữ cái
            }
        }

        return plainText.toString();
    }

    // Hàm tạo khóa ngẫu nhiên có độ dài nhất định
    public static String generateRandomKey(int length) {
        StringBuilder key = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // Tạo ký tự ngẫu nhiên từ A-Z
            char randomChar = (char) ('A' + random.nextInt(26));
            key.append(randomChar);
        }

        return key.toString();
    }
}
