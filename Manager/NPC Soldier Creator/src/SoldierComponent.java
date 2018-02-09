import java.awt.Component;
import java.awt.Container;

import javax.swing.JLabel;

/**
 * 
 */

/**
 * @author Aaron
 * 
 * Last Edit: 2/9/2018
 *
 */
public class SoldierComponent extends Component {

	/**
	 * 
	 */
	private JLabel LBL_SoldierName;
	private JLabel LBL_Rank;
	private JLabel LBL_HP;
	private JLabel LBL_CurrentHP;
	
	private Soldier soldier;
	private Container pane;
	
	
	public SoldierComponent(String NAME) {
		soldier = new Soldier(NAME);
	}

}
