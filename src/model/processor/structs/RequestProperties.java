/*
 * @(#)RequestProperties.java	1.0	05/12/09
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

import java.net.MalformedURLException;
import java.net.URL;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;


/**
 * Properties of a request sent.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public abstract class RequestProperties
{
	/** The senders of the request. */
	protected Address[] from;


	/**
	 * Populates the request properties from the specified message.
	 * @param m The message containing the information we need to parse and populate.
	 * @throws MessagingException If there are problems extracting the message's contents.
	 */
	public RequestProperties(Message m) throws MessagingException
	{
		this.from = m.getFrom();
	}


	/**
	 * Retrieves the senders of the request.
	 * @return The senders of the request.
	 */
	public Address[] getFrom()
	{
		return from;
	}


	/**
	 * Gets the target URL we need to parse to process the request.
	 * @return The target URL that needs to be parsed in order to process the request.
	 * @throws MalformedURLException If an invalid URL is generated.
	 */
	public abstract URL getTargetURL() throws MalformedURLException;
}