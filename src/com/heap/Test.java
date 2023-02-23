package com.heap;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author chen
 * @date 2022/11/8
 */
public class Test {
    public static void main(String[] args) {
        List<String> strings = List.of("1213");
        String collect = strings.stream().filter(String::isBlank).collect(Collectors.joining(","));
        System.out.println(collect);

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, "123");
        Object o = objectObjectHashMap.get(null);
        System.out.println(Objects.isNull(o));
    }

    public static String sign1(){
        String params = "{\"BillType\":\"0\",\"DeductibleMode\":\"-1\",\"InvoiceList\":[{\"InvoiceCode\":\"3300221130\",\"InvoiceNumber\":\"00332007\",\"ValidTax\":\"5517.520000\"}],\"Period\":\"202211\"}";
        return "";
    }
}
