/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 10, 2011
 */

package com.wpa.projects.simulator.ui.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog {

	private static final long serialVersionUID = 3516602098643330988L;

	public HelpDialog(Frame frame) {
		super(frame);
		JTextArea textArea = new JTextArea();
		textArea
				.setText("\nTFI Symulator by Wojciech Padula \n<wojciech.padula@gmail.com>");
		textArea.setEditable(false);
		setLayout(new BorderLayout());
		add(textArea, BorderLayout.CENTER);
		setLocationRelativeTo(frame);
		setSize(230, 100);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
