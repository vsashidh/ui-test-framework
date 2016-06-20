package com.fmi.support;

public class EnumUtils {
	public static <T extends Enum<T> & EnumInterface> T getEnum(Class<T> enumClass,String text){
		for (T v : enumClass.getEnumConstants()) {
			if(v.getText().equalsIgnoreCase(text)) return v;	
		}
		throw new IllegalArgumentException();
	}
}
