package com.illuzor.communicationextension;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.illuzor.communicationextension.functions.*;

public class CommunicationExtensionContext extends FREContext {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
		map.put("sendEmail", new SendEmailFuntion());
		map.put("phoneCall", new PhoneCallFuntion());
		map.put("sendSMS", new SendSMSFuntion());
		map.put("phoneSupported", new PhoneSupportedFuntion());
		return map;
	}

}
