package com.example.requestsFromForum.service;

import com.example.requestsFromForum.dto.ClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class EmailSenderService {

    public void sendmail(ClientDTO clientDTO) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("brunobucciarati702@gmail.com", "gkk323212");
            }
        });
        Message msg = new MimeMessage(session);
        Message msgToServer = new MimeMessage(session);

        //ОТ КОГО
        msg.setFrom(new InternetAddress("MSD", false));
        msgToServer.setFrom(new InternetAddress("MSDServer", false));

        //Ввести почту получателя и компании
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(clientDTO.getMail()));
        msgToServer.setRecipients(Message.RecipientType.TO, InternetAddress.parse("eespatycoop@gmail.com"));

        //Tема Сообщении
        if (clientDTO.getMstroy().equalsIgnoreCase("mstroy")){
            msg.setSubject("Добро пожаловать на MStroy ʕᵔᴥᵔʔ");
        }else if (clientDTO.getMbusiness().equalsIgnoreCase("mbusiness")){
            msg.setSubject("Добро пожаловать на MBusiness ʕᵔᴥᵔʔ");
        }else if (clientDTO.getMlogic().equalsIgnoreCase("mlogic")){
            msg.setSubject("Добро пожаловать на MLogic ʕᵔᴥᵔʔ");
        }else {
            msg.setSubject("Не получиось");
        }

        msg.setContent("Tutorials point email3", "text/html");
        msg.setSentDate(new Date());

        msgToServer.setSubject("Данные от пользователя " + clientDTO.getFirstName() +" "+ clientDTO.getLastName());

        //Письмо для нас
        msgToServer.setContent("Dear " + clientDTO.getFirstName() + ", " + clientDTO.getMail() + " " + clientDTO.getPhoneNumber(), "text/html");
        msgToServer.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        //Письмо
        messageBodyPart.setContent(
                "Hello " + clientDTO.getFirstName() + "!. " +
                        "We are very glad ,that you have joined us.", "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        msg.setContent(multipart);
        Transport.send(msg);

        Transport.send(msgToServer);
    }
}