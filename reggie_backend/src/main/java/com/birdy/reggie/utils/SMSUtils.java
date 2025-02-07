package com.birdy.reggie.utils;

import com.aliyun.teaopenapi.models.Config;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;

/**
 * 短信发送工具类
 */
public class SMSUtils {

	public static Client createClient() throws Exception {
		Config config = new Config()
				.setAccessKeyId(System.getenv("Reggie_SMS_ACCESS_KEY_ID"))
				.setAccessKeySecret(System.getenv("Reggie_SMS_ACCESS_KEY_SECRET"));

		// 配置 Endpoint
		config.endpoint = "dysmsapi.aliyuncs.com";

		return new Client(config);
	}

	/**
	 * 发送短信
	 * @param signName 签名
	 * @param templateCode 模板
	 * @param phoneNumbers 手机号
	 * @param param 参数
	 */
	public static void sendMessage(String signName, String templateCode,String phoneNumbers,String param) throws Exception {
		Client client = SMSUtils.createClient();

		SendSmsRequest request = new SendSmsRequest();
		request.setPhoneNumbers(phoneNumbers);
		request.setSignName(signName);
		request.setTemplateCode(templateCode);
		request.setTemplateParam("{\"code\":\""+param+"\"}");
		try {
			SendSmsResponse response = client.sendSms(request);
			System.out.println("短信发送成功");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
