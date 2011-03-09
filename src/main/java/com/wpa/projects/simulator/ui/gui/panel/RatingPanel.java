/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.wpa.projects.simulator.investments.Fund;

/**
 * 
 *
 */
public class RatingPanel extends JPanel implements Observer {

	private JLabel money_Market = new JLabel();
	private JLabel bond = new JLabel();
	private JLabel stable_Growth = new JLabel();
	private JLabel balanced = new JLabel();
	private JLabel equity = new JLabel();

	private volatile BigDecimal money_MarketPrice;
	private volatile BigDecimal bond_Price;
	private volatile BigDecimal stable_GrowthPrice;
	private volatile BigDecimal equity_Price;
	private volatile BigDecimal balanced_Price;

	private final Color UP = Color.green;
	private final Color DOWN = Color.red;
	private final Color STABLE = Color.blue;

	public RatingPanel() {

		Font font = new Font("Serif", Font.BOLD, 13);
		money_Market.setFont(font);
		bond.setFont(font);
		stable_Growth.setFont(font);
		balanced.setFont(font);
		equity.setFont(font);

		add(money_Market);
		add(bond);
		add(stable_Growth);
		add(balanced);
		add(equity);
	}

	@Override
	public void update(Observable arg0, Object arg1) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				updateRating();
			}
		});
	}

	private void updateRating() {

		money_Market.setText(fundPrice(Fund.Money_Market));
		if (money_MarketPrice == null) {
			money_MarketPrice = Fund.Money_Market.getUnitsPrice();
		} else {
			setColor(money_Market, money_MarketPrice, Fund.Money_Market
					.getUnitsPrice());
		}

		balanced.setText(fundPrice(Fund.Balanced));
		if (balanced_Price == null) {
			balanced_Price = Fund.Balanced.getUnitsPrice();
		} else {
			setColor(balanced, balanced_Price, Fund.Balanced.getUnitsPrice());
		}

		bond.setText(fundPrice(Fund.Bond));
		if (bond_Price == null) {
			bond_Price = Fund.Bond.getUnitsPrice();
		} else {
			setColor(bond, bond_Price, Fund.Bond.getUnitsPrice());
		}

		equity.setText(fundPrice(Fund.Equity));
		if (equity_Price == null) {
			equity_Price = Fund.Equity.getUnitsPrice();
		} else {
			setColor(equity, equity_Price, Fund.Equity.getUnitsPrice());
		}

		stable_Growth.setText(fundPrice(Fund.Stable_Growth));
		if (stable_GrowthPrice == null) {
			stable_GrowthPrice = Fund.Stable_Growth.getUnitsPrice();
		} else {
			setColor(stable_Growth, stable_GrowthPrice, Fund.Stable_Growth
					.getUnitsPrice());
		}

	}

	private String fundPrice(Fund fund) {
		return fund.getName() + " : " + fund.getUnitsPrice();
	}

	private void setColor(JLabel label, BigDecimal currentPrice,
			BigDecimal newPrice) {

		int compareResult = currentPrice.compareTo(newPrice);
		switch (compareResult) {
		case -1:
			label.setForeground(UP);
			break;
		case 0:
			label.setForeground(STABLE);
			break;
		case 1:
			label.setForeground(DOWN);
			break;
		default:
			break;
		}

	}
}
