/*
 * @(#)IslamicFinderUrlBuilder.java	1.0	05/12/09
 *
 * Copyright 2009 geniewiz productions. All Rights Reserved. geniewiz productions under exclusive
 * license to Ragaeeb Haq.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of geniewiz productions nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *     
 *   - The code base must not be sold for any profitable financial transactions.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package model.processor.target;

import java.net.MalformedURLException;
import java.net.URL;
import model.processor.structs.PrayerRequestProperties;
import model.processor.target.structs.TranslationIslamicFinderFields;


/**
 * Constructs the IslamicFinder destination URL needed to extract the prayer times.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class IslamicFinderUrlBuilder
{
	/** The main host address to the source database. */
	private static final String PREFIX = "http://www.islamicfinder.org/prayerPrintable.php?";

	/** Separates one parameter from another. */
	private static final String SEPARATOR = "&";

	/** Translates the user's codes to Islamic Prayer field codes. */
	private static TranslationIslamicFinderFields translations;

	/** The character signifying a value for a parameter will be inputted. */
	private static final String VALUE = "=";

	/** The single instance of this factory to create. */
	private static IslamicFinderUrlBuilder instance;


	/**
	 * Initializes this factory object so a proper IslamicFinder URL can be built.
	 */
	private IslamicFinderUrlBuilder()
	{
		translations = new TranslationIslamicFinderFields();

		translations.setCalculationMethod("pmethod");
		translations.setChangeTime("changeTime");
		translations.setCity("city2");
		translations.setCountry("country2");
		translations.setCurrentDate("today_date_flag");
		translations.setDayL("dayl");
		translations.setDayLight("dayLight");
		translations.setDayLightSelfChange("dayLight_self_change");
		translations.setDhuhrInterval("dhuhrInterval");
		translations.setFajrTwilight("fajrTwilight");
		translations.setId("id");
		translations.setIshaInterval("ishaInterval");
		translations.setIshaTwilight("ishaTwilight");
		translations.setJuristicMethod("HanfiShafi");
		translations.setLanguage("lang");
		translations.setLatitude("lati");
		translations.setLongitude("longi");
		translations.setMaghribInterval("maghribInterval");
		translations.setPrayerCustomize("prayerCustomize");
		translations.setRequestedMonth("month");
		translations.setRequestedYear("year");
		translations.setState("state");
		translations.setTimeZone("timez");
		translations.setZipCode("zipcode");
	}


	/**
	 * Constructs the IslamicFinder URL from the request properties specified.
	 * @param properties The prayer request properties that will be used in constructing the URL.
	 * @return A fully constructed IslamicFinder URL with any calculation parameters specified.
	 * @throws MalformedURLException If an invalid URL is generated.
	 */
	public URL build(PrayerRequestProperties properties) throws MalformedURLException
	{
		String full = PREFIX+
		translations.getCity()+VALUE+properties.getData().getCity()+SEPARATOR+
		translations.getState()+VALUE+properties.getData().getState()+SEPARATOR+
		translations.getId()+VALUE+properties.getData().getId()+SEPARATOR+
		translations.getLongitude()+VALUE+properties.getData().getLongitude()+SEPARATOR+
		translations.getLatitude()+VALUE+properties.getData().getLatitude()+SEPARATOR+
		translations.getCountry()+VALUE+properties.getData().getCountry()+SEPARATOR+
		translations.getZipCode()+VALUE+properties.getData().getZipCode()+SEPARATOR+
		translations.getCurrentDate()+VALUE+properties.getData().getCurrentDate()+SEPARATOR+
		translations.getChangeTime()+VALUE+properties.getData().getChangeTime()+SEPARATOR+
		translations.getCalculationMethod()+VALUE+properties.getData().getCalculationMethod()+SEPARATOR+
		translations.getJuristicMethod()+VALUE+properties.getData().getJuristicMethod()+SEPARATOR+
		translations.getDhuhrInterval()+VALUE+properties.getData().getDhuhrInterval()+SEPARATOR+
		translations.getMaghribInterval()+VALUE+properties.getData().getMaghribInterval()+SEPARATOR+
		translations.getDayLight()+VALUE+properties.getData().getDayLight()+SEPARATOR+
		translations.getDayL()+VALUE+properties.getData().getDayL()+SEPARATOR+
		translations.getTimeZone()+VALUE+properties.getData().getTimeZone()+SEPARATOR+
		translations.getDayLightSelfChange()+VALUE+properties.getData().getDayLightSelfChange()+SEPARATOR+
		translations.getPrayerCustomize()+VALUE+properties.getData().getPrayerCustomize()+SEPARATOR+
		translations.getLanguage()+VALUE+properties.getData().getLanguage()+SEPARATOR+
		translations.getFajrTwilight()+VALUE+properties.getData().getFajrTwilight()+SEPARATOR+
		translations.getIshaTwilight()+VALUE+properties.getData().getIshaTwilight()+SEPARATOR+
		translations.getIshaInterval()+VALUE+properties.getData().getIshaInterval()+SEPARATOR+
		translations.getRequestedMonth()+VALUE+properties.getData().getRequestedMonth()+SEPARATOR+
		translations.getRequestedYear()+VALUE+properties.getData().getRequestedYear();

		return new URL(full);
	}


	/**
	 * Retrieves a single instance of this class.
	 * @return a single instance of this class.
	 */
	public static IslamicFinderUrlBuilder getInstance()
	{
		if (instance == null)
			instance = new IslamicFinderUrlBuilder();

		return instance;
	}
}