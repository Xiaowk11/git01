package com.xxxx.springboot.utils;

import com.xxxx.springboot.exceptions.ParamsException;

public class AssertUtil {


    public  static void isTrue(Boolean flag,String msg) throws ParamsException {
        if(flag){
            throw  new ParamsException(msg);
        }
    }

}
