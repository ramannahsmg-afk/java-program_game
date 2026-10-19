import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
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
        window.setResizable(false);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        //CREATION OF MENU (panel)
        JPanel menu = new JPanel(); 
        menu.setBackground(Color.white);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        


        //SWITCHING MECHANISM BETWEEN SCENES
        CardLayout scene = new CardLayout();
        JPanel scenePanel = new JPanel(scene);



        // MAIN MENU TITLE  
        menu.add(Box.createRigidArea(new Dimension(0, 200)));
        JLabel title = new JLabel("2D Game");
        title.setFont(new Font("sans-serif", Font.BOLD, 45));
        title.setPreferredSize(new Dimension(250, 250));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(title);
        menu.add(Box.createRigidArea(new Dimension(0, 200)));

        // PLAY BUTTON
        JButton play = new JButton("PLAY");
        play.setFont(new Font("sans-serif", Font.BOLD,22));
        play.setPreferredSize(new Dimension(180, 60));
        play.setMaximumSize(new Dimension(180, 60));
        play.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(play);
        menu.add(Box.createRigidArea(new Dimension(0, 45)));

        //SETTING BUTTON
        JButton setting = new JButton("SETTINGS");
        setting.setFont(new Font("sans-serif", Font.BOLD,22));
        setting.setPreferredSize(new Dimension(180, 60));
        setting.setMaximumSize(new Dimension(180, 60));
        setting.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(setting);
        menu.add(Box.createRigidArea(new Dimension(0, 45)));

        //EXIT BUTTON
        JButton exit = new JButton("EXIT");
        exit.setFont(new Font("sans-serif", Font.BOLD,22));
        exit.setPreferredSize(new Dimension(180, 60));
        exit.setMaximumSize(new Dimension(180, 60));
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);
        menu.add(exit);
        
        //EXIT BUTTON ACTION
        exit.addActionListener(e ->{
        System.exit(0);
        });






        //CREATION OF GAME SCENE (panel)
        BackgroundPanel game = new BackgroundPanel();
        game.setBackground(Color.black);
        game.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        //BACK BUTTON
        JButton backg = new JButton("BACK");
        backg.setFont(new Font("sans-serif", Font.BOLD,16)); 
        backg.setPreferredSize(new Dimension(100, 50));
        game.add(backg);

        //ACTIONS IN GAME SCENE
        play.addActionListener(e ->{
            scene.show(window.getContentPane(), "game");
            game.requestFocusInWindow();
        });

        backg.addActionListener(e ->{
            scene.show(window.getContentPane(), "menu");
        });

        



        //CREATION OF SETTINGS SCENE (panel)
        JPanel settings = new JPanel(scene);               
        settings.setBackground(Color.white);
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));

        //ACTIONS IN SETTINGS SCENE
        setting.addActionListener(e ->{
            scene.show(window.getContentPane(), "settings");
        });

        //SETTTINGS TITLE
        settings.add(Box.createRigidArea(new Dimension(0, 200)));
        JLabel settingtitle = new JLabel("SETTINGS");
        settingtitle.setFont(new Font("sans-serif", Font.BOLD, 45));
        settingtitle.setPreferredSize(new Dimension(250, 250));
        settingtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(settingtitle);
        settings.add(Box.createRigidArea(new Dimension(0, 120)));

        //SOUND BUTTON
        JButton sound = new JButton("SOUND : ON ");
        sound.setFont(new Font("sans-serif", Font.BOLD,22));
        sound.setPreferredSize(new Dimension(180, 60));
        sound.setMaximumSize(new Dimension(180, 60));
        sound.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(sound);
        settings.add(Box.createRigidArea(new Dimension(0, 45)));

        //SOUND CONTROL CODE
        Clip music = AudioSystem.getClip();
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Assets/Music/mainmenu.wav"));

        music.open(audio);
        music.loop(Clip.LOOP_CONTINUOUSLY);

        sound.addActionListener(e -> {
            if (music.isRunning()) {
                music.stop();
                sound.setText("SOUND : OFF");
            } else {
                music.loop(Clip.LOOP_CONTINUOUSLY);
                sound.setText("SOUND : ON");
        }
    });



        //CONTROLS BUTTON 
        JButton controls = new JButton("CONTROLS");
        controls.setFont(new Font("sans-serif", Font.BOLD,22));
        controls.setPreferredSize(new Dimension(180, 60));
        controls.setMaximumSize(new Dimension(180, 60));
        controls.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(controls);
        settings.add(Box.createRigidArea(new Dimension(0, 45)));   

        //CREATION OF CONTROLLS SCENE (Panel)
        JPanel controlscreen = new JPanel(scene); 
        controlscreen.setBackground(Color.white);
        controlscreen.setLayout(new BoxLayout(controlscreen, BoxLayout.Y_AXIS));
        controlscreen.add(Box.createRigidArea(new Dimension(0, 200)));

        //RIGHT BUTTON
        JButton right = new JButton("RIGHT : D");
        right.setFont(new Font("sans-serif", Font.BOLD, 22));
        right.setPreferredSize(new Dimension(180, 60));
        right.setMaximumSize(new Dimension(180, 60));
        right.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(right);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));
        
        //LEFT BUTTON
        JButton left = new JButton("LEFT : A");
        left.setFont(new Font("sans-serif", Font.BOLD, 22));
        left.setPreferredSize(new Dimension(180, 60));
        left.setMaximumSize(new Dimension(180, 60));
        left.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(left);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));

        //JUMP BUTTON
        JButton jump = new JButton("JUMP : SPACE");
        jump.setFont(new Font("sans-serif", Font.BOLD, 18));
        jump.setPreferredSize(new Dimension(180, 60));
        jump.setMaximumSize(new Dimension(180, 60));
        jump.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(jump);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));

        //ATTACK BUTTON
        JButton lclick = new JButton("ATTACK : LMB");
        lclick.setFont(new Font("sans-serif", Font.BOLD, 18));
        lclick.setPreferredSize(new Dimension(180, 60));
        lclick.setMaximumSize(new Dimension(180, 60));
        lclick.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(lclick);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));
        
        //INTERACT BUTTON
        JButton inte = new JButton("INTERACT : E");
        inte.setFont(new Font("sans-serif", Font.BOLD, 18));
        inte.setPreferredSize(new Dimension(180, 60));
        inte.setMaximumSize(new Dimension(180, 60));
        inte.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(inte);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));

        //BACK BUTTON
        JButton backc = new JButton("BACK");
        backc.setFont(new Font("sans-serif", Font.BOLD, 22));
        backc.setPreferredSize(new Dimension(180, 60));
        backc.setMaximumSize(new Dimension(180, 60));
        backc.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlscreen.add(backc);
        controlscreen.add(Box.createRigidArea(new Dimension(0, 45)));

        //ACTIONS IN CONTROLS SCREEN
        controls.addActionListener(e->{
            scene.show(window.getContentPane(),"controlscreen");
        });

        backc.addActionListener(e->{
            scene.show(window.getContentPane(),"settings");
        });


        //CREDITS BUTTON
        JButton credits = new JButton("CREDITS");
        credits.setFont(new Font("sans-serif", Font.BOLD,22));
        credits.setPreferredSize(new Dimension(180, 60));
        credits.setMaximumSize(new Dimension(180, 60));
        credits.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(credits);
        settings.add(Box.createRigidArea(new Dimension(0, 45)));


        //CREATION OF CREDITS SCREEN (panel)
        JPanel creditscreen = new JPanel(scene); 
        creditscreen.setBackground(Color.white);
        creditscreen.setLayout(new BoxLayout(creditscreen, BoxLayout.Y_AXIS));

        //CREDITS TITLE
        creditscreen.add(Box.createRigidArea(new Dimension(0, 200)));
        JLabel creditstitle = new JLabel("TEAM MEMBERS");
        creditstitle.setFont(new Font("sans-serif", Font.BOLD, 45));
        creditstitle.setPreferredSize(new Dimension(250, 250));
        creditstitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditscreen.add(creditstitle);
        creditscreen.add(Box.createRigidArea(new Dimension(0, 50)));

        //NAME 1
        JLabel name1= new JLabel("JAYANTH");
        name1.setFont(new Font("sans-serif", Font.BOLD, 22));
        name1.setPreferredSize(new Dimension(80, 80));
        name1.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditscreen.add(name1);
        creditscreen.add(Box.createRigidArea(new Dimension(0, 35)));

        //NAME 2
        JLabel name2= new JLabel("JITIN");
        name2.setFont(new Font("sans-serif", Font.BOLD, 22));
        name2.setPreferredSize(new Dimension(80, 80));
        name2.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditscreen.add(name2);
        creditscreen.add(Box.createRigidArea(new Dimension(0, 35)));

        //NAME 3
        JLabel name3= new JLabel("SALMAN");
        name3.setFont(new Font("sans-serif", Font.BOLD, 22));
        name3.setPreferredSize(new Dimension(80, 80));
        name3.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditscreen.add(name3);
        creditscreen.add(Box.createRigidArea(new Dimension(0, 35)));

        //BACK BUTTON
        JButton backcr = new JButton("BACK");
        backcr.setFont(new Font("sans-serif", Font.BOLD, 22));
        backcr.setPreferredSize(new Dimension(180, 60));
        backcr.setMaximumSize(new Dimension(180, 60));
        backcr.setAlignmentX(Component.CENTER_ALIGNMENT);
        creditscreen.add(backcr);
        creditscreen.add(Box.createRigidArea(new Dimension(0, 45)));


        //ACTION IN CREDITS SCENE
        credits.addActionListener(e->{
            scene.show(window.getContentPane(),"creditscreen");
        });

                backcr.addActionListener(e->{
            scene.show(window.getContentPane(),"settings");
        });


        //BACK BUTTON
        JButton backs = new JButton("BACK");
        backs.setFont(new Font("sans-serif", Font.BOLD,22));
        backs.setPreferredSize(new Dimension(180, 60));
        backs.setMaximumSize(new Dimension(180, 60));
        backs.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.add(backs);
        settings.add(Box.createRigidArea(new Dimension(0, 45)));

        //BACK BUTTON ACTION
        backs.addActionListener(e->{
            scene.show(window.getContentPane(),"menu");
        });





        //SCENE LIST
        scenePanel.add(menu, "menu");
        scenePanel.add(game, "game");
        scenePanel.add(settings, "settings");
        scenePanel.add(controlscreen, "controlscreen");
        scenePanel.add(creditscreen,"creditscreen");




        //SHOWING THE WINDOW
        window.setContentPane(scenePanel);
        window.setVisible(true);
    }

}



class BackgroundPanel extends JPanel {

    //BACKGROUND SCENARY LIST FOR GAME SCENE
    Image[] backgrounds = {
    new ImageIcon("Assets/Background/forest.png").getImage(),
    new ImageIcon("Assets/Background/forest_end.png").getImage(),
    new ImageIcon("Assets/Background/entrance.png").getImage(),
    new ImageIcon("Assets/Background/entrance_passage.png").getImage(),
    new ImageIcon("Assets/Background/palace.png").getImage(),
    new ImageIcon("Assets/Background/throne.png").getImage()
    };

    int currentScene = 0;


    //CHARACTER IMAGE 
    Image player = new ImageIcon("Assets/Player/knight/Idle/knight1.png").getImage();

    //CHRATER CONTROLLER VARIABLES
    int x = 100;
    int y = 750;
    int speed = 5;

    boolean left = false;
    boolean right = false;
    boolean jump = false;

    int velocityY = 0;
    int groundY = 750;

    public BackgroundPanel() {

        setFocusable(true);

        //LEFT: A
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed A"), "left");
        getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                left = true;
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "stopLeft");
        getActionMap().put("stopLeft", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                left = false;
            }
        });

        //RIGHT: D
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed D"), "right");
        getActionMap().put("right", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                right = true;
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "stopRight");
        getActionMap().put("stopRight", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                right = false;
            }
        });

        //JUMP: SPACE
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed SPACE"), "jump");
        getActionMap().put("jump", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                if (y == groundY) {
                    velocityY = -15;
                }
            }
        });

        //INTERACT : E
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("pressed E"), "changeScene");
        getActionMap().put("changeScene", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {

                if (x >= getWidth() - 200&& currentScene < backgrounds.length - 1) {
                    currentScene++;
                    x = 0;
                }


                else if (x <= 0 && currentScene > 0) {
                    currentScene--;
                    x = getWidth() - 200;
                }

                repaint();
    }
});

        // GAME LOOP
        Timer timer = new Timer(16, e -> {

            if (left) {
                x -= speed;
            }

            if (right) {
                x += speed;
            }

            //SIMPLE GRAVITY
            y += velocityY;
            velocityY += 1;

            //GROUND
            if (y >= groundY) {
                y = groundY;
                velocityY = 0;
            }

            //SCREEN BOUNDARIES
            x = Math.max(0, Math.min(x, getWidth() - 100));

            repaint();
        });

        timer.start();
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        //PAINTING THE ELEMENTS
        g.drawImage(backgrounds[currentScene],0, 0, getWidth(), getHeight(), this);
        g.drawImage(player, x, y, 200, 200, this);




    }
}