/*
 * @(#)EmailServer.java	1.0	05/12/09
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
package model.server;

import javax.mail.event.MessageCountAdapter;
import model.eventHandlers.PrayersProcessorGenerator;
import model.structs.ConnectionInformation;


/**
 * The email server used for retrieving messages from a host, and also sending messages.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class EmailServer extends Thread
{
	/** Server-connection information. */
	private ConnectionInformation connectionInfo;

	/** Retrieves messages from a host. */
	private ImapServer imapServer;

	/** Generates processes to handle requests in the event of a message that is received. */
	private MessageCountAdapter processGenerator;

	/** Used to send messages to addresses. */
	private SmtpServer smtpServer;


	/**
	 * Initiates an email server connection with the specified host information.
	 * @param connectionInfo The connection information needed to connect to the host.
	 */
	public EmailServer(ConnectionInformation connectionInfo)
	{
		this.connectionInfo = connectionInfo;
	}


	/**
	 * Retrieves the IMAP server.
	 * @return The server used to receive emails.
	 */
	public ImapServer getImapServer()
	{
		return imapServer;
	}


	/**
	 * Retrieves the SMTP server.
	 * @return The server used to send emails.
	 */
	public SmtpServer getSmtpServer()
	{
		return smtpServer;
	}


	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
	{
		try
		{
			smtpServer = new SmtpServer(connectionInfo);
			this.processGenerator = new PrayersProcessorGenerator(smtpServer);
			imapServer = new ImapServer(connectionInfo.getImapHost(), connectionInfo.getImapUsername(), connectionInfo.getPassword(), processGenerator);
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}