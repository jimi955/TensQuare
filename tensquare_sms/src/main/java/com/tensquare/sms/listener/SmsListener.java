package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.rabbitmq.client.Channel;
import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Resource
    private SmsUtil smsUtil;

    @RabbitHandler
    public void executeSms(Map<String, String> map, Message message, Channel channel) throws IOException {
        String mobile = map.get("mobile");
        String checkCode = map.get("check_code");
        System.out.println("手机号： " + mobile);
        System.out.println("验证码： " + checkCode);

        // 关闭短信发送 使用邮件替代
//        try {
//            smsUtil.sendSms(mobile, "jimi955", "申请失败！！！", "{\"code\": \"" + checkCode + "\"}");
//        } catch (ClientException e) {
//            e.printStackTrace();
//        }


        // 邮件
        try {
            SimpleMailMessage letter = new SimpleMailMessage();
            //邮件设置
            letter.setSubject("TenSquare注册验证");
            letter.setText("TenSquare提醒您, 您的验证码是：" + checkCode + ",有效时间为一分钟！");
            letter.setTo(mobile + "@163.com");

            letter.setFrom("1652877739@qq.com");
            mailSender.send(letter); // 使用邮件替代
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
        }
    }
}
