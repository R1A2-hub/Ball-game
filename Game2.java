import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game2 extends JFrame implements ActionListener {

    private int x1 = 20, x2 = 60, y1 = 30, y2 = 200;
    private Color c1 = Color.RED;
    private Color c2;
    private int w = 0;
    private final int DELAY = 100; // milliseconds

    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    public Game2() {
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBounds(60, 440, 400, 30);
        add(p1);

        JPanel p2 = new JPanel();
        p2.setBounds(20, 470, 600, 30);
        add(p2);

        b1 = new JButton("START");
        p1.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("STOP");
        p1.add(b2);
        b2.addActionListener(this);

        b3 = new JButton("RED");
        p2.add(b3);
        b3.addActionListener(this);

        b4 = new JButton("GREEN");
        p2.add(b4);
        b4.addActionListener(this);

        b5 = new JButton("BLUE");
        p2.add(b5);
        b5.addActionListener(this);

        b6 = new JButton("PINK");
        p2.add(b6);
        b6.addActionListener(this);

        b7 = new JButton("ORANGE");
        p2.add(b7);
        b7.addActionListener(this);

        b8 = new JButton("YELLOW");
        p2.add(b8);
        b8.addActionListener(this);

        b9 = new JButton("MAGENTA");
        p2.add(b9);
        b9.addActionListener(this);

        b10 = new JButton("BLACK");
        p2.add(b10);
        b10.addActionListener(this);

        setSize(640, 520);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Timer timer = new Timer(DELAY, new ActionListener()
		{
            @Override
            public void actionPerformed(ActionEvent e) 
			{
                if (w == 1)
				{
                    moveBalls();
                    changeColor();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void moveBalls()
	{
        if (x1 >= 495) 
		{
            x1 = 0;
        }
        if (x2 >= 495)
		{
            x2 = 20;
        }
        if (y1 >= 390)
		{
            y1 = 30;
        }
        if (y2 >= 395) 
		{
            y2 = 0;
        } 
		else 
		{
            x1 += 10;
            x2 += 5;
            y1 += 4;
            y2 += 3;
        }
    }

    private void changeColor() 
	{
        int random = (int) (Math.random() * 8);
        switch (random) 
		{
            case 0:
                c1 = Color.RED;
                break;
            case 1:
                c1 = Color.GREEN;
                break;
            case 2:
                c1 = Color.BLUE;
                break;
            case 3:
                c1 = Color.PINK;
                break;
            case 4:
                c1 = Color.ORANGE;
                break;
            case 5:
                c1 = Color.YELLOW;
                break;
            case 6:
                c1 = Color.MAGENTA;
                break;
            case 7:
                c1 = Color.BLACK;
                break;
        }
    }

    @Override
    public void paint(Graphics g) 
	{
        super.paint(g);
        g.setColor(c1);
        g.fillOval(x1, y1, 30, 30);
        g.fillOval(x2, y2, 30, 30);
        if (c1.getRGB() == c2.getRGB()) 
		{
            g.drawString("WIN", 50, 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == b1) 
		{
            w = 1;
        } 
		else if (e.getSource() == b2) 
		{
            w = 0;
        } 
		else if (e.getSource() == b3) 
		{
            c2 = Color.RED;
        } 
		else if (e.getSource() == b4) 
		{
            c2 = Color.GREEN;
        } 
		else if (e.getSource() == b5) 
		{
            c2 = Color.BLUE;
        } 
		else if (e.getSource() == b6) 
		{
            c2 = Color.PINK;
        } 
		else if (e.getSource() == b7) 
		{
            c2 = Color.ORANGE;
        } 
		else if (e.getSource() == b8) 
		{
            c2 = Color.YELLOW;
        } 
		else if (e.getSource() == b9) 
		{
            c2 = Color.MAGENTA;
        } 
		else if (e.getSource() == b10) 
		{
            c2 = Color.BLACK;
        }
    }

    public static void main(String[] args) 
	{
        new Game2();
    }
}