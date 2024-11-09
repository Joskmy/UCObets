package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.notificationservice;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    private final JavaMailSender emailSender;
    
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    
    public void notificarNuevaCiudad(String nombreCiudad) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo("jmposadao22@gmail.com");
        mensaje.setSubject("Nueva Ciudad Registrada en UCOBet");
        mensaje.setText("Se ha registrado exitosamente la ciudad: " + nombreCiudad + " en el sistema.");
        
        emailSender.send(mensaje);
    }
}