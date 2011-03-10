/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.wpa.projects.simulator.assets.Wallet;
import com.wpa.projects.simulator.investments.Fund;
import com.wpa.projects.simulator.investments.Unit.UnitType;
import com.wpa.projects.simulator.transactions.TransactionService;

/**
 * 
 *
 */
public class AskDialog extends TraderDialog {

	private static final long serialVersionUID = 2400378071968168659L;
	private static final String TYPE_A = "unitA";
	private static final String TYPE_B = "unitB";
	private final Frame frame;

	private Fund selectedFund;
	private UnitType unitType;

	public AskDialog(Frame frame, Wallet wallet,
			TransactionService transactionService) {
		super(frame, wallet, transactionService);
		this.frame = frame;
		setSize(340, 150);
		setTitle("Kup jednostki funduszu");
		setResizable(false);

	}

	@Override
	protected void buildContent() {

		List<Fund> fundString = new ArrayList<Fund>();
		for (Fund fund : Fund.values()) {
			fundString.add(fund);
		}

		JComboBox fundList = new JComboBox(fundString.toArray());
		fundList.setSelectedIndex(1);
		fundList.addActionListener(this);
		JLabel fundLabel = new JLabel("Dostępne fundusze");
		JLabel typeLabel = new JLabel("Typ jednostki");
		final JTextField quantity = new JTextField(5);
		quantity.setText("0");
		quantity
				.setToolTipText("Wprowadź nieujemną całkowitą liczbę jednostek mniejszą niż 1000");
		quantity.setSize(200, 50);
		JLabel quantityLabel = new JLabel("Ilość");
		JButton askButton = new JButton("Kup");
		JRadioButton unitA = new JRadioButton("Typ A");
		unitA.setActionCommand(TYPE_A);
		unitA.addActionListener(this);
		unitA.setSelected(true);
		JRadioButton unitB = new JRadioButton("Typ B");
		unitB.setActionCommand(TYPE_B);
		unitB.addActionListener(this);
		ButtonGroup unitTypeBox = new ButtonGroup();
		unitTypeBox.add(unitA);
		unitTypeBox.add(unitB);
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(unitA);
		radioPanel.add(unitB);
		panel.add(fundLabel);
		panel.add(fundList);
		panel.add(typeLabel);
		panel.add(radioPanel);
		panel.add(quantityLabel);
		panel.add(quantity);
		panel.add(askButton);

		quantity.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});

		askButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				if (!quantity.getText().isEmpty()) {
					Integer value = Integer.parseInt(quantity.getText());
					if ((value > 0) && (selectedFund != null) && (unitType != null)
							&& (value < 1000)) {
						boolean ok = transactionService.ask(wallet, value,
								selectedFund, unitType);
						if (ok) {
							JOptionPane
									.showMessageDialog(
											frame,
											"Transakcja zakupu jednostek uczestnictwa przebiegła pomyślnie",
											"Transakcja sfinalizowana",
											JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane
									.showMessageDialog(
											frame,
											"Brak środków do sfinalizowania transakcji",
											"Transakcja odrzucona",
											JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent event) {

		Object source = event.getSource();

		if (source instanceof JComboBox) {
			Fund fund = (Fund) ((JComboBox) source).getSelectedItem();
			this.selectedFund = fund;
		} else {
			String command = event.getActionCommand();
			if (command.equals(TYPE_A))
				unitType = UnitType.A;
			else if (command.equals(TYPE_B))
				unitType = UnitType.B;
		}
	}

}
