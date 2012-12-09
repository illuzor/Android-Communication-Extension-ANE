package com.illuzor.communicationextension.functions;

import android.content.Intent;
import android.net.Uri;

import com.adobe.fre.*;

public class SendSMSFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		
		try {
			String phoneNumber = args[0].getAsString();
			String message = args[1].getAsString();
			Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"+phoneNumber));
			intent.putExtra("sms_body", message);
			context.getActivity().startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
