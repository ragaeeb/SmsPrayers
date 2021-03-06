/*
 * @(#)IslamicFinderUrlBuilderTest.java	1.0	05/12/09
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
package tests.model.processor.target;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.processor.structs.PrayerRequestProperties;
import model.processor.target.IslamicFinderUrlBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the IslamicFinderUrlBuilder class.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class IslamicFinderUrlBuilderTest
{
	/** Instance to test. */
	private IslamicFinderUrlBuilder i;


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		i = IslamicFinderUrlBuilder.getInstance();
	}


	/**
	 * Test method for {@link model.processor.target.IslamicFinderUrlBuilder#build(model.processor.structs.PrayerRequestProperties)}.
	 * @throws MessagingException 
	 * @throws AddressException 
	 * @throws ParseException 
	 * @throws IOException 
	 */
	@Test
	public void testBuild() throws AddressException, MessagingException, IOException, ParseException
	{
		Properties props = new Properties();
		Session session = Session.getInstance(props, null);

		// create a message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("test@hotmail.com"));
		InternetAddress[] address = {new InternetAddress("test@hotmail.com")};
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject("Test");
		msg.setSentDate(new Date());
		msg.setText("CyOttawa CnCanada Ston");

		PrayerRequestProperties p = new PrayerRequestProperties(msg);
		URL s = i.build(p);

		assertEquals(s, new URL("http://www.islamicfinder.org/prayerPrintable.php?city2=ottawa&state=on&id=&longi=&lati=&country2=canada&zipcode=&today_date_flag=&changeTime=16&pmethod=&HanfiShafi=&dhuhrInterval=&maghribInterval=&dayLight=1&dayl=1&timez=&dayLight_self_change=&prayerCustomize=&lang=&fajrTwilight=0&ishaTwilight=&ishaInterval=&month=5&year=2009"));
	}
}