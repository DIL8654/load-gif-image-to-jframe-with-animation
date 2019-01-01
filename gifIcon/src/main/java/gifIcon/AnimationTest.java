package gifIcon;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class AnimationTest extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AnimationTest test = new AnimationTest();
                test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                test.setVisible(true);
            }
        });
    }

    public AnimationTest() {
        super();
        try {
            JLabel label = new JLabel();
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("gif.gif").getFile());
//            ImageIcon imageIcon = new ImageIcon(ImageIO.read(getClass().getResource("/src/main/resources/gif.gif")));
            Image image = Toolkit.getDefaultToolkit().createImage(org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(file)));
            ImageIcon icon = new ImageIcon(image);
            label.setIcon(icon);
            icon.setImageObserver(label);
            add(label);
            pack();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
