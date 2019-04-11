/*
 * @(#)ProcessorGenerator.java	1.0	05/12/09
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
package model.eventHandlers;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.event.MessageCountAdapter;
import javax.mail.event.MessageCountEvent;
import javax.mail.internet.MimeMessage;
import model.processor.RequestProcessor;
import model.server.SmtpServer;


/**
 * Generates the worker threads responsible for processing the email request.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public abstract class ProcessorGenerator extends MessageCountAdapter
{
	/** The body-type of the message sent by the user we can parse. */
	public static final String EXPECTED_BODY_TYPE = "text/plain";

	/** The pool of threads that are performing requests. */
	protected ExecutorService pool;

	/** The worker that will process the request specified in the email. */
	protected RequestProcessor processor;

	/** Server used to send the response to the user. */
	protected SmtpServer server;


	/**
	 * Creates an instance of the generator that will create the worker threads necessary to
	 * process the requests specified in the emails.
	 * @param server The SMTP server that will be used to send the response back.
	 */
	public ProcessorGenerator(SmtpServer server)
	{
		this.pool = Executors.newCachedThreadPool();
		this.server = server;
	}


	/**
	 * All subclasses must implement this to specify the processor that will handle the
	 * message request.
	 * @param m The message that needs to be processed by the worker threads.
	 * @return The processor that will handle the request message.
	 * @throws MessagingException If there is a problem sending the response message.
	 * @throws IOException If there is a problem accessing the external resources to process
	 * the message request.
	 * @throws ParseException If the contents of the requests message are not formatted properly.
	 */
	public abstract RequestProcessor generateProcessor(MimeMessage m)  throws MessagingException, IOException, ParseException;


	/* (non-Javadoc)
	 * @see javax.mail.event.MessageCountAdapter#messagesAdded(javax.mail.event.MessageCountEvent)
	 */
	public void messagesAdded(MessageCountEvent e)
	{
		try {
			Message[] messages = e.getMessages(); // new messages

			for (Message m: messages)
			{
				MimeMessage copy; // a copy is needed since a constant connection is needed to server directly to message in order to work with it

				if ( m.isMimeType(EXPECTED_BODY_TYPE) )
				{
					copy = new MimeMessage( (MimeMessage)m );
					pool.execute( this.generateProcessor(copy) );
				}

				m.setFlag(Flags.Flag.DELETED, true); // delete the message, no need to save it
				//m.setFlag(Flags.Flag.SEEN, true);
			}
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}