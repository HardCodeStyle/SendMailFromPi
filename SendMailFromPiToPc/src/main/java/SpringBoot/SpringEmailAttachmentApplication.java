package SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailAttachmentApplication {

    @Autowired
    private EmailSenderService emailSenderService;
    public static void main(String[] args) {
        SpringApplication.run(SpringEmailAttachmentApplication.class,args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public  void triggerEmail() throws MessagingException {
        emailSenderService.sendMailWithAttachment("julienhenning00@gmail.com","This ist test", "TEST","Users\\jbdim\\Documents\\Links_Für_Projekt_Raspi_Wichtig_Nicht_Löschen.txt");
    }
}
