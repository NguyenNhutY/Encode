package d22_doanmahoa;

import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;

public class RC4 extends javax.swing.JFrame {

    public RC4() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        key = new javax.swing.JLabel();
        key1 = new javax.swing.JLabel();
        keymahoa = new javax.swing.JTextField();
        keygiaima = new javax.swing.JTextField();
        encryption = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        plaintext = new javax.swing.JTextArea();
        decryption = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ciphertext = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DO AN RC4");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setName(""); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Encoding");

        key.setBackground(new java.awt.Color(255, 255, 255));
        key.setText("Key");

        key1.setBackground(new java.awt.Color(255, 255, 255));
        key1.setText("Key");

        keymahoa.setBackground(new java.awt.Color(204, 204, 204));

        keygiaima.setBackground(new java.awt.Color(204, 204, 204));

        encryption.setText("Encryption");
        encryption.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionActionPerformed(evt);
            }
        });

        plaintext.setBackground(new java.awt.Color(204, 204, 204));
        plaintext.setColumns(20);
        plaintext.setRows(5);
        jScrollPane1.setViewportView(plaintext);

        decryption.setText("Decryption");
        decryption.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionActionPerformed(evt);
            }
        });

        ciphertext.setBackground(new java.awt.Color(204, 204, 204));
        ciphertext.setColumns(20);
        ciphertext.setRows(5);
        jScrollPane2.setViewportView(ciphertext);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Plain text");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(key1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keygiaima, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(decryption, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(keymahoa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(encryption, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(key)
                            .addComponent(keymahoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(encryption)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(key1)
                            .addComponent(keygiaima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(decryption)))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    private int[] Sbox(String key) {
        byte[] T = key.getBytes();  // Chuyển chuỗi key thành mảng byte
        int[] s = new int[256];
        int j = 0;
        
        
        // Khởi tạo mảng S với các giá trị từ 0 đến 255
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        
        
        // Hoán vị các giá trị trong S dựa trên key
        for (int i = 0; i < 256; i++) {
            j = (j + s[i] + T[i % T.length]) % 256;
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return s;
    }
    private void encryptionActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String text = plaintext.getText(); // Nhập văn bản cần mã hóa
        String khoa = keymahoa.getText();  // Nhập khóa
        int i = 0, j = 0;
        int[] s = Sbox(khoa);  // Tạo mảng hoán vị S từ khóa
        byte[] cipher = new byte[text.length()]; // Mảng để lưu trữ ciphertext
        // Thực hiện mã hóa RC4
        for (int k = 0; k < text.length(); k++) {
            i = (i + 1) % 256; // Cập nhật chỉ số i
            j = (j + s[i]) % 256;// Cập nhật chỉ số j
            
            // Hoán vị các giá trị trong mảng S
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            // Tạo keystream và mã hóa bằng XOR
            int d = (s[i] + s[j]) % 256;
            cipher[k] = (byte) (s[d] ^ text.charAt(k));
        }
        
        // Chuyển đổi mảng byte ciphertext thành chuỗi Hex
        StringBuilder hexString = new StringBuilder();
        for (byte b : cipher) {
            hexString.append(String.format("%02X", b));  // Định dạng từng byte thành hex
        }
        
        // Hiển thị ciphertext trên giao diện
        JOptionPane.showMessageDialog(this, "Mã hóa RC4 thành công: " + hexString.toString());
    }                                          

    public static byte[] hexStringToByteArray(String hex) {
    int length = hex.length();
    byte[] result = new byte[length / 2];
    for (int i = 0; i < length; i += 2) {
        result[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                             + Character.digit(hex.charAt(i+1), 16));
    }
    return result;
}
    private void decryptionActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String cipher = ciphertext.getText(); // Nhập ciphertext
        String khoa = keygiaima.getText(); // Nhập khóa
        int i = 0, j = 0;
        int[] s = Sbox(khoa); // Tạo mảng hoán vị S
        byte[] text = new byte[cipher.length()]; // Mảng byte để lưu trữ plaintext
        
        
        // Chuyển đổi chuỗi cipher thành mảng byte
        byte[] cipherBytes = new byte[cipher.length()];
        cipherBytes = hexStringToByteArray(cipher);
//        for (int k = 0; k < cipher.length(); k++) {
//        cipherBytes[k] = (byte) cipher.charAt(k); // Chuyển đổi ký tự thành byte
//        }
        
        
        // Thực hiện giải mã RC4
        for (int k = 0; k < cipherBytes.length; k++) {
            i = (i + 1) % 256;
            j = (j + s[i]) % 256;
            
            
            // Hoán vị
            int temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            
            
             // Tạo keystream và giải mã
            int d = (s[i] + s[j]) % 256;
            text[k] = (byte) (s[d] ^ cipherBytes[k]);
        }
        // Chuyển đổi mảng byte thành chuỗi
        String result = new String(text, StandardCharsets.UTF_8);
        
        // Hiển thị kết quả giải mã lên giao diện
        JOptionPane.showMessageDialog(this, "Giải mã RC4 thành công: " + result);
    }                                          

    public static void main(String args[]) {
        new RC4().setVisible(true);
    }                   
    private javax.swing.JTextArea ciphertext;
    private javax.swing.JButton decryption;
    private javax.swing.JButton encryption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel key;
    private javax.swing.JLabel key1;
    private javax.swing.JTextField keygiaima;
    private javax.swing.JTextField keymahoa;
    private javax.swing.JTextArea plaintext;                
}