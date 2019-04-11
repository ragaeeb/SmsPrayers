/*
 * @(#)IslamicFinderFields.java	1.0	05/12/09
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
package model.processor.target.structs;

/**
 * Parameters that control how prayer times are calculated in the Islamic Finder site.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class IslamicFinderFields
{
	/** A field that is not set with a specific value (thus the default value will be used by the site). */
	public static final String BLANK = "";

	/** The calculation method used. */
	protected String calculationMethod;

	/** The prayer change time value. */
	protected String changeTime;

	/** The city the prayer times are being calculated for. */
	protected String city;

	/** The country that contains the city and state. */
	protected String country;

	/** The date the request was made. */
	protected String currentDate;

	/** Many countries try to adopt their work time by subtracting from their clocks one hour in the fall and winter seasons. */
	protected String dayL;

	/** Day lights savings use. */
	protected String dayLight;

	/** Day light self-change value. */
	protected String dayLightSelfChange;

	/** Dhuhr prayer interval. Dhuhr is between the declining of the sun and Asr. */
	protected String dhuhrInterval;

	/** Fajr prayer morning twilight angle value. Generally, using smaller twilight angles will produce later Fajr times and earlier Isha times. Astronomical twilight has a value of 18 degrees. */
	protected String fajrTwilight;

	/** The ID. */
	protected String id;

	/** The Isha prayer interval. */
	protected String ishaInterval;

	/** Isha prayer evening (dusk) twilight angle value. Astronomical twilight has a value of 18 degrees. */
	protected String ishaTwilight;

	/** Juristic method (Shafi or Hanfi). */
	protected String juristicMethod;

	/** The language the data should be displayed in. */
	protected String language;

	/** The latitude value used in the calculation. */
	protected String latitude;

	/** The longitude value used in the calculation. */
	protected String longitude;

	/** The Maghrib prayer interval value. */
	protected String maghribInterval;

	/** Is prayer customization on? */
	protected String prayerCustomize;

	/** The prayer time requested date. */
	protected String requestedDate;

	/** The state/province that contains the city. */
	protected String state;

	/** The time-zone the prayer times are being calculated for. */
	protected String timeZone;

	/** The zip code or postal code used to locate the exact area to calculate prayer times for. */
	protected String zipCode;


	/**
	 * Creates an instance of this class so that the Islamic Finder fields can be set and
	 * retrieved as necessary. Initially, all the fields are empty.
	 */
	public IslamicFinderFields()
	{
		this.zipCode = BLANK;
		this.timeZone = BLANK;
		this.state = BLANK;
		this.requestedDate = BLANK;
		this.prayerCustomize = BLANK;
		this.maghribInterval = BLANK;
		this.longitude = BLANK;
		this.calculationMethod = BLANK;
		this.changeTime = BLANK;
		this.city = BLANK;
		this.country = BLANK;
		this.currentDate = BLANK;
		this.dayL = BLANK;
		this.dayLight = BLANK;
		this.dayLightSelfChange = BLANK;
		this.dhuhrInterval = BLANK;
		this.fajrTwilight = BLANK;
		this.id = BLANK;
		this.ishaInterval = BLANK;
		this.ishaTwilight = BLANK;
		this.juristicMethod = BLANK;
		this.language = BLANK;
		this.latitude = BLANK;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		boolean result = false;

		try {
			IslamicFinderFields i = (IslamicFinderFields)obj;
			boolean cm = i.calculationMethod.equals(calculationMethod);
			boolean ct = i.changeTime.equals(changeTime);
			boolean cy = i.city.equals(city);
			boolean cn = i.country.equals(country);
			boolean cd = i.currentDate.equals(currentDate);
			boolean dl = i.dayL.equals(dayL);
			boolean dlight = i.dayLight.equals(dayLight);
			boolean dayLS = i.dayLightSelfChange.equals(dayLightSelfChange);
			boolean di = i.dhuhrInterval.equals(dhuhrInterval);
			boolean ft = i.fajrTwilight.equals(fajrTwilight);
			boolean id = i.id.equals(this.id);
			boolean ii = i.ishaInterval.equals(ishaInterval);
			boolean it = i.ishaTwilight.equals(ishaTwilight);
			boolean jm = i.juristicMethod.equals(juristicMethod);
			boolean l = i.language.equals(language);
			boolean lo = i.longitude.equals(longitude);
			boolean lt = i.latitude.equals(latitude);
			boolean mi = i.maghribInterval.equals(maghribInterval);
			boolean pc = i.prayerCustomize.equals(prayerCustomize);
			boolean rd = i.requestedDate.equals(requestedDate);
			boolean st = i.state.equals(state);
			boolean tz = i.timeZone.equals(timeZone);
			boolean z = i.zipCode.equals(zipCode);

			result = cm && ct && cy && cn && cd && dl && dlight && dayLS && di && ft && id && ii &&
			it && jm && l && lo && lt && mi && pc && rd && st && tz && z;
		}

		catch (ClassCastException ic)
		{
		}

		return result;
	}


	/**
	 * Retrieves the calculation method used.<br>
	 * [Organization, Angle of the sun under the horizon (Fajr twilight), Angle of the sun under the horizon (Isha twilight), Region]:<br>
	 * [University Of Islamic Sciences, Karachi, 18 Degrees, 18 Degrees, Pakistan, Bangladesh, India, Afghanistan, Parts of Europe]<br>
	 * [North America, 15 Degrees, 15 Degrees, Parts of the USA, Canada, Parts of the UK]<br>
	 * [Muslim World League, 18 Degrees, 17 Degrees, Europe, The Far East, Parts of the USA]<br>
	 * [Umm Al-Qura Committee, 18.5 Degrees (19 degrees before 1430 Hijri), 90 minutes after the Sunset Prayer - 120 minutes (in Ramadan only), The Arabian Peninsula]<br>
	 * [Egyptian General Authority of Survey, 19.5 Degrees, 17.5 Degrees, Africa, Syria, Iraq, Lebanon, Malaysia, Parts of the USA] 
	 * @return The calculation method used to determine the prayer times.
	 */
	public String getCalculationMethod()
	{
		return calculationMethod;
	}


	/**
	 * Retrieves the prayer change time value.
	 * @return The prayer change time specified.
	 */
	public String getChangeTime()
	{
		return changeTime;
	}


	/**
	 * Retrieves the city the prayer times are associated with.
	 * @return The city the prayer times are being calculated for.
	 */
	public String getCity()
	{
		return city;
	}


	/**
	 * Retrieves the country that contains the state and city.
	 * @return The country that contains the state and city the prayer times are being
	 * calculated for.
	 */
	public String getCountry()
	{
		return country;
	}


	/**
	 * Retrieves the current date specified.
	 * @return The current date specified.
	 */
	public String getCurrentDate()
	{
		return currentDate;
	}

	/**
	 * Retrieves the value of the day light use.
	 * @return The day light use value.
	 */
	public String getDayL()
	{
		return dayL;
	}


	/**
	 * Retrieves the day lights savings value.
	 * @return The day lights savings value.
	 */
	public String getDayLight()
	{
		return dayLight;
	}


	/**
	 * Retrieves the day lights self change value.
	 * @return The value associated with the day lights self change.
	 */
	public String getDayLightSelfChange()
	{
		return dayLightSelfChange;
	}


	/**
	 * Retrieves the Dhuhr prayer time. The default is 1 minute after Zawal. This value specifies
	 * how many minutes after Zawal the Dhuhr prayer is.
	 * @return The Dhuhr prayer time parameter.
	 */
	public String getDhuhrInterval()
	{
		return dhuhrInterval;
	}

	/**
	 * Retrieves the Fajr twilight angle.
	 * @return The Fajr twilight angle being used for the calculation.
	 */
	public String getFajrTwilight()
	{
		return fajrTwilight;
	}


	/**
	 * Retrieves the ID.
	 * @return The ID being used.
	 */
	public String getId()
	{
		return id;
	}


	/**
	 * Retrieves the Isha interval value.
	 * @return The Isha prayer interval.
	 */
	public String getIshaInterval()
	{
		return ishaInterval;
	}


	/**
	 * Retrieves the Isha twilight angle value.
	 * @return The Isha twilight angle value.
	 */
	public String getIshaTwilight()
	{
		return ishaTwilight;
	}


	/**
	 * Retrieves the Juristic method being used to calculate the prayer times. The only difference is in the Asr prayer. In the standard method (which is used by imamas Shafi, Hanbali, and Malki) the Asr prayer time starts when the shadow of an object is equivalent to its height. Whereas in the Hanafi method the Asr prayer time starts when the shadow of an object is twice its height. 
	 * @return The Juristic method used to calculate the prayer times.
	 */
	public String getJuristicMethod()
	{
		return juristicMethod;
	}


	/**
	 * Retrieves the language being used.
	 * @return The language the prayer times and data are going to be reported in.
	 */
	public String getLanguage()
	{
		return language;
	}


	/**
	 * Retrieves the latitude value being used in the prayer time calculations. Latitude, usually
	 * denoted by the Greek letter phi gives the location of a place on Earth (or other
	 * planetary body) north or south of the equator.
	 * @return The latitude value being used to calculate the prayer times.
	 */
	public String getLatitude()
	{
		return latitude;
	}


	/**
	 * Retrieves the longitude value being used in the prayer time calculations. Longitude
	 * is the geographic coordinate most commonly used in cartography and global navigation for
	 * east-west measurement.
	 * @return The longitude value being used to calculate the prayer times.
	 */
	public String getLongitude()
	{
		return longitude;
	}


	/**
	 * Retrieves the Maghrib prayer time. The default is 1 minute after sunset. This value
	 * specifies how many minutes after sunset the Maghrib prayer is.
	 * @return The Maghrib prayer time parameter.
	 */
	public String getMaghribInterval()
	{
		return maghribInterval;
	}


	/**
	 * Retrieves the prayer time customize value.
	 * @return The value associated with the prayer customize parameter.
	 */
	public String getPrayerCustomize()
	{
		return prayerCustomize;
	}


	/**
	 * Retrieves the requested date value that the prayer times are being calculated for.
	 * @return The requested date that the prayer times are being calculated for.
	 */
	public String getRequestedDate()
	{
		return requestedDate;
	}


	/**
	 * Retrieves the state containing the specified city. A province is a territorial unit,
	 * almost always an administrative division, within a country or state.
	 * @return The state/province that contains the city that we are calculating the prayer
	 * times for.
	 */
	public String getState()
	{
		return state;
	}


	/**
	 * Retrieves the time zone being used for the prayer time calculations. A time zone is a
	 * region of the earth that has uniform standard time, usually referred to as the local time.
	 * By convention, time zones compute their local time as an offset from UTC (see also
	 * Greenwich Mean Time). Local time is UTC plus the current time zone offset for the
	 * considered location.
	 * @return The time zone of the area that the prayer times are being calculated for.
	 */
	public String getTimeZone()
	{
		return timeZone;
	}

	/**
	 * Retrieves the zip code or postal code specifying the area that the prayer times are being
	 * calculated for. The ZIP code is the system of postal codes used by the United States
	 * Postal Service (USPS). The letters ZIP, an acronym for Zone Improvement Plan, are properly
	 * written in capital letters and were chosen to suggest that the mail travels more
	 * efficiently, and therefore more quickly, when senders use the code. The basic format
	 * consists of five numerical digits. An extended ZIP + 4 code includes the five digits of
	 * the ZIP code, a hyphen, and four more digits that determine a more precise location than
	 * the ZIP code alone. The term ZIP Code was originally registered as a servicemark (a
	 * type of trademark) by the U.S. Postal Service, but its registration has since expired.
	 * @return The zip code or postal code specifying the area that we are calculating the
	 * prayer times for.
	 */
	public String getZipCode()
	{
		return zipCode;
	}

	/**
	 * Sets the calculation method to be the specified value.
	 * @param calculationMethod The new calculation method to use.
	 */
	public void setCalculationMethod(String calculationMethod)
	{
		this.calculationMethod = calculationMethod;
	}


	/**
	 * Sets the prayer change time to the specified value.
	 * @param changeTime The new prayer change time to use.
	 */
	public void setChangeTime(String changeTime)
	{
		this.changeTime = changeTime;
	}


	/**
	 * Sets the city to the specified value.
	 * @param city The city to calculate the prayer times for.
	 */
	public void setCity(String city)
	{
		this.city = city;
	}


	/**
	 * Sets the country to the specified value.
	 * @param country The country containing the city and state to calculate the prayer times for.
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}


	/**
	 * Sets the current date to the specified value.
	 * @param currentDate The current date in the proper format.
	 */
	public void setCurrentDate(String currentDate)
	{
		this.currentDate = currentDate;
	}

	/**
	 * Sets the day light use to the specified value.
	 * @param dayL The new day light use value.
	 */
	public void setDayL(String dayL)
	{
		this.dayL = dayL;
	}


	/**
	 * Sets the day light savings to the specified value.
	 * @param dayLight The new day light savings value.
	 */
	public void setDayLight(String dayLight)
	{
		this.dayLight = dayLight;
	}


	/**
	 * Sets the day light self change to the specified value.
	 * @param dayLightSelfChange The new day light self change value.
	 */
	public void setDayLightSelfChange(String dayLightSelfChange)
	{
		this.dayLightSelfChange = dayLightSelfChange;
	}


	/**
	 * Sets the Dhuhr interval to the specified value.
	 * @param dhuhrInterval The amount of minutes after Zawal that the new Dhuhr interval is.
	 */
	public void setDhuhrInterval(String dhuhrInterval)
	{
		this.dhuhrInterval = dhuhrInterval;
	}


	/**
	 * Sets the Fajr twilight angle.
	 * @param fajrTwilight The new Fajr twilight angle.
	 */
	public void setFajrTwilight(String fajrTwilight)
	{
		this.fajrTwilight = fajrTwilight;
	}


	/**
	 * Sets the ID to the specified value.
	 * @param id The new ID value.
	 */
	public void setId(String id)
	{
		this.id = id;
	}


	/**
	 * Sets the Isha interval to the specified value.
	 * @param ishaInterval The new Isha interval value.
	 */
	public void setIshaInterval(String ishaInterval)
	{
		this.ishaInterval = ishaInterval;
	}


	/**
	 * Sets the Isha twilight angle to the specified value.
	 * @param ishaTwilight The new Isha twilight angle.
	 */
	public void setIshaTwilight(String ishaTwilight)
	{
		this.ishaTwilight = ishaTwilight;
	}


	/**
	 * Sets the Juristic method to the specified value.
	 * @param juristicMethod The new Juristic calculation method.
	 */
	public void setJuristicMethod(String juristicMethod)
	{
		this.juristicMethod = juristicMethod;
	}


	/**
	 * Sets the language to the specified value.
	 * @param language The language to use.
	 */
	public void setLanguage(String language)
	{
		this.language = language;
	}


	/**
	 * Sets the latitude to the specified value.
	 * @param latitude The new value of the latitude.
	 */
	public void setLatitude(String latitude)
	{
		this.latitude = latitude;
	}


	/**
	 * Sets the longitude to the specified value.
	 * @param longitude The new value of the longitude.
	 */
	public void setLongitude(String longitude)
	{
		this.longitude = longitude;
	}


	/**
	 * Sets the Maghrib interval to the specified value.
	 * @param maghribInterval The new value of the Maghrib interval.
	 */
	public void setMaghribInterval(String maghribInterval)
	{
		this.maghribInterval = maghribInterval;
	}


	/**
	 * Sets the prayer customize parameter to the specified value.
	 * @param prayerCustomize The new prayer customize value.
	 */
	public void setPrayerCustomize(String prayerCustomize)
	{
		this.prayerCustomize = prayerCustomize;
	}


	/**
	 * Sets the requested date to the specified value.
	 * @param requestedDate The date to calculate the prayer times for.
	 */
	public void setRequestedDate(String requestedDate)
	{
		this.requestedDate = requestedDate;
	}


	/**
	 * Sets the state to the specified value.
	 * @param state The state/province to use.
	 */
	public void setState(String state)
	{
		this.state = state;
	}


	/**
	 * Sets the time zone to the specified value.
	 * @param timeZone The time-zone to use.
	 */
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}


	/**
	 * Sets the zip code to the specified value.
	 * @param zipCode The zip/postal code to use when calculating the prayer times.
	 */
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

}