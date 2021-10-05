package com.laptrinhjavaweb.devicecontrol.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

@Component
public class CustomCodeUtils {
    public static String customCode(String s) {
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        int index = random.nextInt(lexicon.length());

        CustomCodeUtils utils = new CustomCodeUtils();
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        temp = utils.removeAccent(temp.replace(" ", "-"));
        temp = temp.replaceAll("đ", "d");
        return  temp + lexicon.charAt(index);
    }

    public String removeAccent(String name) {
        name.toLowerCase();
        name.trim();
        return name.toLowerCase();
    }

    private static String getCode(String data){
        final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        int index = random.nextInt(lexicon.length());
        data += lexicon.charAt(index);
        byte[] encodedBytes = Base64.encodeBase64(data.getBytes());
        return new String(encodedBytes) + lexicon.charAt(index);
    }
}
