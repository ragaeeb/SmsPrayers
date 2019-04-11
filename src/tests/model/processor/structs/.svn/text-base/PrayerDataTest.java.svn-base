/*
 * @(#)PrayerDataTest.java	1.0	05/12/09
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
package tests.model.processor.structs;

import static org.junit.Assert.assertEquals;
import model.processor.structs.PrayerData;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the PrayerData class.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class PrayerDataTest
{
	/** Instance of the class to test. */
	private PrayerData p;


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		p = new PrayerData();
		p.setAsrTime("1:10");
		p.setDhuhrTime("2:10");
		p.setFajrTime("3:10");
		p.setMaghribTime("4:10");
		p.setIshaTime("5:10");
		p.setSunrise("6:10");
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject()
	{
		PrayerData p2 = new PrayerData();

		assertEquals(p, p);
		assertEquals( false, p.equals(p2) );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getAsrTime()}.
	 */
	@Test
	public void testGetAsrTime()
	{
		assertEquals( "1:10", p.getAsrTime() );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getDhuhrTime()}.
	 */
	@Test
	public void testGetDhuhrTime()
	{
		assertEquals( "2:10", p.getDhuhrTime() );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getFajrTime()}.
	 */
	@Test
	public void testGetFajrTime()
	{
		assertEquals( "3:10", p.getFajrTime() );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getIshaTime()}.
	 */
	@Test
	public void testGetIshaTime()
	{
		assertEquals( "5:10", p.getIshaTime() );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getMaghribTime()}.
	 */
	@Test
	public void testGetMaghribTime()
	{
		assertEquals( "4:10", p.getMaghribTime() );
	}


	/**
	 * Test method for {@link model.processor.structs.PrayerData#getSunrise()}.
	 */
	@Test
	public void testGetSunrise()
	{
		assertEquals( "6:10", p.getSunrise() );
	}
}