/*
 * @(#)PrayerRequestProcessor.java	1.0	05/12/09
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

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import model.processor.structs.PrayerData;
import model.processor.structs.PrayerRequestProperties;
import model.processor.target.IslamicFinderParser;
import model.server.SmtpServer;


/**
 * Processes a request sent for prayer times.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class PrayerRequestProcessor extends RequestProcessor
{
	/**
	 * Creates a request processor instance that will process the specified message and send a
	 * response through the specified SMTP server.
	 * @param received The message request to process.
	 * @param smtpServer The SMTP server that will be used to process the request.
	 * @throws MessagingException If there are problems sending the response back.
	 * @throws IOException If there is a problem accessing the external resources to process
	 * the message request.
	 * @throws ParseException If the contents of the requests message are not formatted properly.
	 */
	public PrayerRequestProcessor(MimeMessage received, SmtpServer smtpServer) throws MessagingException, IOException, ParseException
	{
		super(received, smtpServer);
		this.properties = new PrayerRequestProperties(received);
	}


	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		try
		{
			URL url = properties.getTargetURL(); // builds the URL that we'll need to go to in order to retrieve the required data
			IslamicFinderParser parser = new IslamicFinderParser(); // parses the target URL's page
			QueryResults results = new QueryResults( parser.parseTableRows(url) ); // insert parsed data into table
			int key = properties.getData().getRequestedDay(); // get the specific day that was asked for by the user rather than the entire list of data

			PrayerData p = results.get(key); // get the data for the specific day

			if (p != null)
			{
				String response = "F: "+p.getFajrTime() + "\n";
				response += "S: "+p.getSunrise() + "\n";
				response += "D: "+p.getDhuhrTime() + "\n";
				response += "A: "+p.getAsrTime() + "\n";
				response += "M: "+p.getMaghribTime() + "\n";
				response += "I: "+p.getIshaTime();

				this.response.process("Prayer Times", response);	
			} // else, request could not be parsed
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}