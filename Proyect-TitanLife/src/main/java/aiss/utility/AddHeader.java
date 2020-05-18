package aiss.utility;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

@SuppressWarnings("unchecked")

public class AddHeader {
	public static void addHeader(ClientResource cr, String headerName, String headerValue) {
		  Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
		      .get(HeaderConstants.ATTRIBUTE_HEADERS);

		  if (headers == null) {
		    headers = new Series<Header>(Header.class);
		   cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		  }
			headers.add(headerName, headerValue);
		}


}
