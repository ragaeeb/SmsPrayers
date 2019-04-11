/*
 * @(#)ConnectionInformationTest.java	1.0	05/12/09
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
package tests.model.structs;

import static org.junit.Assert.assertEquals;
import model.structs.ConnectionInformation;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ConnectionInformation class.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class ConnectionInformationTest
{
	/** Instance to test. */
	private ConnectionInformation ci1;

	/** Instance to test. */
	private ConnectionInformation ci2;


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		ci1 = new ConnectionInformation("iuser", "suser", "password", "ihost", "shost", 400);
		ci2 = new ConnectionInformation("iuser2", "suser2", "password2", "ihost2", "shost2", 1);
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getImapHost()}.
	 */
	@Test
	public void testGetImapHost()
	{
		assertEquals( ci1.getImapHost(), "ihost" );
		assertEquals( ci2.getImapHost(), "ihost2" );
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getImapUsername()}.
	 */
	@Test
	public void testGetImapUsername()
	{
		assertEquals( ci1.getImapUsername(), "iuser" );
		assertEquals( ci2.getImapUsername(), "iuser2" );
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getPassword()}.
	 */
	@Test
	public void testGetPassword()
	{
		assertEquals( ci1.getPassword(), "password" );
		assertEquals( ci2.getPassword(), "password2" );
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getSmtpHost()}.
	 */
	@Test
	public void testGetSmtpHost()
	{
		assertEquals( ci1.getSmtpHost(), "shost" );
		assertEquals( ci2.getSmtpHost(), "shost2" );
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getSmtpHostPort()}.
	 */
	@Test
	public void testGetSmtpHostPort()
	{
		assertEquals( ci1.getSmtpHostPort(), 400 );
		assertEquals( ci2.getSmtpHostPort(), 1 );
	}


	/**
	 * Test method for {@link model.structs.ConnectionInformation#getSmtpUsername()}.
	 */
	@Test
	public void testGetSmtpUsername()
	{
		assertEquals( ci1.getSmtpUsername(), "suser" );
		assertEquals( ci2.getSmtpUsername(), "suser2" );
	}
}