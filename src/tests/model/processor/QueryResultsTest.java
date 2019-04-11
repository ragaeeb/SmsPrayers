/*
 * @(#)QueryResultsTest.java	1.0	05/12/09
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
package tests.model.processor;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import model.processor.QueryResults;
import model.processor.structs.PrayerData;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests the QueryResults class.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class QueryResultsTest
{
	/** Instance of the class to test. */
	private QueryResults q;


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		List<String> expected = new ArrayList<String>();
		expected.add("<td valign=\"top\" class= \"IslamicData\"><a href=\"index.php\"><IMG SRC=\"logo1.jpg\" border=0></A><BR>www.islamicFinder.org</td><td valign=\"top\"><center><table dir=\"ltr\"><tr><td><font color=green size=+1><b><u>Prayer Times Schedule</u></b></font><table dir=\"ltr\"><tr><td class=\"IslamicHeader\"><b> Month: </b></td><td class=\"IslamicHeader\"> 5/2009, </td><td class=\"IslamicHeader\"> 5-6 </td><td class=\"IslamicHeader\">/ 1430 A.H </td>");
		expected.add("<td class=\"IslamicHeader\"><b> Location: </b></td><td class=\"IslamicHeader\"> Ottawa, </td><td class=\"IslamicHeader\"> ON, </td><td class=\"IslamicHeader\"> CANADA</td>");
		expected.add("<td class=\"IslamicHeader\"><b>  Calculation Method: </b></td><td class=\"IslamicHeader\"> North America </td>");
		expected.add("<td class=\"IslamicHeader\"><b> Juristic Method: </b></td><td class=\"IslamicHeader\"> Standard </td>");
		expected.add("<td class=\"IslamicHeader\">  </td><td class=\"IslamicHeader\">  </td>");
		expected.add("<td id=\"printicon\">             <img src=\"http://www.islamicfinder.org/images/print_en.gif\" onclick=\"func();\" class=hand> </table><script>function func(){	printicon.innerHTML=\" \";	window.print();}</script></center><center><table border=0 bordercolor=\"#00000\" width=475 dir=\"ltr\" align=\"left\" cellspacing=0 cellpadding=0><TR bgcolor=\"#CCCCCC\"><TD class = \"IslamicData\" align=CENTER width=50>Day</TD><TD class = \"IslamicData\" align=CENTER>May </TD><TD class = \"IslamicData\" align=CENTER>&nbsp;&nbsp; Hijri &nbsp;&nbsp;</TD><TD class = \"IslamicData\" align=CENTER>Fajr</TD><TD class = \"IslamicData\" align=CENTER>&nbsp; Sunrise &nbsp;</TD><TD class = \"IslamicData\" align=CENTER>Dhuhr</TD><TD class = \"IslamicData\" align=CENTER>&nbsp; Asr</TD><TD class = \"IslamicData\" align=CENTER>Maghrib</TD><TD class = \"IslamicData\" align=CENTER>Isha</TD>");
		expected.add("<TD class = \"IslamicData\" align=left width=50>&nbsp; Fri</TD><TD class = \"IslamicData\" align=CENTER>1</TD><TD class = \"IslamicData\" align=CENTER>6/5</TD><TD class = \"IslamicData\" align=CENTER>4:15</TD><TD class = \"IslamicData\" align=CENTER>5:51</TD><TD class = \"IslamicData\" align=CENTER>1:01</TD><TD class = \"IslamicData\" align=CENTER>&nbsp; 4:57</TD><TD class = \"IslamicData\" align=CENTER>8:10</TD><TD class = \"IslamicData\" align=CENTER>9:46</TD>");
		expected.add("<TD class = \"IslamicData\" align=left width=50>&nbsp; Sat</TD><TD class = \"IslamicData\" align=CENTER>2</TD><TD class = \"IslamicData\" align=CENTER>7/5</TD><TD class = \"IslamicData\" align=CENTER>4:13</TD><TD class = \"IslamicData\" align=CENTER>5:49</TD><TD class = \"IslamicData\" align=CENTER>1:00</TD><TD class = \"IslamicData\" align=CENTER>&nbsp; 4:58</TD><TD class = \"IslamicData\" align=CENTER>8:12</TD><TD class = \"IslamicData\" align=CENTER>9:48</TD>");
		expected.add("<TD class = \"IslamicData\" align=left width=50>&nbsp; Sun</TD><TD class = \"IslamicData\" align=CENTER>3</TD><TD class = \"IslamicData\" align=CENTER>8/5</TD><TD class = \"IslamicData\" align=CENTER>4:11</TD><TD class = \"IslamicData\" align=CENTER>5:48</TD><TD class = \"IslamicData\" align=CENTER>1:00</TD><TD class = \"IslamicData\" align=CENTER>&nbsp; 4:58</TD><TD class = \"IslamicData\" align=CENTER>8:13</TD><TD class = \"IslamicData\" align=CENTER>9:50</TD>");
		expected.add("<!--Start Fourth Row-->      <td class=\"IslamicData\"><center> <u>Copyright © 2008 IslamicFinder.org. All rights reserved</u></center></td>  ");

		q = new QueryResults(expected);
	}


	/**
	 * Test method for {@link java.util.Hashtable#get(java.lang.Object)}.
	 */
	@Test
	public void testGet()
	{
		PrayerData p1 = new PrayerData();
		p1.setAsrTime("4:57");
		p1.setDhuhrTime("1:01");
		p1.setFajrTime("4:15");
		p1.setMaghribTime("8:10");
		p1.setIshaTime("9:46");
		p1.setSunrise("5:51");
		assertEquals( p1, q.get(1) );

		PrayerData p2 = new PrayerData();
		p2.setAsrTime("4:58");
		p2.setDhuhrTime("1:00");
		p2.setFajrTime("4:13");
		p2.setMaghribTime("8:12");
		p2.setIshaTime("9:48");
		p2.setSunrise("5:49");
		assertEquals( p2, q.get(2) );

		PrayerData p3 = new PrayerData();
		p3.setAsrTime("4:58");
		p3.setDhuhrTime("1:00");
		p3.setFajrTime("4:11");
		p3.setMaghribTime("8:13");
		p3.setIshaTime("9:50");
		p3.setSunrise("5:48");
		assertEquals( p3, q.get(3) );
	}


	/**
	 * Test method for {@link model.processor.QueryResults#getCalculationMethod()}.
	 */
	@Test
	public void testGetCalculationMethod()
	{
		assertEquals( q.getCalculationMethod(), "Calculation Method: North America" );
	}


	/**
	 * Test method for {@link model.processor.QueryResults#getJuristicMethod()}.
	 */
	@Test
	public void testGetJuristicMethod()
	{
		assertEquals( q.getJuristicMethod(), "Juristic Method: Standard" );
	}


	/**
	 * Test method for {@link model.processor.QueryResults#getLocation()}.
	 */
	@Test
	public void testGetLocation()
	{
		assertEquals( q.getLocation(), "Location: Ottawa, ON, CANADA" );
	}
}