package com.birdy.reggie.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Birdy
 * @date 2025/2/7 21:26
 * @description AliyunSMS
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMS {
    private String signName;
    private String templateCode;
}