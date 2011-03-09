/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.menu;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 
 *
 */
public class SimulatorMenuBuilder {

	private final List<Map<String, Map<String, ActionListener>>> menuList;

	public SimulatorMenuBuilder(
			List<Map<String, Map<String, ActionListener>>> menuList) {

		this.menuList = menuList;
	}

	public JMenuBar build() {

		JMenuBar menuBar = new JMenuBar();

		for (Map<String, Map<String, ActionListener>> menu : menuList) {

			Set<Entry<String, Map<String, ActionListener>>> menuEntry = menu
					.entrySet();

			for (Entry<String, Map<String, ActionListener>> entry : menuEntry) {

				JMenu mainMenu = addMenu(entry.getKey());
				Set<Entry<String, ActionListener>> menuItem = entry.getValue()
						.entrySet();
				for (Entry<String, ActionListener> entryMenuItem : menuItem) {

					mainMenu.add(addMenuItem(entryMenuItem.getKey(),
							entryMenuItem.getValue()));
				}
				menuBar.add(mainMenu);
			}

		}
		return menuBar;
	}

	private JMenu addMenu(String name) {

		return new JMenu(name);
	}

	private JMenuItem addMenuItem(String name, ActionListener actionListener) {

		JMenuItem menuItem = new JMenuItem(name);
		menuItem.addActionListener(actionListener);
		menuItem.setActionCommand(name.replaceAll(" ", "_"));
		return menuItem;
	}
}
