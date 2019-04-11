/*
 * @(#)QueryResults.java	1.0	05/12/09
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
package model.processor;

import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.processor.structs.PrayerData;
import model.processor.target.structs.IslamicFinderFields;


/**
 * Table used to store all the prayer time data extracted from a web page.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class QueryResults extends Hashtable<Integer, PrayerData>
{
	/** Header to specify the calculation method being used. */
	private static final String CALC_METHOD = "Calculation Method:";

	/** The prefix key telling us that following is some time data. */
	private static final String DATA_KEY = "IslamicData";

	/** The prefix key telling us that following is some time calculation methodology information. */
	private static final String HEADER_KEY = "IslamicHeader";

	/** Table code specifying a time data. */
	private static final String ISLAMIC_DATA_TD = "<TD class = \"IslamicData\"";

	/** Header to specify the Juristic method being used in the time calculation. */
	private static final String JURISTIC = "Juristic Method:";

	/** Header to specify the location the time is being calculated for. */
	private static final String LOCATION = "Location:";

	/** Used to subclass superclass. */
	private static final long serialVersionUID = 1L;

	/** The actual calculation method being used. */
	private String calculationMethod;

	/** The actual juristic method being used. */
	private String juristicMethod;

	/** The actual location the time was calculated for. */
	private String location;


	/**
	 * Creates and populates this table using the specified parsed prayer time data.
	 * @param data The prayer time data to populate this table with.
	 */
	public QueryResults(List<String> data)
	{
		super();
		process(data);
	}


	/**
	 * Retrieves the extracted calculation method used.
	 * @return The calculation method used to determine the prayer times.
	 */
	public String getCalculationMethod()
	{
		return calculationMethod;
	}


	/**
	 * Retrieves the extracted Juristic method used.
	 * @return The Juristic method used to determine the prayer times.
	 */
	public String getJuristicMethod()
	{
		return juristicMethod;
	}


	/**
	 * Retrieves the extracted location the prayer times are for.
	 * @return The location that the prayer times were calculated for.
	 */
	public String getLocation()
	{
		return location;
	}


	/**
	 * Parses and populates the prayer time data specified.
	 * @param data The prayer time data to populate this table with.
	 */
	private void process(List<String> data)
	{
		for (String s: data)
		{
			if ( s.contains(HEADER_KEY) )
				processHeader(s);

			else if ( s.contains(DATA_KEY) )
				processData(s);
		}
	}


	/**
	 * Processes the prayer time data specified and populates this table with it.
	 * @param s The source containing the prayer time data to populate this table with.
	 */
	private void processData(String s)
	{
		if ( !s.startsWith(ISLAMIC_DATA_TD) )
		{
			int x = s.indexOf(ISLAMIC_DATA_TD);

			if (x != -1)
				s = s.substring( s.indexOf(ISLAMIC_DATA_TD) );
		}

		Pattern patt = Pattern.compile(">\\d{1,2}+</TD>");
		Matcher m = patt.matcher(s);

		int key = -1;

		while (m.find())
			key = Integer.parseInt( s.substring(m.start()+1, m.end()-"</TD>".length()) );

		patt = Pattern.compile("\\d{1,2}+:\\d{2}+");
		m = patt.matcher(s);
		PrayerData p = new PrayerData();

		if (m.find())
		{
			String fajr = s.substring(m.start(), m.end());
			p.setFajrTime(fajr);

			m.find();
			String sunrise = s.substring(m.start(), m.end());
			p.setSunrise(sunrise);

			m.find();
			String dhuhr = s.substring(m.start(), m.end());
			p.setDhuhrTime(dhuhr);

			m.find();
			String asr = s.substring(m.start(), m.end());
			p.setAsrTime(asr);

			m.find();
			String maghrib = s.substring(m.start(), m.end());
			p.setMaghribTime(maghrib);

			m.find();
			String isha = s.substring(m.start(), m.end());
			p.setIshaTime(isha);
		}

		if (key != -1)
			this.put(key, p);
	}


	/**
	 * Processes the header information specified and populates this table with it.
	 * @param s The source containing the prayer time calculation information that we need to
	 * populate this table with.
	 */
	private void processHeader(String s)
	{
		s = s.replace("<td class=\"IslamicHeader\">", IslamicFinderFields.BLANK);
		s = s.replace("<b>", IslamicFinderFields.BLANK);
		s = s.replace("</td>", IslamicFinderFields.BLANK);
		s = s.replace("<br>", IslamicFinderFields.BLANK);
		s = s.replace("</b>", IslamicFinderFields.BLANK);
		s = s.replace("  ", " ");
		s = s.trim();

		boolean location = s.contains(LOCATION);
		boolean calcMethod = s.contains(CALC_METHOD);
		boolean juristic = s.contains(JURISTIC);

		if (location)
			this.location = s;

		else if (calcMethod)
			this.calculationMethod = s;

		else if (juristic)
			this.juristicMethod = s;
	}
}