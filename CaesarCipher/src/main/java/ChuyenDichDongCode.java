
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class ChuyenDichDongCode {
    // Hàm mã hóa văn bản
    public static String encrypt(String plainText, String key) {
        // Xử lý khóa để xác định thứ tự
        int[] keyOrder = createKeyOrder(key);
        int numRows = (int) Math.ceil((double) plainText.length() / key.length());
        char[][] matrix = new char[numRows][key.length()];

        // Điền vào ma trận với ký tự từ văn bản gốc
        for (int i = 0; i < plainText.length(); i++) {
            matrix[i / key.length()][i % key.length()] = plainText.charAt(i);
        }

        // Mã hóa: đọc ký tự theo cột theo thứ tự khóa
        StringBuilder cipherText = new StringBuilder();
        for (int k : keyOrder) {
            for (int i = 0; i < numRows; i++) {
                if (matrix[i][k] != '\0') {
                    cipherText.append(matrix[i][k]);
                }
            }
        }
        return cipherText.toString();
    }

    // Hàm giải mã văn bản
    public static String decrypt(String cipherText, String key) {
        int[] keyOrder = createKeyOrder(key);
        int numRows = (int) Math.ceil((double) cipherText.length() / key.length());
        char[][] matrix = new char[numRows][key.length()];

        // Tính số ký tự theo thứ tự để điền vào ma trận
        int index = 0;
        for (int k : keyOrder) {
            for (int i = 0; i < numRows; i++) {
                if (index < cipherText.length()) {
                    matrix[i][k] = cipherText.charAt(index++);
                }
            }
        }

        // Đọc lại văn bản từ ma trận
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (matrix[i][j] != '\0') {
                    plainText.append(matrix[i][j]);
                }
            }
        }
        return plainText.toString();
    }

    // Tạo thứ tự từ khóa
    private static int[] createKeyOrder(String key) {
        Integer[] keyIndices = new Integer[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyIndices[i] = i;
        }

        Arrays.sort(keyIndices, (i1, i2) -> Character.compare(key.charAt(i1), key.charAt(i2)));

        int[] order = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            order[i] = keyIndices[i];
        }
        return order;
    }

}
