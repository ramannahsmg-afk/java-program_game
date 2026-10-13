import java.awt.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {

        //VARIABLES FOR THE WINDOW
        int rowCount = 21;
        int columnCount = 25;
        int tileSize = 50;
        int boardWidth = columnCount * tileSize;
        int boardHeight = rowCount * tileSize;

        //CREATION OF WINDOW (frame)
        JFrame window = new JFrame("2d game");
       
        //CONFIGURING WINDOW
        window.setSize(boardWidth, boardHeight);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //CREATION OF MENU (panel)
        JPanel menu = new JPanel(); 
        menu.setBackground(Color.white);
        
        //SWITCHING MECHANISM BETWEEN SCENES
        CardLayout scene = new CardLayout();
        JPanel scenePanel = new JPanel(scene);

        // MAIN MENU TITLE  
        JLabel title = new JLabel("2D Game");
        title.setFont(new Font("sans-serif", Font.BOLD, 45));
        menu.add(title);

        // PLAY BUTTON
        JButton play = new JButton("PLAY");
        play.setFont(new Font("sans-serif", Font.BOLD,36));
        menu.add(play);

        //SETTING BUTTON
        JButton setting = new JButton("SETTINGS");
        setting.setFont(new Font("sans-serif", Font.BOLD,36));
        menu.add(setting);

        //EXIT BUTTON
        JButton exit = new JButton("EXIT");
        exit.setFont(new Font("sans-serif", Font.BOLD,36)); 
        menu.add(exit);

        //ACTION FOR EVERY BUTTON
        play.addActionListener(e ->{
            scene.show(window.getContentPane(), "game");
        });

        setting.addActionListener(e ->{
            scene.show(window.getContentPane(), "settings");
        });

        exit.addActionListener(e ->{
            System.exit(0);
        });

        
        //CREATION OF GAME SCENE (panel)
        BackgroundPanel game = new BackgroundPanel();
        game.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));


        JButton backg = new JButton("BACK");
        backg.setFont(new Font("sans-serif", Font.BOLD,16));
        backg.setPreferredSize(new Dimension(100,50));
        game.add(backg);

        backg.addActionListener(e->{
            scene.show(window.getContentPane(),"menu");
        });


        //CREATION OF SETTINGS (panel)
        JPanel settings = new JPanel(scene);
        settings.setBackground(Color.pink);
        settings.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JButton backs = new JButton("BACK");
        backs.setFont(new Font("sans-serif", Font.BOLD,16));
        backs.setPreferredSize(new Dimension(100,50));
        settings.add(backs);

        backs.addActionListener(e->{
            scene.show(window.getContentPane(),"menu");
        });

        //SCENE LIST
        scenePanel.add(menu, "menu");
        scenePanel.add(game, "game");
        scenePanel.add(settings, "settings");
       


        //SHOWING THE WINDOW
        window.setContentPane(scenePanel);
        window.setVisible(true);
    }
}

class BackgroundPanel extends JPanel {
    Image img = new ImageIcon("Assets/forest.png").getImage(); 

    @Override

protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

            g.setColor(Color.RED);
            g.fillRect(50,770, 130,270);
            
    }
}

