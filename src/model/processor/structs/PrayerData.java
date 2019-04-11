/*
 * @(#)PrayerData.java	1.0	05/12/09
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
package model.processor.structs;


/**
 * Represents the prayer data for a certain day. In a day there are the five prayers: Fajr, Dhuhr,
 * Asr, Maghrib, and Isha. Another key event is the sunrise, the sunset (is essentially the same
 * as the Maghrib time).
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class PrayerData
{
	/** The time the Asr prayer is. */
	private String asrTime;

	/** The time the Dhuhr prayer is. */
	private String dhuhrTime;

	/** The time the Fajr prayer is. */
	private String fajrTime;

	/** The time the Isha prayer is. */
	private String ishaTime;

	/** The time of the Maghrib prayer. */
	private String maghribTime;

	/** The time of the sunrise (vital during fasting times). */
	private String sunrise;


	/**
	 * Creates an instance of this class and allows insertion and retrieval of prayer data.
	 */
	public PrayerData()
	{
		super();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		boolean result = false;

		try {
			PrayerData i = (PrayerData)obj;

			result = asrTime.equals(i.asrTime) && dhuhrTime.equals(i.dhuhrTime) && fajrTime.equals(i.fajrTime)
			&& ishaTime.equals(i.ishaTime) && maghribTime.equals(i.maghribTime) && sunrise.equals(i.sunrise);
		}

		catch (ClassCastException ic)
		{
		}

		return result;
	}


	/**
	 * Retrieves the stored Asr time.
	 * @return The time of the Asr prayer.
	 */
	public String getAsrTime()
	{
		return asrTime;
	}


	/**
	 * Retrieves the stored Dhuhr time.
	 * @return The time of the Dhuhr prayer.
	 */
	public String getDhuhrTime()
	{
		return dhuhrTime;
	}


	/**
	 * Retrieves the stored Fajr time.
	 * @return The time of the Fajr prayer.
	 */
	public String getFajrTime()
	{
		return fajrTime;
	}


	/**
	 * Retrieves the stored Isha time.
	 * @return The time of the Isha prayer.
	 */
	public String getIshaTime()
	{
		return ishaTime;
	}


	/**
	 * Retrieves the stored Maghrib time.
	 * @return The time of the Maghrib prayer.
	 */
	public String getMaghribTime()
	{
		return maghribTime;
	}


	/**
	 * Retrieves the stored sunrise time.
	 * @return The time of the sunrise.
	 */
	public String getSunrise()
	{
		return sunrise;
	}


	/**
	 * Sets the Asr time to the specified value.
	 * @param asrTime The new value of the Asr prayer.
	 */
	public void setAsrTime(String asrTime)
	{
		this.asrTime = asrTime;
	}


	/**
	 * Sets the Dhuhr time to the specified value.
	 * @param dhuhrTime The new value of the Dhuhr prayer.
	 */
	public void setDhuhrTime(String dhuhrTime)
	{
		this.dhuhrTime = dhuhrTime;
	}


	/**
	 * Sets the Fajr time to the specified value.
	 * @param fajrTime The new value of the Fajr prayer.
	 */
	public void setFajrTime(String fajrTime)
	{
		this.fajrTime = fajrTime;
	}


	/**
	 * Sets the Isha time to the specified value.
	 * @param ishaTime The new value of the Isha prayer.
	 */
	public void setIshaTime(String ishaTime)
	{
		this.ishaTime = ishaTime;
	}


	/**
	 * Sets the Maghrib time to the specified value.
	 * @param maghribTime The new value of the Maghrib prayer.
	 */
	public void setMaghribTime(String maghribTime)
	{
		this.maghribTime = maghribTime;
	}


	/**
	 * Sets the sunrise time to the specified value.
	 * @param sunrise The new value of the sunrise.
	 */
	public void setSunrise(String sunrise)
	{
		this.sunrise = sunrise;
	}
}