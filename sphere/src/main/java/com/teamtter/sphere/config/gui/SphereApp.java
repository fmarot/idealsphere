package com.teamtter.sphere.config.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.teamtter.sphere.ISphereModule;
import com.teamtter.sphere.analysis.AnalysysModule;
import com.teamtter.sphere.config.AnalysisContext;

@Slf4j
public class SphereApp {

	private final JFrame frame;
	private JPanel contentPanel;
	private JList<String> modulesList;

	private void addTheSpringStuffs() {

		ISphereModule a = new AnalysysModule();
		AnalysisContext b = new AnalysisContext();

		log.warn("Init Spring...");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.teamtter.sphere.config");
		Map<String, ISphereModule> beansOfType = context.getBeansOfType(ISphereModule.class);
		for (ISphereModule currModule : beansOfType.values()) {
			log.warn("module : {}", currModule.getName());
		}
	}

	public SphereApp() {
		frame = new JFrame("Sphere");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildContent();
		addTheSpringStuffs(); // !
		frame.setSize(500, 350);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 350);

	}

	private void buildContent() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		contentPanel = new JPanel(new BorderLayout());
		panel.add(getLauncher(), BorderLayout.WEST);
		panel.add(contentPanel, BorderLayout.EAST);
		frame.getContentPane().add(panel);
	}

	private Component getLauncher() {
		JPanel panel = new JPanel(new BorderLayout());
		modulesList = new JList<String>();
		modulesList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent selectionEvent) {
				// selectionEvent.getFirstIndex()

			}
		});
		DefaultListModel<String> model = new DefaultListModel<>();
		model.addElement("foo");
		model.addElement("bar");
		modulesList.setModel(model);
		panel.add(modulesList, BorderLayout.CENTER);
		return panel;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SphereApp();
			}
		});
	}

}
