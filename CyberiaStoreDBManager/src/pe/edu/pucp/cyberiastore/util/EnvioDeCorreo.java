package pe.edu.pucp.cyberiastore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import java.util.Properties;
import java.util.Date;
import jakarta.mail.Message;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import pe.edu.pucp.cyberiastore.util.Cifrado;

public class EnvioDeCorreo {

    private static final String CONFIGURACION_ENVIO_DE_CORREOS = "envio_de_correos.properties";
    private static final String HTML = "correo_verificacion.html";

    private String emisor = "";
    private String contrasenha = "";
    private String destinatario = "";
    private String smtp_host = "";
    private String puerto = "";
    private String socket = "";
    private String valorToken="";

    private String asunto = "";
    private String cuerpo = "";
    private Properties propiedades;
    private Session sesion;
    private Authenticator autenticador;

    public EnvioDeCorreo() {

    }

    public Boolean enviarCorreoVerificacion(String destinatario, String valorToken) {
        this.destinatario = destinatario;
        this.valorToken = valorToken;
        return this.prepararEnviarCorreo();
    }

    private Boolean prepararEnviarCorreo() {
        this.leerArchConfig();
        this.crearAsunto();
        this.leerArchCuerpo();
        this.agregarPropiedades();
        this.generarAutenticador();
        this.sesion = Session.getInstance(this.propiedades, this.autenticador);
        return this.enviarCorreo();
    }

    private void leerArchConfig() {
        try {

            String rutaArchConfig = "C:\\Program Files\\glassfish7\\glassfish\\resources" + "\\" + CONFIGURACION_ENVIO_DE_CORREOS;

            Properties prop = new Properties();
            prop.load(new FileInputStream(new File(rutaArchConfig)));

            this.emisor = prop.getProperty("emisor");
            this.contrasenha = prop.getProperty("contrasenha");
            this.smtp_host = prop.getProperty("smtp_host");
            this.puerto = prop.getProperty("puerto");
            this.socket = prop.getProperty("socketSSL");

        } catch (FileNotFoundException ex) {
            System.err.println("No se encontro el archivo de propiedades para el envio de correos - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }

    private void crearAsunto() {
        this.asunto = "Verificacion de Correo Electrónico";
    }

    private void leerArchCuerpo() {
        try {

            StringBuilder html = new StringBuilder();
            FileReader fr = new FileReader("C:\\Program Files\\glassfish7\\glassfish\\resources" + "\\" + HTML);

            BufferedReader br = new BufferedReader(fr);

            String val;

            while ((val = br.readLine()) != null) {
                html.append(val);
            }
            this.cuerpo = html.toString().replace("{{token}}", valorToken);
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void agregarPropiedades() {
        this.propiedades = new Properties();
        this.propiedades.put("mail.smtp.host", this.smtp_host);
        this.propiedades.put("mail.smtp.port", this.puerto);
        this.propiedades.put("mail.smtp.socketFactory.class", this.socket);
        this.propiedades.put("mail.smtp.auth", "true");

        this.propiedades.put("mail.smtp.ssl.trust", this.smtp_host);
        this.propiedades.put("mail.debug", "true");
    }

    private void generarAutenticador() {
        final String emisorAuten = this.emisor;
        final String contrasenhaAuten = this.contrasenha;
        this.autenticador = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emisorAuten, Cifrado.descifrarMD5(contrasenhaAuten));
            }
        };
    }

    private Boolean enviarCorreo() {
        try {
            MimeMessage mensaje = new MimeMessage(this.sesion);

            mensaje.addHeader("Content-type", "text/HTML; charset=UTF-8");
            mensaje.addHeader("format", "flowed");
            mensaje.addHeader("Content-Transfer-Encoding", "8bit");

            mensaje.setFrom(new InternetAddress(this.emisor, "NoReply-CyberiaStore"));

            mensaje.setSubject(this.asunto, "UTF-8");

            mensaje.setContent(this.cuerpo, "text/html; charset=UTF-8");

            mensaje.setSentDate(new Date());

            mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.destinatario, false));

            Transport.send(mensaje);
            
            return true;
        
        } catch (MessagingException e) {
            System.out.println("Error de Autenticacion");
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            System.out.println("Codificacion No Soportada");
            e.printStackTrace();
            return false;
        }
    }
}
