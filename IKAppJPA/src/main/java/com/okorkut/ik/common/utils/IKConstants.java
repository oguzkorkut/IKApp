package com.okorkut.ik.common.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Properties;

public class IKConstants {

	public static Properties PROPS = new Properties();
	/**
	 * Number
	 */
	public static DecimalFormat decimalFormat = new DecimalFormat("##0.00000000", new DecimalFormatSymbols(Locale.ENGLISH));
	public static DecimalFormat decimalFormatShort = new DecimalFormat("##0.00", new DecimalFormatSymbols(Locale.ENGLISH));

	public static String serverIP;
	public static String SESSION_USER_IP = "SESSION_USER_IP";

}
