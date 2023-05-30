package com.example.demo;

import cn.hutool.crypto.digest.DigestUtil;
import com.example.demo.constant.PayConstants;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PayDemoApplicationTests {

    @Test
    void contextLoads() {
        String sign = DigestUtil.md5Hex("1681778094996" + "vone666" + 1 + "0.1" + PayConstants.PAY_SECRET_KEY);
        System.out.println("sign===" +sign);
    }
}
