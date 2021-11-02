/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BackgroundPanel extends JPanel {

    private Image image;

    public BackgroundPanel()
    {
        super();
    }

    public BackgroundPanel(LayoutManager manager)
    {
        super(manager);
    }

    public BackgroundPanel(LayoutManager manager, Image image)
    {
        super(manager);
        this.image = image;
    }

    public void setImage() {
        
        BufferedImage b = null;
        try {
            b = ImageIO.read(new File("C:\\Users\\rolep\\Documents\\NetBeansProjects\\Capstone Project GUI\\src\\main\\java\\resources\\sunset.jpg")); // TODO - change to relative path
        }
        catch (IOException e)
        {
            System.out.println("No image found...");
        }
        image = b;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(770, 540);
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(image, 0, 0, this);
    }
}

