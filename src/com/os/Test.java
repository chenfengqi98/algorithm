package com.os;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author chen
 * @date 2022/2/15
 */
public class Test {
    public static void main(String[] args) {
//        BigDecimal bigDecimal = new BigDecimal("13000.9442001").setScale(6, RoundingMode.HALF_UP);
//        BigDecimal bigDecimal1 = bigDecimal.multiply(new BigDecimal(3))
//                .setScale(2, RoundingMode.HALF_UP);
//        System.out.println(bigDecimal1);
//        System.out.println(bigDecimal.toString());
//        System.out.println(bigDecimal.toPlainString());
//        System.out.println(bigDecimal.stripTrailingZeros());
//        String se = null;
//        System.out.println(se + "123");
//
//        Optional<Object> empty = Optional.empty();
//        se = "123";
//        if ("1".equals(se)) {
//            empty = Optional.of(se);
//        }
//        System.out.println(empty.isPresent());
        String sql = "(  ( legal_entity_code in  ( 'ELC20031217HCH94W' )  )  and  ( client_code in  ( 'C2112221IC173SW','C2111261CZL4LQ8','C220107Z2THU68' )  )  )";
        String[] ands = sql.split("and");
        for (String and : ands) {
            String[] ins = and.split("in");
            for (String in : ins) {
                String replace = in.replace("(", "").replace(")", "");
                System.out.println(replace);
            }
        }
    }
}
