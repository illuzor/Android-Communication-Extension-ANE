package com.illuzor.communicationextension.functions;

import android.content.Intent;
import android.net.Uri;

import com.adobe.fre.*;

public class PhoneCallFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {

		try {
			String action;
			String phoneNumber = args[0].getAsString();
			boolean callImmediately = args[1].getAsBool();
			Uri phoneUri = Uri.parse("tel:" + phoneNumber);

			if(callImmediately){
				action = Intent.ACTION_CALL;
			} else {
				action = Intent.ACTION_DIAL;
			}
			
			Intent phoneIntent = new Intent(action, phoneUri);
			context.getActivity().startActivity(phoneIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
