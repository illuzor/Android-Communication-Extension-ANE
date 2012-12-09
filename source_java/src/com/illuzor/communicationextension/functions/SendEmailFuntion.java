package com.illuzor.communicationextension.functions;

import android.content.Intent;

import com.adobe.fre.*;

public class SendEmailFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		try {
			String adress = args[0].getAsString();
			String subject = args[1].getAsString();
			String message = args[2].getAsString();
			
			Intent emailIntent = new Intent(Intent.ACTION_SEND);
			emailIntent.setType("message/rfc822");
			emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{adress});
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
			emailIntent.putExtra(Intent.EXTRA_TEXT, message);

			context.getActivity().startActivity(emailIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
