package com.illuzor.communicationextension.functions;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import com.adobe.fre.*;

public class SendEmailFuntion implements FREFunction {

	@Override
	public FREObject call(FREContext context, FREObject[] args) {
		try {
			String addresses = args[0].getAsString();
			String subject = args[1].getAsString();
			String message = args[2].getAsString();
			String filesPaths = args[3].getAsString();
			String[] addressesArray = addresses.split(",");
			
			Intent emailIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
			emailIntent.setType("message/rfc822");
			emailIntent.putExtra(Intent.EXTRA_EMAIL, addressesArray);
			emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
			emailIntent.putExtra(Intent.EXTRA_TEXT, message);

			 if(!filesPaths.equals("")){
				String[] filesPathsArray = filesPaths.split(",");
				ArrayList<Uri> uris = new ArrayList<Uri>();
				for (String filePath:filesPathsArray) {
					Uri uri = Uri.parse("file://" + filePath);
					uris.add(uri);
				}
				emailIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
			} 

			context.getActivity().startActivity(emailIntent);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
