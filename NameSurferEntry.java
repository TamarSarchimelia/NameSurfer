
/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears in the data
	 * file. Each line begins with the name, which is followed by integers giving
	 * the rank of that name for each decade.
	 */
	private String name;
	private int t = 0;
	private int[] rayting = new int[NDECADES];

	public NameSurferEntry(String line) {
		/*
		String[] s2=line.split(" ");
		name = s2[0];
		for (int i=1;i<s2.length;i++) {
			rayting[i-1]=Integer.parseInt(s2[i]);
		}
		*/
		
		// You fill this in //
		// here i tokeniz line for names and ranks, and also save it;
		StringTokenizer st = new StringTokenizer(line," ");
		name = st.nextToken();
		//System.out.println(name);
		while (st.hasMoreTokens()) {
			String s1=st.nextToken();
			//System.out.println(t+"=" +s1);
			rayting[t] = Integer.parseInt(s1);
			t++;
		}

	}

	/* Method: getName() */
	/**
	 * Returns the name associated with this entry.
	 */
	public String getName() {
		// You need to turn this stub into a real implementation //

		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular decade. The decade
	 * value is an integer indicating how many decades have passed since the first
	 * year in the database, which is given by the constant START_DECADE. If a name
	 * does not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		// You need to turn this stub into a real implementation //
		return rayting[decade];
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a NameSurferEntry.
	 */
	public String toString() {
		// here i wrote information in one line
		// You need to turn this stub into a real implementation //
		String information = "\"" + name + " [ ";
		for (int i = 0; i < NDECADES; i++) {
			information += rayting[i] + " ";
		}
		information += "]\"";
		return information;
	}
}
