/*
 * @(#)Controller.java	1.0	05/12/09
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
package controller;

import model.server.EmailServer;
import model.structs.ConnectionInformation;

/**
 * Entry-point in the system. Sets up the email server and the request-checking engine.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class Controller
{
	/** The email server responsible for checking for new requests and processing them. */
	private EmailServer server;


	/**
	 * Creates an instance of this object to connect to the specified server and begin the
	 * request checking/processing sequence.
	 * @param connectionInfo The email server information required to connect.
	 */
	public Controller(ConnectionInformation connectionInfo)
	{
		this.server = new EmailServer(connectionInfo);
		this.server.start();
	}


	/**
	 * Primary-entry point in the system.
	 * @param args The email server information (in order of: IMAP server username, SMTP server username, password, IMAP server host, SMTP server host, SMTP server port).
	 */
	public static void main(String[] args)
	{
		ConnectionInformation connect = new ConnectionInformation( args[0], args[1], args[2], args[3], args[4], Integer.parseInt(args[5]) );
		new Controller(connect);
	}
}