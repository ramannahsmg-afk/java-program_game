import java.awt.*;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;



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
        //JButton backg = new JButton("BACK");
        //backg.setFont(new Font("sans-serif", Font.BOLD,16)); 
        //backg.setPreferredSize(new Dimension(100, 50));
        //game.add(backg);

        //ACTIONS IN GAME SCENE
        play.addActionListener(e ->{
            scene.show(window.getContentPane(), "game");
            game.requestFocusInWindow();
        });

        //backg.addActionListener(e ->{
         //   scene.show(window.getContentPane(), "menu");
        //});

        



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
        AudioInputStream audio = AudioSystem.getAudioInputStream(new File("Assets/Music/background.wav"));

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
    Image[] knightidleFrames = {
    new ImageIcon("Assets/Player/knight/Idle/knight1.png").getImage(),
    new ImageIcon("Assets/Player/knight/Idle/knight2.png").getImage(),
    new ImageIcon("Assets/Player/knight/Idle/knight3.png").getImage(),
    new ImageIcon("Assets/Player/knight/Idle/knight4.png").getImage(),
    new ImageIcon("Assets/Player/knight/Idle/knight5.png").getImage()
    };


    //CM IMAGE 
    Image[] cmidleframes = {
    new ImageIcon ("Assets/Enemies/cm/idle/cm1.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm2.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm3.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm4.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm5.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm6.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm7.png").getImage(),
    new ImageIcon ("Assets/Enemies/cm/idle/cm8.png").getImage(),
    };

    //M IMAGE 
    Image[] midleframes = {
    new ImageIcon ("Assets/Enemies/m/idle/m1.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m2.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m3.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m4.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m5.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m6.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m7.png").getImage(),
    new ImageIcon ("Assets/Enemies/m/idle/m8.png").getImage(),
    };


    //WITCHS IAMGE
    Image[] witchsidleframes = {
    new ImageIcon ("Assets/Enemies/witchs/idle/witchs1.png").getImage(),
    new ImageIcon ("Assets/Enemies/witchs/idle/witchs2.png").getImage(),
    new ImageIcon ("Assets/Enemies/witchs/idle/witchs3.png").getImage(),
    new ImageIcon ("Assets/Enemies/witchs/idle/witchs4.png").getImage(),
    new ImageIcon ("Assets/Enemies/witchs/idle/witchs5.png").getImage(),
    };

    // PROJECTILE SPRITESHEETS
    Image[] cmProjectile = {
    new ImageIcon ("Assets/Projectile/cm/sword.png").getImage(),
    new ImageIcon ("Assets/Projectile/cm/branch.png").getImage()
    };


    //KNIGHT ANIMATION VARIABLES
    int knightcurrentframe = 0;
    int knightanimationcounter = 0;
    int knightanimationdelay = 8;

    //CM ANIMATION VARIABLES
    int cmcurrentframe = 0;
    int cmanimationcounter = 0;
    int cmanimationdelay = 8;

    //M ANIMATON VARIABLES
    int mcurrentframe = 0;
    int manimationcounter = 0;
    int manimationdelay = 8;


    //WITCHS ANIMATON VARIABLES
    int witchscurrentframe = 0;
    int witchsanimationcounter = 0;
    int witchsanimationdelay = 10;

    //CHRATER CONTROLLER VARIABLES
    int x = 100;
    int y = 750;
    int speed = 5;
    boolean facingRight = true;

    boolean left = false;
    boolean right = false;
    boolean jump = false;

    int velocityY = 0;
    int groundY = 750;


    //HEALTH SYSTEM VARIABLES
    int playerMaxHealth = 100;
    int playerHealth = 100;


    //PLAYER COLLISION VARIABLES
    int playerHitboxWidth = 100;
    int playerHitboxHeight = 150;
    int playerHitboxOffsetX = 50;
    int playerHitboxOffsetY = 40;

    // PLAYER ATTACK VARIABLES
    int playerAttackDamage = 50;
    int playerAttackRange = 140;

    int attackCooldown = 0;
    int attackCooldownDuration = 25; // About 0.4 seconds
    int attackEffectTimer = 0;

    //DAMAGE COOLDOWN
    int damageCooldown = 0;
    int damageCooldownDuration = 60; 

    //ENEMY ATTACK VARIABLES
    int enemyAttackCooldown = 0;
    int enemyAttackInterval = 120; 
    int projectileSpeed = 8;
    int projectileDamage = 10;

    //PROJECTILE POSITION AND STATE VARIABLES
    int projectileX = 0;
    int projectileY = 0;
    int projectileSize = 30;
    boolean projectileActive = false;
    int projectileScene = -1;
    int projectileDirection = -1;

    //DEATH STATE
    boolean playerDead = false;


    // ENEMY FALLEN MESSAGE TIMER
    long enemyFallenTime = 0;


    int cmMaxHealth = 350;
    int cmHealth = 350;

    int mMaxHealth = 500;
    int mHealth = 500;

    int witchsMaxHealth = 750;
    int witchsHealth = 750;

    boolean cmAlive = true;
    boolean mAlive = true;
    boolean witchsAlive = true;


    int cmRange = 1100;
    int mRange = 800;
    int witchsRange = 900;

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
                if (!playerDead && y == groundY) {
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


        // PLAYER ATTACK: LEFT MOUSE BUTTON
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    attackPlayer();
                }
            }
        });





                repaint();
    }
});

        // GAME LOOP
        Timer timer = new Timer(16, e -> {

            if (!playerDead) {
                if (left) {
                    x -= speed;
                    facingRight = false;
                }
            
            if (right) {
                    x += speed;
                    facingRight = true;
                }
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

            //ENEMY ATTCK COOLDOWN
            if (damageCooldown > 0) {
                damageCooldown--;
            }

            if (enemyAttackCooldown > 0) {
                enemyAttackCooldown--;
            }

            // PLAYER ATTACK COOLDOWN
            if (attackCooldown > 0) {
                attackCooldown--;
            }

            // ATTACK EFFECT TIMER
            if (attackEffectTimer > 0) {
                attackEffectTimer--;
            }

            checkEnemyCollision();
            tryEnemyAttack();
            updateProjectile();

            //PLAYER IDLE ANIMATION
            knightanimationcounter++;

            if (knightanimationcounter >= knightanimationdelay) {
                knightcurrentframe++;

                if (knightcurrentframe >= knightidleFrames.length) {
                    knightcurrentframe = 0;
                }

                knightanimationcounter = 0;
            }

            //CM IDLE ANIMATION
            cmanimationcounter++;

            if (cmanimationcounter >= cmanimationdelay) {
                cmcurrentframe++;

                if (cmcurrentframe >= cmidleframes.length) {
                    cmcurrentframe = 0;
                }

                cmanimationcounter = 0;
            }

            //M IDLE ANIMATION  
            manimationcounter++;

            if (manimationcounter >= manimationdelay) {
                mcurrentframe++;

                if (mcurrentframe >= midleframes.length) {
                    mcurrentframe = 0;
                }

                manimationcounter = 0;
            }

             //WITCHS IDLE ANIMATION  
            witchsanimationcounter++;

            if (witchsanimationcounter >= witchsanimationdelay) {
                witchscurrentframe++;

                if (witchscurrentframe >= witchsidleframes.length) {
                    witchscurrentframe = 0;
                }

                witchsanimationcounter = 0;
            }


            repaint();
        });

        

        timer.start();
    }

    private void drawHealthBar(Graphics2D g2, int x, int y,int width, int height,int currentHealth, int maxHealth,Color barColor) {

    g2.setColor(new Color(45, 20, 20));
    g2.fillRect(x, y, width, height);


    double healthPercent = Math.max(0.0,Math.min(1.0, (double) currentHealth / maxHealth));

    g2.setColor(barColor);
    g2.fillRect(x, y, (int) (width * healthPercent), height);


    g2.setColor(Color.WHITE);
    g2.drawRect(x, y, width, height);
    
    }

    //COLLIDING METHOD
    private boolean isColliding(int x1, int y1, int width1, int height1,int x2, int y2, int width2, int height2) {

    Rectangle a = new Rectangle(x1, y1, width1, height1);
    Rectangle b = new Rectangle(x2, y2, width2, height2);

    return a.intersects(b);
}

    //PLAYER HITBOX
    private Rectangle getPlayerHitbox() {
    return new Rectangle(
        x + playerHitboxOffsetX,
        y + playerHitboxOffsetY,
        playerHitboxWidth,
        playerHitboxHeight
    );
}

    //APPLY DAMAGE TO PLAYER
    private void takeDamage(int damage) {
    if (playerDead || damageCooldown > 0) {
        return;
    }

    playerHealth = Math.max(0, playerHealth - damage);
    damageCooldown = damageCooldownDuration;

    if (playerHealth <= 0) {
        playerDead = true;
        left = false;
        right = false;
        projectileActive = false;
    }
}

    //CHECK PLAYER-ENEMY CONTACT
    private void checkEnemyCollision() {
    if (playerDead || damageCooldown > 0) {
        return;
    }

    Rectangle player = getPlayerHitbox();

    if (currentScene == 1 && cmAlive && isColliding(player.x, player.y, player.width, player.height,1350, 650, 300, 300)) {
        takeDamage(10);
    }

    else if (currentScene == 3 && mAlive && isColliding(player.x, player.y, player.width, player.height,1250, 590, 500, 500)) {
        takeDamage(10);
    }

    else if (currentScene == 5 && witchsAlive && isColliding(player.x, player.y, player.width, player.height,1200, 520, 400, 400)) {
        takeDamage(10);
    }
}

    // START AN ENEMY PROJECTILE ATTACK
    private void tryEnemyAttack() {
    if (playerDead || projectileActive || enemyAttackCooldown > 0) {
        return;
    }

    int enemyX;
    int enemyWidth;
    int enemyCenterY;
    int attackRange;

    if (currentScene == 1 && cmAlive) {
        enemyX = 1350;
        enemyWidth = 300;
        enemyCenterY = 800;
        attackRange = cmRange;
    }
    else if (currentScene == 3 && mAlive) {
        enemyX = 1250;
        enemyWidth = 500;
        enemyCenterY = 840;
        attackRange = mRange;
    }
    else if (currentScene == 5 && witchsAlive) {
        enemyX = 1200;
        enemyWidth = 400;
        enemyCenterY = 720;
        attackRange = witchsRange;
    }
    else {
        return;
    }

    int enemyCenterX = enemyX + enemyWidth / 2;

    if (Math.abs((x + 100) - enemyCenterX) > attackRange) {
        return;
    }

    //Shoot towards the player's current position.
    projectileDirection = (x + 100 < enemyCenterX) ? -1 : 1;

    projectileX = projectileDirection < 0 ? enemyX : enemyX + enemyWidth;

    // Aim at the player's current vertical position.
    projectileY = y + playerHitboxOffsetY + playerHitboxHeight / 2 - projectileSize / 2;

    projectileScene = currentScene;
    projectileActive = true;
    enemyAttackCooldown = enemyAttackInterval;
}

    //UPDATE PROJECTILE AND CHECK HIT
    private void updateProjectile() {
    if (!projectileActive) {
        return;
    }

    // Remove projectiles when changing scenes.
    if (projectileScene != currentScene || playerDead) {
        projectileActive = false;
        return;
    }

    projectileX += projectileDirection * projectileSpeed;

    Rectangle projectile = new Rectangle(
        projectileX, projectileY,
        projectileSize, projectileSize
    );

    if (projectile.intersects(getPlayerHitbox())) {
        takeDamage(projectileDamage);
        projectileActive = false;
        return;
    }

    // Remove projectiles that leave the screen.
    if (projectileX < -projectileSize ||
        projectileX > getWidth() + projectileSize) {
        projectileActive = false;
    }
}

// PLAYER ATTACK HITBOX
private Rectangle getAttackHitbox() {
    int attackY = y + 60;

    if (facingRight) {
        return new Rectangle(
            x + 130,
            attackY,
            playerAttackRange,
            100
        );
    } else {
        return new Rectangle(
            x - playerAttackRange + 70,
            attackY,
            playerAttackRange,
            100
        );
    }
}

    // PLAYER ATTACK METHOD
    private void attackPlayer() {
    if (playerDead || attackCooldown > 0) {
        return;
    }

    attackCooldown = attackCooldownDuration;
    attackEffectTimer = 8;

    Rectangle attackHitbox = getAttackHitbox();

    // CORRUPTED MONK — SCENE 1
    if (currentScene == 1 && cmAlive) {
        if (attackHitbox.intersects(
                new Rectangle(1350, 650, 300, 300))) {

            cmHealth -= playerAttackDamage;

            if (cmHealth <= 0) {
                cmHealth = 0;
                cmAlive = false;
                enemyFallenTime = System.currentTimeMillis();
            }
        }
    }

    // MEARL — SCENE 3
    else if (currentScene == 3 && mAlive) {
        if (attackHitbox.intersects(
                new Rectangle(1250, 590, 500, 500))) {

            mHealth -= playerAttackDamage;

            if (mHealth <= 0) {
                mHealth = 0;
                mAlive = false;
                enemyFallenTime = System.currentTimeMillis();
            }
        }
    }

    // WITCH WELM — SCENE 5
    else if (currentScene == 5 && witchsAlive) {
        if (attackHitbox.intersects(
                new Rectangle(1200, 520, 400, 400))) {

            witchsHealth -= playerAttackDamage;

            if (witchsHealth <= 0) {
                witchsHealth = 0;
                witchsAlive = false;
                enemyFallenTime = System.currentTimeMillis();
            }
        }
    }

    repaint();
}


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        //PAINTING THE ELEMENTS
        g.drawImage(backgrounds[currentScene],0, 0, getWidth(), getHeight(), this);

        if (facingRight) {
            g.drawImage(knightidleFrames[knightcurrentframe],x, y, 200, 200, this);
        } else {
        g.drawImage(knightidleFrames[knightcurrentframe],x + 200, y, -200, 200, this);
        }

        // PLAYER ATTACK SLASH EFFECT
        if (attackEffectTimer > 0) {
            Graphics2D slash = (Graphics2D) g.create();

            slash.setColor(Color.YELLOW);
            slash.setStroke(new BasicStroke(6));

                if (facingRight) {
                    slash.drawArc(x + 100, y + 50,160, 120,300, 120);
                    } else {
                        slash.drawArc(x - 60, y + 50,160, 120, 120, 120);
                    }

                    slash.dispose();
            }


        if(currentScene == 1 && cmAlive){
        g.drawImage(cmidleframes[cmcurrentframe], 1350, 650,300, 300,this);
        }

        if(currentScene == 3 && mAlive){
        g.drawImage(midleframes[mcurrentframe], 1250, 590,500, 500,this);
        }

        if(currentScene == 5 && witchsAlive){
        g.drawImage(witchsidleframes[witchscurrentframe], 1200, 520,400, 400,this);
        }
        
        Graphics2D g2 = (Graphics2D) g;


        drawHealthBar(g2,30, 40,250, 22,playerHealth,playerMaxHealth,Color.RED);

        // ENEMY HEALTH BAR — BOTTOM OF SCREEN
        int barWidth = 600;
        int barHeight = 18;
        int barX = (getWidth() - barWidth) / 2;
        int barY = getHeight() - 150;


        // ENEMY FALLEN MESSAGE
        boolean enemyFallen =
            (currentScene == 1 && !cmAlive) ||
            (currentScene == 3 && !mAlive) ||
            (currentScene == 5 && !witchsAlive);

        if (enemyFallen &&
            System.currentTimeMillis() - enemyFallenTime < 1000) {

            Graphics2D fallenGraphics = (Graphics2D) g.create();

            fallenGraphics.setColor(new Color(0, 0, 0, 180));
            fallenGraphics.fillRect(0, 0, getWidth(), getHeight());

            fallenGraphics.setColor(Color.YELLOW);
            fallenGraphics.setFont(
                new Font("sans-serif", Font.BOLD, 60)
            );

            String message = "ENEMY FALLEN";
            FontMetrics fm = fallenGraphics.getFontMetrics();

            int textX = (getWidth() - fm.stringWidth(message)) / 2;
            int textY = getHeight() / 2;

            fallenGraphics.drawString(message, textX, textY);
            fallenGraphics.dispose();
        }
                

    
        // CM enemy — scene 1
        if (currentScene == 1 && cmAlive) {

            int enemyX = 1350;
            int distance = Math.abs(x - enemyX);

            if (distance <= cmRange) {
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("sans-serif", Font.BOLD, 20));
                g2.drawString("CORRUPTED MONK", barX, barY - 10);

                drawHealthBar(
                    g2, barX, barY, barWidth, barHeight,
                    cmHealth, cmMaxHealth, Color.RED
                );
            }
        }

        // M enemy — scene 3
        if (currentScene == 3 && mAlive) {

            int enemyX = 1250;
            int distance = Math.abs(x - enemyX);

            if (distance <= mRange) {
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("sans-serif", Font.BOLD, 20));
                g2.drawString("MEARL", barX, barY - 10);

                drawHealthBar(
                    g2, barX, barY, barWidth, barHeight,
                    mHealth, mMaxHealth, Color.RED
                );
            }
        }

        // Witch enemy — scene 5
        if (currentScene == 5 && witchsAlive) {

            int enemyX = 1200;
            int distance = Math.abs(x - enemyX);

            if (distance <= witchsRange) {
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("sans-serif", Font.BOLD, 20));
                g2.drawString("WITCH WELM", barX, barY - 10);

                drawHealthBar(
                    g2, barX, barY, barWidth, barHeight,
                    witchsHealth, witchsMaxHealth, Color.RED
                );
            }
        }

            // DRAW ENEMY PROJECTILE
        if (projectileActive && projectileScene == currentScene) {
            Graphics2D projectileGraphics = (Graphics2D) g.create();

            projectileGraphics.setColor(Color.ORANGE);
            projectileGraphics.fillOval(
                projectileX,
                projectileY,
                projectileSize,
                projectileSize
            );

            projectileGraphics.setColor(Color.RED);
            projectileGraphics.drawOval(
                projectileX,
                projectileY,
                projectileSize,
                projectileSize
            );

            projectileGraphics.dispose();
        }



        if (playerDead) {
            Graphics2D deathGraphics = (Graphics2D) g.create();

            deathGraphics.setColor(new Color(0, 0, 0, 180));
            deathGraphics.fillRect(0, 0, getWidth(), getHeight());

            deathGraphics.setColor(Color.RED);
            deathGraphics.setFont(new Font("sans-serif", Font.BOLD, 60));

            String message = "YOU DIED";
            FontMetrics metrics = deathGraphics.getFontMetrics();

            int textX = (getWidth() - metrics.stringWidth(message)) / 2;
            int textY = getHeight() / 2;

            deathGraphics.drawString(message, textX, textY);

            deathGraphics.dispose();
        }


    }
    

}
