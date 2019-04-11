/*
 * @(#)SmtpServer.java	1.0	05/12/09
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

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import model.structs.ConnectionInformation;


/**
 * Responsible for sending messages to a list of addresses. Simple Mail Transfer Protocol (SMTP)
 * is an Internet standard for electronic mail (e-mail) transmission across Internet Protocol (IP)
 * networks. SMTP was first defined in RFC 821 (STD 10), and last updated by RFC 5321 (2008)
 * which describes extended SMTP (ESMTP), the protocol in widespread use today.<br>
 *<br>
 * While electronic mail server software uses SMTP to send and receive mail messages, user-level
 * client mail applications typically only use SMTP for sending messages to a mail server for
 * relaying. For receiving messages, client applications usually use either the Post Office
 * Protocol (POP) or the Internet Message Access Protocol (IMAP) to access their mail box
 * accounts on a mail server.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class SmtpServer
{
	/** The format of the body of the message being sent. */
	private static final String MESSAGE_TYPE = "text/plain";

	/** Used to remember the server connection information in the event of the socket timing out. */
	private ConnectionInformation info;

	/** The session received from the host to allow us to send messages. */
	private Session mailSession;

	/** The mechanism used to transfer data from local machine to remote machine. */
	private Transport transport;


	/**
	 * Creates a SMTP server using the connection information specified and sets up the channels
	 * required to send data to destinations.
	 * @param info The server connection information.
	 * @throws MessagingException If there is a problem connecting to the remote service.
	 */
	public SmtpServer(ConnectionInformation info) throws MessagingException
	{
		this.info = info;

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put( "mail.smtps.host", info.getSmtpHost() );
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.quitwait", "true");

		this.mailSession = Session.getDefaultInstance(props);
		this.mailSession.setDebug(false);

		this.transport = mailSession.getTransport();
		connect();
	}


	/**
	 * Connects to the remote service that allows us to send messages.
	 * @throws MessagingException If there is a problem getting a connection from the host.
	 */
	private void connect() throws MessagingException
	{
		this.transport.connect(info.getSmtpHost(), info.getSmtpHostPort(), info.getSmtpUsername(), info.getPassword());
	}


	/**
	 * Sends a message with the specified subject and body to the destinations specified.
	 * @param subject The subject of the message to be sent.
	 * @param body The actual content of the message to be sent.
	 * @param destinations The email addresses to send the message to.
	 * @throws MessagingException If there is a problem obtaining a channel to send the required
	 * data to the remote service.
	 */
	public synchronized void sendMessage(String subject, String body, Address[] destinations) throws MessagingException
	{
		MimeMessage m = new MimeMessage(mailSession);
		m.setSubject(subject);
		m.setContent(body, MESSAGE_TYPE);
		m.addRecipients(Message.RecipientType.TO, destinations);
		m.saveChanges();

		try {
			transport.sendMessage( m, m.getRecipients(Message.RecipientType.TO) );
		}

		catch (MessagingException se)
		{
			// possibly the socket was closed by server
			connect();
			transport.sendMessage( m, m.getRecipients(Message.RecipientType.TO) );
		}
	}
}