package com.nogran.app.dietas.api.domain.service.impl;

import com.nogran.app.dietas.api.domain.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

  @Autowired
  private JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String sender;

  public String send(String receiver, String subject, String message) {

    try {
      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setFrom(sender);
      simpleMailMessage.setTo(receiver);
      simpleMailMessage.setSubject(subject);
      simpleMailMessage.setText(message);
      javaMailSender.send(simpleMailMessage);
      return "Email enviado";
    } catch (Exception e) {
      return "Erro ao tentar enviar email " + e.getLocalizedMessage();
    }
  }
}
