package Control.Validacion;

import Data.Entidad.Proveedor;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlCorreo {

    public boolean EnviarCorreo(String _to) {
        try {
            String to = _to;
            String from = "zald95@outlook.com";
            String host = "smtp.live.com";
            String password = "z25l95**a";
            String subject = "¡Registro querencia!";
            String body = "Deseamos informarle que ha sido registrado satisfactoriamente en el sistema 'La Querencia'";

            Properties properties = System.getProperties();
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.user", from);
            properties.put("mail.smtp.password", password);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress toAdress = new InternetAddress(_to);
            message.addRecipient(Message.RecipientType.TO, toAdress);

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            return true;
        } catch (Exception _e) {
            JOptionPane.showMessageDialog(null, "No se pudo enviar el correo \r Verifica tu conexión a internet", "Mensaje del sistema", JOptionPane.ERROR_MESSAGE);
            System.out.println(_e.getMessage());
            return false;
        }
    }

}
