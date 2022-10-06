
/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import javax.swing.*;

//  extends Program implements NameSurferConstants
public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base and
	 * initializing the interactors at the bottom of the window.
	 */
	// private NameSurferEntry surferEntry;

	private JButton graphButton, clearButton;
	private JTextField msgField;
	private JLabel name;
	private NameSurferDataBase dataBase;
	private NameSurferGraph graph;

	public void init() {
		// You fill this in, along with any helper methods //
		msgField = new JTextField(25);
		name = new JLabel("Name");
		graphButton = new JButton("Graph");
		clearButton = new JButton("Clear");
		add(name, SOUTH);
		add(msgField, SOUTH);
		add(graphButton, SOUTH);
		add(clearButton, SOUTH);
		addActionListeners();
		dataBase = new NameSurferDataBase(NAMES_DATA_FILE);
		graph = new NameSurferGraph();
		add(graph);
		this.validate();
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are clicked, so you
	 * will have to define a method to respond to button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		// here i wrote some code about clicks
		Object click = e.getSource();
		if (click == graphButton) {
			NameSurferEntry dat = dataBase.findEntry(msgField.getText());
			if(dat != null) {
				graph.addEntry(dat);
				graph.update();
			}
			msgField.setText("");
		} else if (click == clearButton) {
			graph.clear();
			graph.update();
		}
	}
}
