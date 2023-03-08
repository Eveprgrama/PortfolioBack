
package com.eve.programacion.controller;
import com.eve.programacion.entity.ContactForm;
import com.eve.programacion.service.EmailService;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontendevelynp.web.app")
@RequestMapping("contacto")
public class ContactController {
  @Autowired
  private EmailService emailService;


  @PostMapping(value = "/email")
  public ResponseEntity<Object> enviarEmail(@RequestBody ContactForm email){
    try {
      emailService.sendEmail(email);
      return new ResponseEntity<>(email, HttpStatus.OK);
    } catch( MailException e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }


  }
}
