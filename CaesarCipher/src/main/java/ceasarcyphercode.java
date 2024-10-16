/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class ceasarcyphercode {

    // Hàm mã hóa Caesar
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Mã hóa ký tự hoa (A-Z)
            if (Character.isUpperCase(c)) {
                char encryptedChar = (char) (((int) c + shift - 65) % 26 + 65);
                result.append(encryptedChar);
            }
            // Mã hóa ký tự thường (a-z)
            else if (Character.isLowerCase(c)) {
                char encryptedChar = (char) (((int) c + shift - 97) % 26 + 97);
                result.append(encryptedChar);
            } else {
                // Giữ nguyên ký tự không phải chữ
                result.append(c);
            }
        }

        return result.toString();
    }

    // Hàm giải mã Caesar
    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);  // Shift ngược lại để giải mã
    }
}
