/*
 * @(#)ConnectionInformation.java	1.0	05/12/09
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
package model.structs;

/**
 * Stores and maintains connection information to a remote service for later retrieval.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class ConnectionInformation
{
	/** The host address of the IMAP server. */
	private String imapHost;

	/** The username used to authenticate to the IMAP server. */
	private String imapUsername;

	/** The password used to authenticate to both the IMAP and the SMTP servers.*/
	private String password;

	/** The host address of the SMTP server. */
	private String smtpHost;

	/** The port number used to access the SMTP server. */
	private int smtpHostPort;

	/** The username required to authenticate to the SMTP server. */
	private String smtpUsername;


	/**
	 * Creates a connection information object that will store the specified remote connection
	 * information for later retrieval.
	 * @param imapUsername The username used to authenticate to the IMAP server.
	 * @param smtpUsername The username required to authenticate to the SMTP server.
	 * @param password The password used to authenticate to both the IMAP and the SMTP servers.
	 * @param imapHost The host address of the IMAP server.
	 * @param smtpHost The host address of the SMTP server.
	 * @param smtpHostPort The port number used to access the SMTP server.
	 */
	public ConnectionInformation(String imapUsername, String smtpUsername, String password, String imapHost, String smtpHost, int smtpHostPort)
	{
		super();
		this.password = password;
		this.imapHost = imapHost;
		this.smtpHost = smtpHost;
		this.smtpUsername = smtpUsername;
		this.imapUsername = imapUsername;
		this.smtpHostPort = smtpHostPort;
	}


	/**
	 * Retrieves the IMAP host address.
	 * @return The address required to connect to the IMAP server.
	 */
	public String getImapHost()
	{
		return imapHost;
	}


	/**
	 * Retrieves the username required to authenticate to the IMAP server.
	 * @return The username needed to log into the IMAP server.
	 */
	public String getImapUsername()
	{
		return imapUsername;
	}


	/**
	 * Retrieves the password required to authenticate to both the IMAP and the SMTP servers.
	 * @return The password needed to log into both the IMAP and the SMTP servers.
	 */
	public String getPassword()
	{
		return password;
	}


	/**
	 * Retrieves the host address for the SMTP server.
	 * @return The address required to access the SMTP server.
	 */
	public String getSmtpHost()
	{
		return smtpHost;
	}


	/**
	 * Retrieves the port number needed to access the SMTP server.
	 * @return The port number used to connect to the SMTP server.
	 */
	public int getSmtpHostPort()
	{
		return smtpHostPort;
	}


	/**
	 * Retrieves the username required to authenticate to the SMTP server.
	 * @return The username needed to log into the SMTP server.
	 */
	public String getSmtpUsername()
	{
		return smtpUsername;
	}
}