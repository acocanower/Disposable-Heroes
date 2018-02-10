import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last Edit: 2-9-2018
 *
 */
public class SoldierComponent extends Container 
							  implements ActionListener {

	//I have no idea what this is, and stack overflow didn't help
	private static final long serialVersionUID = 1L;
	
	//soldier displayed info
	private JLabel LBL_SoldierNameAndRank;
	private JLabel LBL_HP;
	private JLabel LBL_CurrentHP;
	private BufferedImage pic;
	
	
	//background stuff
	private Soldier soldier;
	
	
	public SoldierComponent(String NAME) {
		super();
		soldier = new Soldier(NAME);
	}

	
	
	public Container makeGUI(Container pane) {
		Container toadd = pane;
		String nameAndRank = soldier.getNameAndRank();
		
		//toadd.setLayout(new GridBagLayout());
		
		//GridBagConstraints c = new GridBagConstraints();
		
		//c.fill = GridBagConstraints.HORIZONTAL;
		
		toadd.add(LBL_SoldierNameAndRank = new JLabel(soldier.getNameAndRank())).setPreferredSize(new Dimension(40,400));
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(soldier.getImageLoc()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toadd.add(new JLabel(new ImageIcon(image.getScaledInstance(80,80,image.SCALE_DEFAULT))), BorderLayout.PAGE_START);
		
		
		JLabel damageLabel = new JLabel("Enter Damge:: ");
		damageLabel.setPreferredSize(new Dimension(200, 100));
		toadd.add(damageLabel, BorderLayout.CENTER);
		
		
		LBL_CurrentHP= new JLabel(""+soldier.getHP());
		toadd.add(LBL_CurrentHP, BorderLayout.LINE_START);
		
		
		JTextField TXFDamage = new JTextField("0");
		toadd.add(TXFDamage, BorderLayout.LINE_END);
		
		JButton BTN_TakeDamage = new JButton("Take Damage");
		toadd.add(BTN_TakeDamage,BorderLayout.PAGE_END);
		
		
		return toadd;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
