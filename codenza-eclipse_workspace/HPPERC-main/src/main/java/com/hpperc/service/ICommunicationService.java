package com.hpperc.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.hpperc.model.User;

public interface ICommunicationService {

	void sendEmailWithMessageToUser(User user,String subject,String message) throws UnsupportedEncodingException, MessagingException;
}
