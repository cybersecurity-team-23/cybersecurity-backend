package rs.ac.uns.ftn.BookingBaboon.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;

public class HIBP {
    private final static String endPoint = "https://api.pwnedpasswords.com/range/";

    public static Boolean isPasswordBlacklisted(String password) throws NoSuchAlgorithmException, IOException {
        String hashedPassword = hashPassword(password);
        ArrayList<String> blacklistedPasswords = getBlacklistedPasswords(hashedPassword);
        return isOnTheBlacklistedList(hashedPassword, blacklistedPasswords);
    }

    private static ArrayList<String> getBlacklistedPasswords(String hashedPassword) throws IOException {
        String prefix = hashedPassword.substring(0, 5);
        URL url = new URL(endPoint + prefix);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) throw new RuntimeException("HIBP check failed");

        // read passwords
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        ArrayList<String> passwordList = new ArrayList<>();
        while ((inputLine = in.readLine()) != null) {
            String suffix = inputLine.substring(0, 35);
            passwordList.add(prefix+suffix);
        }

        conn.disconnect();
        return passwordList;
    }

    private static Boolean isOnTheBlacklistedList(String hashedPassword, ArrayList<String> blacklistedPasswords) {
        int index = Collections.binarySearch(blacklistedPasswords, hashedPassword);
        if (index < 0) return false;
        return true;
    }

    private static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return sb.toString().toUpperCase();
    }
}
