package com.yeelight.sdk;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CommonLogger {

    private static final boolean DEBUG = true;
    private static Logger sLogger = Logger.getLogger("YeelightLib");

    public static void debug(String tag, String msg) {
        if (DEBUG) {
            sLogger.log(Level.INFO, tag + ":" + msg);
        }
    }

    public static void debug(String msg) {
        if (DEBUG) {
            sLogger.log(Level.INFO, msg);
        }
    }

    public static void warning(String msg) {
        if (DEBUG) {
            sLogger.warning(msg);
        }
    }
}
