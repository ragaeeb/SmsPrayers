/*
 * @(#)Response.java	1.0	05/12/09
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

import javax.mail.Address;
import javax.mail.MessagingException;
import model.server.SmtpServer;

/**
 * The response to a request that will be sent.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class Response
{
	/** The methodology used to send this response. */
	private SmtpServer smtpServer;

	/** The addresses that he response should be sent to. */
	private Address[] destinations;


	/**
	 * Sets up a response to be sent to the specified destination addresses by using the specified
	 * server.
	 * @param smtpServer The protocol used to send this response.
	 * @param destinations The email addresses that this response will be sent to.
	 */
	public Response(SmtpServer smtpServer, Address[] destinations)
	{
		this.smtpServer = smtpServer;
		this.destinations = destinations;
	}


	/**
	 * Sends this response to its recipients with the specified subject and body content.
	 * @param subject The subject of the message to send.
	 * @param result The body text that should be sent in the message.
	 * @throws MessagingException If there are any problems sending the message through the
	 * channel.
	 */
	public void process(String subject, String result) throws MessagingException
	{
		smtpServer.sendMessage(subject, result, destinations);
	}
}