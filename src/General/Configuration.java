/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package General;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Jithinpv
 */
public class Configuration {

    public static String iconFolder = "images/";
    public static String dataCloud = "dataCloud/";
    public static String organisationImages = "organisationImages/";
    public static String sendPasswordSubject = "Attribute based encryption - forgot password ";
    public static String temporaryFilePath = "temporaryFilePath/";
    public static String allKeys = "allKeys/";

    public static void setIconOnLabel(String fileString, JLabel label) {
        // convert string file path to image icona and set on this label
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(iconFolder + fileString));
            Image scaledInstance = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void setIconOnButton(String fileString, JButton button) {
        // convert string file path to image icona and set on this label
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(iconFolder + fileString));
            Image scaledInstance = img.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            button.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setOrganisationIcon(String fileString, JLabel label) {
        // convert string file path to image icona and set on this label
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(organisationImages + fileString));
            Image scaledInstance = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            label.setIcon(imageIcon);
        } catch (IOException e) {
            System.out.println("Could not load " + organisationImages + fileString);
            label.setIcon(null);
        }
    }

    public static void setDefaultFileIcon(File file, JLabel label) {
        try {
            Icon ico = FileSystemView.getFileSystemView().getSystemIcon(file);
            Image image = ((ImageIcon) ico).getImage();
            Image scaledInstance = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledInstance);
            label.setIcon(imageIcon);
        } catch (Exception e) {
            System.out.println("Could not load image " + file.getAbsolutePath());
        }
    }

    public static void initializeEnvironment() {
        try {
            File f_iconFolder = new File(iconFolder);
            if (!f_iconFolder.exists()) {
                f_iconFolder.mkdir();
            }

            File f_dataCloud = new File(dataCloud);
            if (!f_dataCloud.exists()) {
                f_dataCloud.mkdir();
            }

            File f_organisationImages = new File(organisationImages);
            if (!f_organisationImages.exists()) {
                f_organisationImages.mkdir();
            }

            File f_temporaryFilePath = new File(temporaryFilePath);
            if (!f_temporaryFilePath.exists()) {
                f_temporaryFilePath.mkdir();
            }

            File f_allKeys = new File(allKeys);
            if (!f_allKeys.exists()) {
                f_allKeys.mkdir();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
