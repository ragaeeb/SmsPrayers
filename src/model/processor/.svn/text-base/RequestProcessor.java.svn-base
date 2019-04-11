/*
 * @(#)RequestProcessor.java	1.0	05/12/09
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

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import model.processor.structs.PrayerRequestProperties;
import model.server.SmtpServer;

/**
 * Processes an email request sent.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public abstract class RequestProcessor implements Runnable
{
	/** The properties of the request sent. */
	protected PrayerRequestProperties properties;

	/** The processed respond that will be sent back. */
	protected Response response;


	/**
	 * Creates a request processor instance that will process the specified message and send a
	 * response through the specified SMTP server.
	 * @param received The message request to process.
	 * @param smtpServer The SMTP server that will be used to process the request.
	 * @throws MessagingException If there are problems sending the response back.
	 */
	public RequestProcessor(MimeMessage received, SmtpServer smtpServer) throws MessagingException
	{
		this.response = new Response( smtpServer, received.getFrom() );
	}
}