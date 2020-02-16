package utilities;

import org.apache.log4j.Logger;

public class logCollector {

	// if want to give full capabilities...
	// public static Logger Log = Logger.getLogger(logCollector.class.getName());

	static Logger Log = Logger.getLogger(logCollector.class.getName());

	public static void info(String message) {
		info(message, true);
	}

	public static void info(String message, Boolean alsoSendToSysOut) {
		Log.info(message);

		if (alsoSendToSysOut) {
			System.out.println(message);
		}
	}

	public static void warn(String message) {
		warn(message, true);
	}

	public static void warn(String message, Boolean alsoSendToSysOut) {
		Log.warn(message);

		if (alsoSendToSysOut) {
			System.out.println(message);
		}
	}

	public static void error(String message) {
		error(message, true);
	}

	public static void error(String message, Boolean alsoSendToSysOut) {
		Log.error(message);

		if (alsoSendToSysOut) {
			System.out.println(message);
		}
	}

	public static void debug(String message) {
		debug(message, true);
	}

	public static void debug(String message, Boolean alsoSendToSysOut) {
		Log.debug(message);

		if (alsoSendToSysOut) {
			System.out.println(message);
		}
	}

	public static void fatal(String message) {
		fatal(message, true);
	}

	public static void fatal(String message, Boolean alsoSendToSysOut) {
		Log.fatal(message);

		if (alsoSendToSysOut) {
			System.out.println(message);
		}
	}

}
