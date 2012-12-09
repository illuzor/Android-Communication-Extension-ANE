package com.illuzor.communicationextension;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class CommunicationExtension implements FREExtension {

	private CommunicationExtensionContext context;
	
	@Override
	public FREContext createContext(String arg0) {
		context = new CommunicationExtensionContext();
		return context;
	}

	@Override
	public void dispose() {
		context.dispose();
		context = null;
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

}
