/*
	Copyright 2009 Snild Dolkow
	
	This file is part of Perler.
	
	Perler is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	Perler is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with Perler.  If not, see <http://www.gnu.org/licenses/>.
*/
package se.dolkow.imagefiltering.app.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import se.dolkow.imagefiltering.app.PerlerApp;
import se.dolkow.imagefiltering.app.gui.configuration.ImageFileChooser;
import se.dolkow.imagefiltering.internationalization.Messages;

/**
 * @author snild
 *
 */
public class NewMenuItem extends JMenuItem {
	
	private static final long serialVersionUID = 1L;

	public NewMenuItem() {
		super(Messages.get("NewMenuItem.new_chain")); //$NON-NLS-1$
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageFileChooser ifc = new ImageFileChooser();
				
				int ans = ifc.showOpenDialog(null);
				switch (ans) {
				case ImageFileChooser.APPROVE_OPTION:
					PerlerApp.startWithNew(ifc.getSelectedFile().getAbsolutePath());
					break;
				case ImageFileChooser.CANCEL_OPTION:
					return;
				case ImageFileChooser.ERROR_OPTION:
					JOptionPane.showMessageDialog(null, "Error in ImageFileChooser", "Error", JOptionPane.ERROR_MESSAGE);  //$NON-NLS-1$//$NON-NLS-2$
					break;
				}
			}
		});
	}
}
