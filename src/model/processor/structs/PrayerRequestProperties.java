/*
 * @(#)PrayerRequestProperties.java	1.0	05/12/09
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

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
import javax.mail.Message;
import javax.mail.MessagingException;
import model.eventHandlers.ProcessorGenerator;
import model.processor.target.IslamicFinderUrlBuilder;
import model.processor.target.structs.DataIslamicFinderFields;
import model.processor.target.structs.IslamicFinderFields;


/**
 * Properties of a prayer time request sent.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class PrayerRequestProperties extends RequestProperties
{
	/** Codes that are specified in text messages that we need to convert to IslamicFinder equivalents. */
	private static IslamicFinderFields codes;

	/** Separates one field property from another in the text message request. */
	private static final String DELIMITER = " \n";

	/** Used to format the date if one is specified. */
	private static DateFormat formatter;

	/** The required format of the date. */
	private static final String REQUIRED_FORMAT = "MM.dd.yyyy";

	/** Builds the target URL by assembling all the properties of this class. */
	private IslamicFinderUrlBuilder builder;

	/** The data fields controlling the prayer time calculation in the target URL. */
	private DataIslamicFinderFields data;


	/**
	 * Parses and populates the prayer time request properties from the message specified.
	 * @param m The message request containing the parameters of the prayer times.
	 * @throws MessagingException If there are problems sending the response back.
	 * @throws IOException If there is a problem accessing the external resources to process
	 * the message request.
	 * @throws ParseException If the contents of the requests message are not formatted properly.
	 */
	public PrayerRequestProperties(Message m) throws MessagingException, IOException, ParseException
	{
		super(m);

		if ( !m.isMimeType(ProcessorGenerator.EXPECTED_BODY_TYPE) )
			throw new IllegalArgumentException("Invalid message type.");

		formatter = new SimpleDateFormat(REQUIRED_FORMAT);
		builder = IslamicFinderUrlBuilder.getInstance();

		if (codes == null)
		{
			codes = new IslamicFinderFields();
			initializeCodes();
		}

		data = new DataIslamicFinderFields();
		data.setRequestedDate( m.getSentDate() );

		String body = (String)m.getContent();
		processFields(body);
	}


	/**
	 * Retrieves the data fields controlling the prayer time calculation in the target URL.
	 * @return The data fields controlling the prayer time calculation in the target URL.
	 */
	public DataIslamicFinderFields getData()
	{
		return data;
	}


	/* (non-Javadoc)
	 * @see model.processor.RequestProperties#getTargetURL()
	 */
	public URL getTargetURL() throws MalformedURLException
	{
		return builder.build(this);
	}


	/**
	 * Extracts the specified fields from the request and populates this class.
	 * @param body The contents of the message containing the fields.
	 * @throws ParseException If the contents of the requests message are not formatted properly.
	 */
	private void processFields(String body) throws ParseException
	{
		StringTokenizer tk = new StringTokenizer(body.toLowerCase(), DELIMITER);

		while ( tk.hasMoreTokens() )
		{
			String parameter = tk.nextToken().trim();
			String value;

			if ( parameter.startsWith( codes.getCalculationMethod() ) ) // check if a calculation method was specified by the user...
			{
				value = extractValue( codes.getCalculationMethod(), parameter ); // if it was, extract the actual calculation method specified
				data.setCalculationMethod(value); // and set it
			}

			else if ( parameter.startsWith( codes.getChangeTime() ) )
			{
				value = extractValue( codes.getChangeTime(), parameter );
				data.setChangeTime(value);
			}

			else if ( parameter.startsWith( codes.getCity() ) )
			{
				value = extractValue( codes.getCity(), parameter );
				data.setCity(value);
			}

			else if ( parameter.startsWith( codes.getCountry() ) )
			{
				value = extractValue( codes.getCountry(), parameter );
				data.setCountry(value);
			}

			else if ( parameter.startsWith( codes.getCurrentDate() ) )
			{
				value = extractValue( codes.getCurrentDate(), parameter );
				data.setCurrentDate(value);
			}

			else if ( parameter.startsWith( codes.getDayL() ) )
			{
				value = extractValue( codes.getDayL(), parameter );
				data.setDayL(value);
			}

			else if ( parameter.startsWith( codes.getDayLight() ) )
			{
				value = extractValue( codes.getDayLight(), parameter );
				data.setDayLight(value);
			}

			else if ( parameter.startsWith( codes.getDayLightSelfChange() ) )
			{
				value = extractValue( codes.getDayLightSelfChange(), parameter );
				data.setDayLightSelfChange(value);
			}

			else if ( parameter.startsWith( codes.getDhuhrInterval() ) )
			{
				value = extractValue( codes.getDhuhrInterval(), parameter );
				data.setDhuhrInterval(value);
			}

			else if ( parameter.startsWith( codes.getFajrTwilight() ) )
			{
				value = extractValue( codes.getFajrTwilight(), parameter );
				data.setFajrTwilight(value);
			}

			else if ( parameter.startsWith( codes.getId() ) )
			{
				value = extractValue( codes.getId(), parameter );
				data.setId(value);
			}

			else if ( parameter.startsWith( codes.getIshaInterval() ) )
			{
				value = extractValue( codes.getIshaInterval(), parameter );
				data.setIshaInterval(value);
			}

			else if ( parameter.startsWith( codes.getIshaTwilight() ) )
			{
				value = extractValue( codes.getIshaTwilight(), parameter );
				data.setIshaTwilight(value);
			}

			else if ( parameter.startsWith( codes.getJuristicMethod() ) )
			{
				value = extractValue( codes.getJuristicMethod(), parameter );
				data.setJuristicMethod(value);
			}

			else if ( parameter.startsWith( codes.getLanguage() ) )
			{
				value = extractValue( codes.getLanguage(), parameter );
				data.setLanguage(value);
			}

			else if ( parameter.startsWith( codes.getLatitude() ) )
			{
				value = extractValue( codes.getLatitude(), parameter );
				data.setLatitude(value);
			}

			else if ( parameter.startsWith( codes.getLongitude() ) )
			{
				value = extractValue( codes.getLongitude(), parameter );
				data.setLongitude(value);
			}

			else if ( parameter.startsWith( codes.getMaghribInterval() ) )
			{
				value = extractValue( codes.getMaghribInterval(), parameter );
				data.setMaghribInterval(value);
			}

			else if ( parameter.startsWith( codes.getPrayerCustomize() ) )
			{
				value = extractValue( codes.getPrayerCustomize(), parameter );
				data.setPrayerCustomize(value);
			}

			else if ( parameter.startsWith( codes.getRequestedDate() ) )
			{
				value = extractValue( codes.getRequestedDate(), parameter );
				data.setRequestedDate( formatter.parse(value) );
			}

			else if ( parameter.startsWith( codes.getState() ) )
			{
				value = extractValue( codes.getState(), parameter );
				data.setState(value);
			}

			else if ( parameter.startsWith( codes.getTimeZone() ) )
			{
				value = extractValue( codes.getTimeZone(), parameter );
				data.setTimeZone(value);
			}

			else if ( parameter.startsWith( codes.getZipCode() ) )
			{
				value = extractValue( codes.getZipCode(), parameter );
				data.setZipCode(value);
			}
		}
	}


	/**
	 * Extracts the value of the specified code from the source string.
	 * @param code The value of the code to extract.
	 * @param full The full string containing the code along with the code value.
	 * @return the extracted value of the code specified in the source string.
	 */
	private static String extractValue(String code, String full)
	{
		return full.substring( code.length() );
	}


	/**
	 * Initializes the codes with their respective abbreviations and values.
	 */
	private static final void initializeCodes()
	{
		codes.setCalculationMethod("cm");
		codes.setChangeTime("ct");
		codes.setCity("cy");
		codes.setCountry("cn");
		codes.setCurrentDate("dt");
		codes.setDayL("dy");
		codes.setDayLight("dl");
		codes.setDayLightSelfChange("dc");
		codes.setDhuhrInterval("di");
		codes.setFajrTwilight("ft");
		codes.setId("id");
		codes.setIshaInterval("ii");
		codes.setIshaTwilight("it");
		codes.setJuristicMethod("jm");
		codes.setLanguage("ln");
		codes.setLatitude("la");
		codes.setLongitude("lo");
		codes.setMaghribInterval("mi");
		codes.setPrayerCustomize("pc");
		codes.setRequestedDate("rd");
		codes.setState("st");
		codes.setTimeZone("tz");
		codes.setZipCode("zc");
	}
}