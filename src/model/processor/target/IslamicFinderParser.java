/*
 * @(#)IslamicFinderParser.java	1.0	05/12/09
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
package model.processor.target;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.text.html.HTML.Tag;


/**
 * Parses a prayer time page in the IslamicFinder website.
 *
 * @author rhaq
 * @version 1.00 2009-05-12 Initial submission.
 */
public class IslamicFinderParser
{
	/** Code to signal that a tag was not found in the source code. */
	private static final int NOT_FOUND = -1;

	/** Marks the beginning of a tag. */
	private static final String TAG_BEGIN = "<";

	/** Closes a tag. */
	private static final String TAG_END = ">";

	/** The name value of the table rows tag that stores Islamic data. */
	private static final String TAG_NAME = Tag.TR.toString();

	/** Prefix of the tag we wish to locate in the web page. */
	private static final String TAG_TO_FIND_BEGIN = TAG_BEGIN+TAG_NAME;

	/** Suffix of the tag we wish to locate in the web page. */
	private static final String TAG_TO_FIND_END = TAG_BEGIN+"/"+TAG_NAME+TAG_END;

	/** The length of the suffix tag. */
	private static final int TAG_TO_FIND_END_LENGTH = TAG_TO_FIND_END.length();


	/**
	 * Creates an instance of this class so that a IslamicFinder page can be parsed.
	 */
	public IslamicFinderParser()
	{
	}


	/**
	 * Gets the source code of the specified URL as a string.
	 * @param url The web page to extract the source code for.
	 * @return The source code of the specified URL as a string.
	 * @throws IOException If there is a problem accessing the web page.
	 */
	private String getContents(URL url) throws IOException
	{
		String contents = new String();
		BufferedReader in = new BufferedReader( new InputStreamReader( url.openStream() ) );
		String inputLine;

		while ( ( inputLine = in.readLine() ) != null )
			contents += inputLine;

		in.close();

		return contents;
	}


	/**
	 * Locates table rows in the specified source code snippet.
	 * @param src The source code potentially containing table rows.
	 * @return A list of table rows that were contained in the source code.
	 */
	private List<String> lookForRows(String src)
	{
		List<String> tableRows = new LinkedList<String>();

		while (true)
		{
			int begin = src.toLowerCase().indexOf(TAG_TO_FIND_BEGIN);

			if (begin == NOT_FOUND)
				break;

			begin = src.indexOf(TAG_END, begin)+1;

			int end = src.toLowerCase().indexOf(TAG_TO_FIND_END, begin);

			String sub = src.substring(begin, end);
			tableRows.add(sub);

			src = src.substring(end+TAG_TO_FIND_END_LENGTH);	
		}

		return tableRows;
	}


	/**
	 * Parses the specified URL and computes a list of table rows that is contained within it.
	 * @param url The web page to extract the source code for.
	 * @throws IOException If there is a problem accessing the web page.
	 */
	public List<String> parseTableRows(URL url) throws IOException
	{
		String contents = getContents(url);
		List<String> tableRows = lookForRows(contents);

		return tableRows;
	}
}