package se.dolkow.imagefiltering.app.gui;

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

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

import se.dolkow.imagefiltering.ImageProducer;
import se.dolkow.imagefiltering.app.gui.configuration.ConfigurationComponentFactory;

class ProducerTabPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProducerTabPane(ImageProducer[] producers) {
		
		setTabPlacement(JTabbedPane.LEFT);
		
		for (ImageProducer p : producers) {
			JComponent settings = ConfigurationComponentFactory.createConfigurationComponent(p);
			addTab(p.toString(), null, settings, p.getDescription());
		}
	}
	
	
}
