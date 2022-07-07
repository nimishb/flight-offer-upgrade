package main.java.com.nimish.sahaj.flightoffer.util;

import main.java.com.nimish.sahaj.flightoffer.constant.FareClassType;
import main.java.com.nimish.sahaj.flightoffer.enums.FareClassRange;

public class FareClassUtil {
	
	public static String getOfferByFareClass(String fareClass) {
		
		Character fareClassChar = fareClass.charAt(0);
		
		return (fareClassChar >= FareClassType.A && fareClassChar <=FareClassType.E)?FareClassRange.A_E.getLabel():
			(fareClassChar >=FareClassType.F && fareClassChar <= FareClassType.K)?FareClassRange.F_K.getLabel():
				(fareClassChar >= FareClassType.L && fareClassChar <= FareClassType.R)?FareClassRange.L_R.getLabel():
					FareClassRange.S_Z.getLabel();
	}
}
