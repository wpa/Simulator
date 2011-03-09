/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimulatorSwing {

	public static void run(final JFrame frame, final int width, final int height) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Dimension screenSize = toolkit.getScreenSize();
				frame.setTitle(frame.getClass().getSimpleName());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				if ((width > 0) && (height > 0))
					frame.setSize(width, height);
				else
					frame.setSize(screenSize.width / 2, screenSize.height / 2);
				frame.setLocation(screenSize.width / 4, screenSize.height / 4);
				frame.setVisible(true);

			}
		});

	}
}