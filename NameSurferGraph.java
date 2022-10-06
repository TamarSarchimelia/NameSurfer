/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	private ArrayList <NameSurferEntry> namesArray;
	public NameSurferGraph() {
		graphics();
		addComponentListener(this);
		//	 You fill in the rest //
		namesArray = new ArrayList<NameSurferEntry>();
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		//	 You fill this in //
		namesArray.clear();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
		namesArray.add(entry);
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		//	 You fill this in //
		// here program updates display. it removs everything and repaints.
		removeAll();
		graphics();
		if(!namesArray.isEmpty()) {
			for(int i =0; i < namesArray.size(); i++) {
				graph(i);
			}
		}
	}
	
	// here is a big code about how to paint graph of name. what color would he be, or where is start and end point
	private void graph(int a) {
		NameSurferEntry name = namesArray.get(a);
		
		for(int i =0; i < (NDECADES-1); i++ ) {
			int one = name.getRank(i);
			int two = name.getRank(i+1);
			double X1 = i*(getWidth()/NDECADES);
			double X2 = (i+1)*(getWidth()/NDECADES);
			double y1 = 0;
			double y2 = 0;
			if(one==0&&two==0){
				y1 = getHeight() - GRAPH_MARGIN_SIZE;
				y2 = getHeight() - GRAPH_MARGIN_SIZE;
			}else if(one==0) {
				y1 = getHeight() - GRAPH_MARGIN_SIZE;
				y2 = GRAPH_MARGIN_SIZE + ((getHeight() -2.0* GRAPH_MARGIN_SIZE)/MAX_RANK)*two;
			}else if(two==0) {
				y2 = getHeight() - GRAPH_MARGIN_SIZE;
				y1 = GRAPH_MARGIN_SIZE + ((getHeight() -2.0* GRAPH_MARGIN_SIZE)/MAX_RANK)*one;
			}else {
				y1 = GRAPH_MARGIN_SIZE + ((getHeight() -2.0* GRAPH_MARGIN_SIZE)/MAX_RANK)*one;
				y2 = GRAPH_MARGIN_SIZE + ((getHeight() - 2.0*GRAPH_MARGIN_SIZE)/MAX_RANK)*two;
			}
			GLine line = new GLine(X1,y1,X2,y2);
			String la = name.getName() + " " + Integer.toString(one);
			if(one==0) {
				la = name.getName() + "*";
			}
			
			GLabel label = new GLabel(la, X1, y1);
			
			if(a%4==1) {
				line.setColor(Color.black);
				label.setColor(Color.black);
			}else if(a%4==2) {
				line.setColor(Color.red);
				label.setColor(Color.red);
			}else if(a%4==3) {
				line.setColor(Color.blue);
				label.setColor(Color.blue);
			}else {
				line.setColor(Color.yellow);
				label.setColor(Color.yellow);
			}
			add(line);
			add(label);
			
			
			
		}
	}
	 // here is body of graphic in the start panel
	private void graphics() {
		decade();
		horizontal();
		labels();
	}
	// here is code of labels of date
	private void labels() {
		int date = START_DECADE;
		for(int i = 0; i < NDECADES; i++) {
			double x =  GRAPH_MARGIN_SIZE/4 + i*getWidth()/NDECADES;
			double y = getHeight() -  GRAPH_MARGIN_SIZE/4;
			String str = Integer.toString(date);
			add(new GLabel(str,x,y));
			date = date+10;
		}
	}
	// this is code of horizontal lines
	private void horizontal() {
		double y0 = GRAPH_MARGIN_SIZE;
		double x0 = 0, x1 = getWidth();
		add(new GLine(x0, y0, x1, y0));
		double y1 = getHeight() -  GRAPH_MARGIN_SIZE;
		add(new GLine(x0, y1, x1, y1));
	}
	// this is code of vertical lines
	private void decade() {
		for (int i = 0; i < NDECADES; i++) {
			double x = i * getWidth() / NDECADES;
			double y0 = 0, y1 = getHeight();
			
			add(new GLine(x, y0, x, y1));
		}
	}
	
	
	
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) {
		
	}
	public void componentMoved(ComponentEvent e) {
		
	}
	public void componentResized(ComponentEvent e) { 
		update(); 
	}
	public void componentShown(ComponentEvent e) { 
		
	}
}
