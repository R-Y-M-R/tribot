package scripts.util;

import org.tribot.api.General;

public abstract class Misc {

	public static void ps(String s) {
		General.println("[State] "+s);
	}
	
	/**
	 * Prints debug messages
	 * @param s
	 */
	public static void pd(String s) {
		General.println("[Dev] "+s);
	}
	
	public static void pd(String[] s) {
		for (String msg : s) {
			pd(msg);
		}
	}
	
	public static boolean parseString(String s) {
		if (s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("true")) {
			return true;
		}
		return false;
	}
	
}
