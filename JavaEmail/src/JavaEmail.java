/**
 * Created by xyfhy on 15/11/5.
 */



import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//JavaMail 发送邮件
public class JavaEmail {

    public static void main(String[] args) throws AddressException, MessagingException {


        SendMail sendMail = new SendMail();
        sendMail.setSmtpServer("smtp.idrilling.cn");
        //此处设置登录的用户名
        sendMail.setUsername("rjt@idrilling.cn");
        //此处设置登录的密码
        sendMail.setPassword("idrilling2015!");
        //设置收件人的地址
        sendMail.setTo("lichen@idrilling.cn");
        //设置发送人地址
        sendMail.setFrom("rjt@idrilling.cn");
        //设置标题
        sendMail.setSubject("测试邮件标题！");
        //设置内容
        sendMail.setContent("你好这是一个带多附件的测试邮件！");
        //粘贴附件
//        sendMail.attachfile("C:/Login6 (1).jpg");
        if (sendMail.send())
        {
            System.out.println("---邮件发送成功---");
        }



    }
}
