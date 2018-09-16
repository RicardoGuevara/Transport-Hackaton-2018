/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transmetro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static javax.print.attribute.standard.ReferenceUriSchemesSupported.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author rick
 */
public class Upload {
    
    private String serverName,
            user,
            pass;

    public Upload(String serverName, String user, String pass) {
        this.serverName = serverName;
        this.user = user;
        this.pass = pass;
    }

    public void inUpload(String ruta) {
        FTPClient client = new FTPClient();
        try {
            client.connect(serverName);
            boolean login = client.login(user, pass);

            if (login) {
                System.out.println("Iniciando sesión Satisfactoriamente");
                int replay = client.getReplyCode();
                //FTPFile[] test = client.listDirectories("/public_html/");
//                for (int i = 0; i < test.length; i++) {
//                    System.out.println(test[i]);
//                    if (test[i].toString().contains(builder.getTitle())){
//                        dir_existente = true;
//                    }
//                }
                if (FTPReply.isPositiveCompletion(replay)) {
                    File file = new File(ruta);
                    try (FileInputStream input = new FileInputStream(file)) {
                        client.setFileType(FTP.getValue()); // experimento trambólico
                        
                        client.enterLocalPassiveMode();
                        System.out.println("Subió satisfactoriamente el archivo");
                        boolean dir_creado;
//                        System.out.println(builder.getTitle());
                        if (client.makeDirectory("/public_html/" /*+ "index" + "/"*/)) {
                            
                            System.out.println("Directorio creado");
                        } else if (dir_existente) {
                            System.out.println("Directorio ya existente");
                        } else {
                            System.out.println("Error al crear directorio");
                        }
                        
                        if (!client.storeFile("/public_html/" /*+ "index" + "/"*/ + file.getName(), input)) {
                            System.out.println("Subida fallida!");
                        }
                    }
                }
                // retorna true al cerrar sesiòn
                boolean logout = client.logout();

                if (logout) {
                    System.out.println("Salir del servidor FTP");

                }
            } else {
                System.out.println("Falló inciar sesión");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Cierra la conexión al servidor FTP
                client.disconnect();
                dir_existente = false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    boolean dir_existente;
}
