package cn.yzstu.common.utils.email;

import cn.yzstu.common.utils.Configration;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2019/12/16
 * \* Time: 16:22
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class EmailUtil {

    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    // 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
    public static String myEmailAccount = Configration.getInstance("config").getValue("mail.auth.name");

    public static String myEmailPassword = Configration.getInstance("config").getValue("mail.auth.password");

    // 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
    // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
    public static String myEmailSMTPHost = Configration.getInstance("config").getValue("mail.host");
    //端口
    public static int myEmailSMTPPort = Integer.valueOf(Configration.getInstance("config").getValue("mail.smtp.port"));
    //chartset
    public static String myEmailCharset = Configration.getInstance("config").getValue("mail.send.charset");


    /**
     * spring方式发送
     *
     * @param content
     * @param addr
     */
    private void sendByAdds(String content, String title, String addr[]) {
        // 创建邮件发送服务器
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(myEmailSMTPHost);
        mailSender.setPort(myEmailSMTPPort);
        mailSender.setUsername(myEmailAccount);
        mailSender.setPassword(myEmailPassword);
        mailSender.setDefaultEncoding(myEmailCharset);
        // 加认证机制
        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", "true");// 开启认证
        javaMailProperties.setProperty("mail.debug", "true");// 启用调试
        javaMailProperties.setProperty("mail.smtp.timeout", "1000");// 设置链接超时
        javaMailProperties.setProperty("mail.smtp.port", Integer.toString(myEmailSMTPPort));// 设置端口
        javaMailProperties.setProperty("mail.smtp.socketFactory.port", Integer.toString(myEmailSMTPPort));// 设置ssl端口
        javaMailProperties.setProperty("mail.smtp.socketFactory.fallback", "false");
        javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        mailSender.setJavaMailProperties(javaMailProperties);
        // 创建邮件内容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(myEmailAccount);

        for (int i = 0; i < addr.length; i++) {
            String email = addr[i];
            message.setTo(email);
            message.setSubject(title);
            message.setText(content);
            // 发送邮件
            mailSender.send(message);
        }

    }

    public static void sendEmail(String content, String title, String addr[]) {
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", myEmailSMTPHost);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.port", "465");
        // 发件人的账号
        props.put("mail.user", myEmailAccount);
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", myEmailPassword);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // mailSession.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {

            for (int j = 0; j < addr.length; j++) {
                // 设置发件人
                InternetAddress from = new InternetAddress(myEmailAccount);
                message.setFrom(from);
                // Address[] a = new Address[1];
                // a[0] = new InternetAddress("***");
                // message.setReplyTo(a);
                // 设置收件人
                InternetAddress to = new InternetAddress(addr[j]);
                message.setRecipient(MimeMessage.RecipientType.TO, to);
                // 设置邮件标题
                message.setSubject(title);
                // 设置邮件的内容体
                message.setContent(content, "text/html;charset=UTF-8");
                // 发送邮件
                Transport.send(message);
            }

        } catch (MessagingException e) {
            e.printStackTrace();
            // 在这里处理message内容， 格式是固定的
            System.out.println(e.getMessage());
        }
    }


    /**
     * 发送单个邮箱
     *
     * @param content
     * @param title
     * @param addr
     */

    public static void sendEmail(String content, String title, String addr) throws SendFailedException {
        String[] sendTo = new String[2];
        sendTo[0] = addr;
        sendTo[1] = myEmailAccount;
        sendEmail(content, title, sendTo);
    }
    /*public static void sendEmail(String content, String title, String addr) throws SendFailedException{
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", myEmailSMTPHost);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.port", "465");
        // 发件人的账号
        props.put("mail.user", myEmailAccount);
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", myEmailPassword);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // mailSession.setDebug(true);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        try {
                // 设置发件人
                InternetAddress from = new InternetAddress(myEmailAccount);
                message.setFrom(from);
                // Address[] a = new Address[1];
                // a[0] = new InternetAddress("***");
                // message.setReplyTo(a);
                // 设置收件人
                InternetAddress to = new InternetAddress(addr);
                message.setRecipient(MimeMessage.RecipientType.TO, to);
                // 设置邮件标题
                message.setSubject(title);
                // 设置邮件的内容体
                message.setContent(content, "text/html;charset=UTF-8");
                // 发送邮件
                Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
            // 在这里处理message内容， 格式是固定的
            System.out.println(e.getMessage());
        }
    }*/
}