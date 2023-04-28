package tn.esprit.picloundomicsgestionagriculteur.AOP;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;
import tn.esprit.picloundomicsgestionagriculteur.Repository.UserRepo.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
@Aspect //instance du log
public class AspectRec  {



    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(AspectRec.class);
    @After("execution(* tn.esprit.picloundomicsgestionagriculteur.Service.ReclamationServices.ReclamationServiceImplementation.addReclamationParUser(..)) //&& args(reclamation,..)")
    public void sendNotificationEmails(JoinPoint joinPoint){//} Reclamation  reclamation) {
        String name = joinPoint.getSignature().getName();
        logger.info("Accessing Reclamation entity method: "+name+"();");
/*
        List<String> clientEmails = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            clientEmails.add(user.getEmail());
        }

        for (String clientEmail : clientEmails) {
            sendNotificationEmail(clientEmail, reclamation);
        }*/
    }

    public void sendNotificationEmail(String email, Reclamation reclamation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("Alaa.hamdi@esprit.tn");
        message.setTo(email);
        message.setSubject("Votre réclamation a été ajoutée avec succès");
        message.setText("Bonjour,\n\nNous vous informons que votre réclamation a été ajoutée avec succès.\n\nDétails de la réclamation:"
                + "\nID : " + reclamation.getIdReclamation() + "\nDate : " + reclamation.getDateRec()
                + "\n\nMerci de votre confiance.\n\nCordialement,\nL'équipe de notre site");
        javaMailSender.send(message);
    }
}