import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class WalkingFrame extends JFrame implements ActionListener 
{
	private Man man;
	private Circle ball;
	private ArrayList<Circle> balls;

	public WalkingFrame() 
	{
		setBounds(100, 100, 600, 400);
		man = new Man(0, 0);
		setLayout(null);
		add(man);
		ball = new Circle(man.getX(), man.getY());
		balls = new ArrayList<Circle>();
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener() 
		{
			public void keyPressed(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_W)
					man.setDY(-2);
				if (e.getKeyCode() == KeyEvent.VK_S)
					man.setDY(2);
				if (e.getKeyCode() == KeyEvent.VK_A)
					man.setDX(-2);
				if (e.getKeyCode() == KeyEvent.VK_D)
					man.setDX(2);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) 
				{
					ball = new Circle(man.getX(), man.getY() + 11);
					balls.add(ball);
					add(ball);
				}
			}

			public void keyReleased(KeyEvent e) 
			{
				if (e.getKeyCode() == KeyEvent.VK_W)
					man.setDY(0);
				if (e.getKeyCode() == KeyEvent.VK_S)
					man.setDY(0);
				if (e.getKeyCode() == KeyEvent.VK_A)
					man.setDX(0);
				if (e.getKeyCode() == KeyEvent.VK_D)
					man.setDX(0);
			}

			public void keyTyped(KeyEvent e) 
			{
				
			}

		});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new WalkingFrame();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		for(int i = 0; i < balls.size(); i++)
		{
			if(balls.get(i).getX() > 600)
			{
				remove(balls.get(i));
				balls.remove(balls.get(i));
			}
			else
			{
				balls.get(i).update();
			}
		}
		man.update();
		repaint();
	}
}
