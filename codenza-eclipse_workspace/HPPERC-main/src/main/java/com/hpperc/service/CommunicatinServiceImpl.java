package com.hpperc.service;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hpperc.model.User;

@Service
public class CommunicatinServiceImpl implements ICommunicationService{

	 
	@Autowired
    private JavaMailSender javaMailSender;
	
	
	@Override
	public void sendEmailWithMessageToUser(User user,String subject, String message) throws UnsupportedEncodingException, MessagingException{
		
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getEmailId());

        //msg.setSubject("Welcome to HPPERC");
        //msg.setText("Registration successful, use below credentials to log into system. \n"+user.getUsername() +"\n" + "Password : " + user.getPassword());
        msg.setSubject(subject);
        msg.setText(message);
        javaMailSender.send(msg);
		
		
	}

}
