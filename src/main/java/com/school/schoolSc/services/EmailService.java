package com.school.schoolSc.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
  void sendSimpleMailMessage(String name, String to, String token);
  void sendMimeMessageWithAttachments(String name, String to, String token);
  void sendMimeMessageWithEmbbedImages(String name, String to, String token);
  void sendMimeMessageWithEmbbedFiles(String name, String to, String token);
  void sendHtmlEmail(String name, String to, String token);

  void sendHtmlEmailWithEmbbedFiles(String name, String to, String token);

}
