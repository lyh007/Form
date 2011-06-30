package com.form.util;

import java.util.UUID;

/**
 * REF Number Generate Tool Class
 * From UUID
 */
public class REFNumberUtil {
    /**
     * Generate REF number From  UUID front ten character
     * @return
     */
    public static String GenerateREFNumber() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").substring(0,10);
    }

    public static void main(String[] args) {
        System.out.println(GenerateREFNumber());
    }
}
