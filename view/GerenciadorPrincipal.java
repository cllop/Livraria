package view;

import java.awt.Color;

import javax.swing.JPanel;

import config.DevConfig;

public class GerenciadorPrincipal extends JPanel {

	/**
	 * Create the panel.
	 */
	public GerenciadorPrincipal() {
		if (DevConfig.devMode) {
			super.setBackground(new Color(100,50,50,255));
		}
	}

}
