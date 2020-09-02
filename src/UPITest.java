//import javax.crypto.Cipher;
//import java.io.*;
//import java.net.Socket;
//import java.security.Key;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.security.interfaces.RSAPublicKey;
//
//public class UPITest {
//    public static void main(String[] args) throws Exception {
//        String certFile = "/Users/manish4.patel/Documents/UPI/Publickey_test01/Reliance_UPI_UAT.cer";
//        InputStream inStream = new FileInputStream(certFile);
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
//        inStream.close();
//// Read the public key from certificate file
//        Key pubkey = (RSAPublicKey) cert.getPublicKey();
//// System.out.println("Certficate public key " +pubkey);
//// System.out.println(pubkey.getAlgorithm());
//// Init the Cipher
//        System.out.println("Initialising encryption cipher");
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//        cipher.init(Cipher.ENCRYPT_MODE, pubkey);
//// Converting Pin to bytes
//        byte[] plain = new String("1234").getBytes();
//        byte[] encrypted_pin = cipher.doFinal(plain);
//// Loading private key file
//        String privateKey = "";
//        String PrivatekeyFile = "/Users/manish4.patel/Documents/UPI/Private_Key_July_18.txt";
//        BufferedReader br = new BufferedReader(new FileReader(PrivatekeyFile));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//            while (line != null) {
//                sb.append(line);
//                line = br.readLine();
//            }
//            privateKey = sb.toString();
//        } finally {
//            br.close();
//        }
//// Decoded Private Key from Hex
//        byte[] hsmPvtKey = Hex.decodeHex(privateKey.toCharArray());
//// For KeyBlock LMK the private key length should be set to FFFF
//        byte[] bytes = Hex.decodeHex(privateKey.toCharArray());
//        System.out.println("Bytes--->" + bytes.length);
//// For Variant LMK the private key length Calcuated as follows
//// For KeyBlock LMK the private key length should be set to FFFF
//// String hsmPrvLen = "FFFF";
//        String hsmPrvLen = Integer.toString(bytes.length);// "0656";
//        String concString = "0";
//        hsmPrvLen = concString.concat(hsmPrvLen);
//// For testing purpose, the Account Number is hardcoded
//        String accountNumber = "000501612485";
//// KeyType should 3400 for Variant LMK and FFFF for KeyBlockLMK
//        String KeyType = "3400";
//// Construction initial part of command
//        String SACommandPart1 = ("...." + "SA" + accountNumber + "A" + "01" + "01" + KeyType + "0256");
//        String SACommandPart2 = (";" + "99" + hsmPrvLen);
//        ByteArrayOutputStream SACmdstream = new ByteArrayOutputStream();
//        SACmdstream.write(SACommandPart1.getBytes());
//        SACmdstream.write(encrypted_pin);
//        SACmdstream.write(SACommandPart2.getBytes());
//        SACmdstream.write(hsmPvtKey);
//        byte[] SACommand = SACmdstream.toByteArray();
//// Encrypt the PIN under LMK
//        String result;
//        result = commandResult(SACommand);
//        SACmdstream.close();
//        int rIndex = result.indexOf("SB");
//        if (rIndex > 0) {
//            if (!result.substring(rIndex + 2, rIndex + 2 + 2).equals("00")) {
//                System.out.println("SB command failed");
//                System.exit(-1);
//            }
//        } else {
//            System.out.println("Unexpected Error");
//            System.exit(-1);
//        }
//        String lmkEncryptedPin = result.substring(10, result.length());
//// Change accountNumber = "444653429561" to fail the PIN verfication;
//// Verify the PIN
//        String SCCommandPart1 = ("...." + "SC" + accountNumber + lmkEncryptedPin + "A" + "01" + "01" + KeyType + "0256");
//        String SCCommandPart2 = (";" + "99" + hsmPrvLen);
//        ByteArrayOutputStream SCCmdstream = new ByteArrayOutputStream();
//        SCCmdstream.write(SCCommandPart1.getBytes());
//        SCCmdstream.write(encrypted_pin);
//        SCCmdstream.write(SCCommandPart2.getBytes());
//        SCCmdstream.write(hsmPvtKey);
//        byte[] SCCommand = SCCmdstream.toByteArray();
//        result = commandResult(SCCommand);
//        SCCmdstream.close();
//        rIndex = result.indexOf("SD");
//        if (rIndex > 0) {
//            if (result.substring(rIndex + 2, result.length()).equals("00"))
//                System.out.println("PIN verified successfully....");
//            else
//                System.out.println("PIN verification failed...");
//        } else
//            System.out.println("Unexpected Error");
//    }
//    public static String ByteArrayToString(byte[] ba) {
//        StringBuilder hex = new StringBuilder(ba.length * 2);
//        for (byte b : ba)
//            hex.append(String.format("%02x", b));
//        return hex.toString();
//    }
//    private static String readData(BufferedInputStream in) throws IOException {
//        int i = in.read();
//        StringBuffer dataGot = new StringBuffer();
//        if (i != -1) {
//// System.out.println("Got 1 char : "+(char)i);
//            dataGot.append((char) i);
//            int l = in.available();
//            if (l > 0) {
//                byte[] byteData = new byte[l];
//                in.read(byteData);
//                dataGot.append(new String(byteData));
//            }
//            return dataGot.toString();
//        } else {
//            return null;
//        }
//    }
//    private static String commandResult(byte[] cmd) throws IOException {
//// Socket connection to payShield
//        Socket socket = new Socket("10.140.139.37", 1500);
//        System.out.println("Connected!");
//        ByteArrayOutputStream outstream = new ByteArrayOutputStream();
//        BufferedInputStream in = new BufferedInputStream(
//                socket.getInputStream());
//        BufferedOutputStream out = new BufferedOutputStream(
//                socket.getOutputStream());
//        int ln = cmd.length;
//        int h = 0, l = 0, t = 256;
//        h = ln / t;
//        l = ln % t;
//        byte[] tmp = new byte[2];
//        tmp[0] = (byte) h;
//        tmp[1] = (byte) l;
//        outstream.write(tmp);
//        outstream.write(cmd);
//        byte[] total = outstream.toByteArray();
//// Sending data to HSM
//        out.write(total);
//        out.flush();
//        outstream.close();
//// ****************************************************
//        System.out.println("Data Sent.. Waiting for response.. ");
//        String data = "";
//        data = readData(in);
//        socket.close();
//        return data;
//    }
//}


import java.util.ArrayList;
import java.util.List;

class test{
    public static void main(String... a){
        List<String> l = new ArrayList<>();
        l.add("hello");
        l.add("hello");
        l.add("hello");
        l.add("hello");
        System.out.println(String.join(",", l));

    }
}