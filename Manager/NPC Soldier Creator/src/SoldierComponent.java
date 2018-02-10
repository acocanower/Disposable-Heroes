import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.image.BufferedImage;

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
		
		String nameAndRank = soldier.getNameAndRank();
		pane.add(LBL_SoldierNameAndRank = new JLabel(soldier.getNameAndRank()), BorderLayout.PAGE_START);
		
		
		pane.add(new JLabel("IMAGE PLACEHOLDER"), BorderLayout.PAGE_START);//new ImageIcon(soldier.getImageLoc())), BorderLayout.PAGE_START);
		
		
		JLabel damageLabel = new JLabel("Enter Damge:: ");
		damageLabel.setPreferredSize(new Dimension(200, 100));
		pane.add(damageLabel, BorderLayout.CENTER);
		
		
		LBL_CurrentHP= new JLabel(""+soldier.getHP());
		pane.add(LBL_CurrentHP, BorderLayout.LINE_START);
		
		
		JTextField TXFDamage = new JTextField("0");
		pane.add(TXFDamage, BorderLayout.LINE_END);
		
		JButton BTN_TakeDamage = new JButton("Take Damage");
		pane.add(BTN_TakeDamage,BorderLayout.PAGE_END);
		
		return pane;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
