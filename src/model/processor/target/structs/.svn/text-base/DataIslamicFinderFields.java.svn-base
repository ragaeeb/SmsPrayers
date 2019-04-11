/*
 * @(#)DataIslamicFinderFields.java	1.0	05/12/09
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

import java.util.Calendar;
import java.util.Date;

/**
 * Additional data fields used to retrieve specific prayer time data from the IslamicFinder
 * website.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class DataIslamicFinderFields extends IslamicFinderFields
{
	/** The default value for the change-time parameter of IslamicFinder. */
	private static final String CHANGE_TIME_VALUE = "16";

	/** An enabled value for a parameter in the URL. */
	private static final String ONE = "1";

	/** A disabled value for a parameter in the URL. */
	private static final String ZERO = "0";

	/** Used to manipulate date and time information efficiently. */
	private Calendar calendar;



	/**
	 * Creates an instance of this class so additional data fields for the Islamic Finder
	 * website can be set and retrieved.
	 */
	public DataIslamicFinderFields()
	{
		super();

		this.changeTime = CHANGE_TIME_VALUE;
		this.dayL = ONE;
		this.dayLight = ONE;
		this.fajrTwilight = ZERO;
		this.calendar = Calendar.getInstance();
	}


	/**
	 * Gets the day of month specified in the request.
	 * @return The day of month specified in the request.
	 */
	public int getRequestedDay()
	{
		return calendar.get(Calendar.DAY_OF_MONTH);
	}


	/**
	 * Gets the month specified in the request.
	 * @return The month specified in the request.
	 */
	public int getRequestedMonth()
	{
		return calendar.get(Calendar.MONTH)+1;
	}


	/**
	 * Gets the year specified in the request.
	 * @return The year specified in the request.
	 */
	public int getRequestedYear()
	{
		return calendar.get(Calendar.YEAR);
	}


	/**
	 * Sets the prayer time request date to the specified one.
	 * @param d The new date to set for the prayer time.
	 */
	public void setRequestedDate(Date d)
	{
		calendar.setTime(d);
	}
}