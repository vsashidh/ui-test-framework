package com.fmi.support;

public class EnumUtils {
	public static <T extends Enum<T> & EnumInterface> T getEnum(Class<T> enumClass, String text) {
		for (T v : enumClass.getEnumConstants()) {
			for(String enumTxt : v.getText())
			if (enumTxt.equalsIgnoreCase(text))
				return v;
		}
		throw new IllegalArgumentException();
	}
}
