package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

@Service
public class EmailService {
    
    private final JavaMailSender emailSender;
    
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    
    public void notificarNuevaCiudad(String nombreCiudad) {
    	SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(TextHelper.EMAIL_RECIPIENT);
        mensaje.setSubject(TextHelper.EMAIL_SUBJECT);
        mensaje.setText(TextHelper.buildEmailBody(nombreCiudad));
        
        emailSender.send(mensaje);
    }
}