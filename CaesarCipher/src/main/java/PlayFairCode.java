
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public final class PlayFairCode {
     private char[][] matrix; // Ma trận 5x5 cho Playfair Cipher
    private String key;

    public PlayFairCode(String key) {
        this.key = prepareKey(key);
        this.matrix = generateMatrix(this.key);
    }

    // Chuẩn bị khóa: loại bỏ các ký tự trùng lặp, thay I và J như một ký tự
    String prepareKey(String key) {
        key = key.toUpperCase().replace("J", "I").replaceAll("[^A-Z]", "");
        StringBuilder newKey = new StringBuilder();
        boolean[] seen = new boolean[26];
        for (char c : key.toCharArray()) {
            if (!seen[c - 'A']) {
                newKey.append(c);
                seen[c - 'A'] = true;
            }
        }
        return newKey.toString();
    }

    // Tạo ma trận 5x5 dựa trên khóa
    private char[][] generateMatrix(String key) {
        char[][] matrix = new char[5][5];
        boolean[] seen = new boolean[26];
        int row = 0, col = 0;

        // Thêm các ký tự trong khóa vào ma trận
        for (char c : key.toCharArray()) {
            if (!seen[c - 'A']) {
                matrix[row][col++] = c;
                seen[c - 'A'] = true;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        // Thêm các ký tự còn lại từ A-Z (ngoại trừ J)
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!seen[c - 'A'] && c != 'J') {
                matrix[row][col++] = c;
                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
        return matrix;
    }

      // Hàm lấy ma trận dưới dạng chuỗi để hiển thị
    public String getMatrixAsString() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : matrix) {
            for (char c : row) {
                sb.append(c).append(" "); // Thêm khoảng trắng giữa các ký tự
            }
            sb.append("\n"); // Xuống dòng sau mỗi hàng
        }
        return sb.toString();
    }
    // Hàm mã hóa văn bản
    public String encrypt(String plainText) {
        plainText = prepareText(plainText.toUpperCase());
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i += 2) {
            char a = plainText.charAt(i);
            char b = (i + 1 < plainText.length()) ? plainText.charAt(i + 1) : 'X'; // Thêm 'X' nếu cần

            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) {
                // Cùng hàng
                cipherText.append(matrix[posA[0]][(posA[1] + 1) % 5]);
                cipherText.append(matrix[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) {
                // Cùng cột
                cipherText.append(matrix[(posA[0] + 1) % 5][posA[1]]);
                cipherText.append(matrix[(posB[0] + 1) % 5][posB[1]]);
            } else {
                // Khác hàng và cột (hình chữ nhật)
                cipherText.append(matrix[posA[0]][posB[1]]);
                cipherText.append(matrix[posB[0]][posA[1]]);
            }
        }

        return cipherText.toString();
    }

    // Hàm giải mã văn bản
    public String decrypt(String cipherText) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i += 2) {
            char a = cipherText.charAt(i);
            char b = cipherText.charAt(i + 1);

            int[] posA = findPosition(a);
            int[] posB = findPosition(b);

            if (posA[0] == posB[0]) {
                // Cùng hàng
                plainText.append(matrix[posA[0]][(posA[1] + 4) % 5]);
                plainText.append(matrix[posB[0]][(posB[1] + 4) % 5]);
            } else if (posA[1] == posB[1]) {
                // Cùng cột
                plainText.append(matrix[(posA[0] + 4) % 5][posA[1]]);
                plainText.append(matrix[(posB[0] + 4) % 5][posB[1]]);
            } else {
                // Khác hàng và cột (hình chữ nhật)
                plainText.append(matrix[posA[0]][posB[1]]);
                plainText.append(matrix[posB[0]][posA[1]]);
            }
        }

        return plainText.toString();
    }

    // Tìm vị trí của ký tự trong ma trận
    private int[] findPosition(char c) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrix[row][col] == c) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }

    // Chuẩn bị văn bản: xóa khoảng trắng, ghép thành các cặp, thêm 'X' nếu cần thiết
    private String prepareText(String text) {
        text = text.replaceAll("[^A-Z]", ""); // Loại bỏ ký tự không phải chữ
        StringBuilder preparedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            char b = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X'; // Thêm X nếu cần
            if (a == b) {
                preparedText.append(a).append('X'); // Thêm X nếu hai ký tự trùng nhau
            } else {
                preparedText.append(a).append(b);
                i++;
            }
        }
        if (preparedText.length() % 2 != 0) {
            preparedText.append('X'); // Thêm X nếu số lượng ký tự lẻ
        }
        return preparedText.toString();
    }
}

    
