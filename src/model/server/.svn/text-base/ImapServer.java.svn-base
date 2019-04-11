/*
 * @(#)ImapServer.java	1.0	05/12/09
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
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountAdapter;


/**
 * Represents a IMAP server that can be accessed to retrieve messages. The Internet Message
 * Access Protocol or IMAP is one of the two most prevalent Internet standard protocols for
 * e-mail retrieval, the other being POP3. Virtually all modern e-mail clients and servers
 * support both protocols as a means of transferring e-mail messages from a server, such as
 * those used by Gmail, to a client, such as Mozilla Thunderbird, Apple Mail and Microsoft
 * Outlook. Once configured, the client's use of such protocols remains transparent to the user.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class ImapServer
{
	/** The amount of time in milliseconds to delay before checking for new messages. */
	public static final long IDLE_TIME = 2000;

	/** The store name on the IMAP host that contains all the messages. */
	private static final String IMAP_STORE_NAME = "imaps";

	/** The main folder where all the email requests are stored and are retrieved from. */
	private static final String MAIL_FOLDER_NAME = "INBOX";

	/** The store holding all the messages. */
	private Store imapStore;

	/** Reference to the folder that will constantly be monitored for messages. */
	private Folder inbox;


	/**
	 * Creates an IMAP server using the connection information specified to be processed by the
	 * processor specified upon new requests that arrive at its default folder.
	 * @param host The address of the IMAP server to connect to.
	 * @param username The username required to authenticate to the IMAP server.
	 * @param password The password required to authenticate to the IMAP server.
	 * @param processor The generator used to handle new email requests that arrive.
	 * @throws MessagingException In the event that the server could not authenticate the
	 * connection or the required folder(s) could not be opened/accessed.
	 * @throws InterruptedException If this thread is interrupted while delaying before the next
	 * check for new messages.
	 */
	public ImapServer(String host, String username, String password, MessageCountAdapter processor) throws MessagingException, InterruptedException
	{
		Properties props = System.getProperties();

		// Get a Session object
		Session session = Session.getInstance(props, null);
		session.setDebug(false);

		imapStore = session.getStore(IMAP_STORE_NAME);
		imapStore.connect(host, username, password);

		openAndMonitor(processor);
	}


	/**
	 * Closes the folder and store that the server is listening to in the host and ends the
	 * connection to the server.
	 * @throws MessagingException
	 */
	public void close() throws MessagingException
	{
		inbox.close(false);
		imapStore.close();
	}


	/**
	 * Monitors the default folder for new email requests.
	 * @throws MessagingException If the folder being checked does not respond or is closed and
	 * thus access is not allowed.
	 * @throws InterruptedException If this thread is interrupted while delaying before the next
	 * check for new messages.
	 */
	private void monitorInbox() throws MessagingException, InterruptedException
	{
		while (true)
		{
			Thread.sleep(IDLE_TIME); // sleep for freq milliseconds

			// This is to force the IMAP server to send us EXISTS notifications. 
			inbox.getMessageCount();
		}
	}


	/**
	 * Opens the default folder where the mail is stored and monitors it for new messages that
	 * have not been processed.
	 * @param processor Responsible for reacting to new message request events.
	 * @throws MessagingException If the folder being checked does not respond or is closed and
	 * thus access is not allowed.
	 * @throws InterruptedException If this thread is interrupted while delaying before the next
	 * check for new messages.
	 */
	private void openAndMonitor(MessageCountAdapter processor) throws MessagingException, InterruptedException
	{
		inbox = imapStore.getFolder(MAIL_FOLDER_NAME);

		try {
			inbox.open(Folder.READ_WRITE);
		}

		catch (IllegalStateException ex) // if the store is not connected
		{
			ex.printStackTrace();
		}

		inbox.addMessageCountListener(processor);

		try {
			monitorInbox();
		}

		catch (FolderClosedException ex)
		{
			inbox.open(Folder.READ_WRITE);
			inbox.addMessageCountListener(processor);
			monitorInbox();
		}
	}
}