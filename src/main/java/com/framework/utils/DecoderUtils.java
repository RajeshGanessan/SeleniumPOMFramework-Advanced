package com.framework.utils;

import java.util.Base64;

public class DecoderUtils {

    private DecoderUtils(){

    }

    public static String getDecodeString(String encodedValue){
        return new String(Base64.getDecoder().decode(encodedValue.getBytes()));
    }
}
