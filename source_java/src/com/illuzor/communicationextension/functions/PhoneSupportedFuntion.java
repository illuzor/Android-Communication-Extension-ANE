package com.illuzor.communicationextension.functions;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.adobe.fre.*;

public class PhoneSupportedFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		FREObject isSupported = null;
		
		try {
			isSupported = FREObject.newObject(isPhoneSupported(context));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isSupported;
	}
	
	private boolean isPhoneSupported(FREContext context){
		TelephonyManager phoneManager = (TelephonyManager) context.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
		   if(phoneManager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE) return false;
		   return true;
	}
}
