/*
 * @(#)DataIslamicFinderFieldsTest.java	1.0	05/12/09
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
package tests.model.processor.target.structs;

import static org.junit.Assert.assertEquals;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.processor.target.structs.DataIslamicFinderFields;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the DataIslamicFinderFields class.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class DataIslamicFinderFieldsTest
{
	/** The instance of the class to test. */
	private DataIslamicFinderFields d;


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		d = new DataIslamicFinderFields();

		DateFormat formatter = new SimpleDateFormat("MM.dd.yyyy");
		d.setRequestedDate( formatter.parse("05.13.2009") );
	}


	/**
	 * Test method for {@link model.processor.target.structs.DataIslamicFinderFields#getRequestedDay()}.
	 */
	@Test
	public void testGetRequestedDay()
	{
		assertEquals( 13, d.getRequestedDay() );
	}


	/**
	 * Test method for {@link model.processor.target.structs.DataIslamicFinderFields#getRequestedMonth()}.
	 */
	@Test
	public void testGetRequestedMonth()
	{
		assertEquals( 5, d.getRequestedMonth() );
	}


	/**
	 * Test method for {@link model.processor.target.structs.DataIslamicFinderFields#getRequestedYear()}.
	 */
	@Test
	public void testGetRequestedYear()
	{
		assertEquals( 2009, d.getRequestedYear() );
	}
}