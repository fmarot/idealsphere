package com.teamtter.sphere.analysis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import lombok.Getter;

import com.teamtter.sphere.ISphereModule;

public class AnalysysModule implements ISphereModule {

	@Getter
	private final String name = "Analysis !";

	@Override
	public List<Component> getPages() {
		return null;
	}

	@Override
	public Component getMainPage() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.BLACK);
		panel.setPreferredSize(new Dimension(200, 200));
		return panel;
	}

}
