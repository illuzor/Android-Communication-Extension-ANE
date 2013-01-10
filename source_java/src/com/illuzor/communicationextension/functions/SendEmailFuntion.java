package com.illuzor.communicationextension.functions;

import android.content.Intent;

import com.adobe.fre.*;

public class SendEmailFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		try {
			String addresses = args[0].getAsString();
			String subject = args[1].getAsString();
			String message = args[2].getAsString();
			String[] addressesArray = addresses.split(",");
			
			Intent emailIntent = new Intent(Intent.ACTION_SEND);
			emailIntent.setType("message/rfc822");
			emailIntent.putExtra(Intent.EXTRA_EMAIL, addressesArray);
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
			emailIntent.putExtra(Intent.EXTRA_TEXT, message);

			context.getActivity().startActivity(emailIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
