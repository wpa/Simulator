/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 9, 2011
 */

package com.wpa.projects.simulator.ui.gui.menu;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *
 */
public class SimulatorMenu {

	private final List<Map<String, Map<String, ActionListener>>> menuList = new ArrayList<Map<String, Map<String, ActionListener>>>();
	private final ActionListener actionListener;

	public SimulatorMenu(ActionListener actionListener) {
		this.actionListener = actionListener;
	}

	public List<Map<String, Map<String, ActionListener>>> getMenuList() {
		Map<String, ActionListener> menuItemsHelp = new HashMap<String, ActionListener>();
		Map<String, ActionListener> menuItemsTransaction = new HashMap<String, ActionListener>();
		Map<String, Map<String, ActionListener>> mainMenus = new HashMap<String, Map<String, ActionListener>>();

		menuItemsHelp.put("O programie", actionListener);
		menuItemsTransaction.put("Kup jednostki", actionListener);
		menuItemsTransaction.put("Sprzedaj jednostki", actionListener);
		mainMenus.put("Transakcje", menuItemsTransaction);
		mainMenus.put("Pomoc", menuItemsHelp);
		menuList.add(mainMenus);
		return menuList;
	}
}
