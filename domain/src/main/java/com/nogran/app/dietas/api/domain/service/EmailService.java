package com.nogran.app.dietas.api.domain.service;

public interface EmailService {

  String send(String destinatario, String assunto, String mensagem);

}
