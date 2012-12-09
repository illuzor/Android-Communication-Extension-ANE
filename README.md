Android-Communication-Extension-ANE
===================================
Native Extension for Adobe AIR

Features:

	- dial phone number
	- call phone number
	- send sms
	- send email
	
How to use:

Connect com.illuzor.extensions.CommunicationExtension.ane file to your android air project.
Import com.illuzor.communicationextension.CommunicationExtension;

1) Phone:

	CommunicationExtension.phoneSupported; // boolean. Is device supported phone function.
	
	CommunicationExtension.phoneCall("123456789"); // dial number
	
	CommunicationExtension.phoneCall("123456789", true); // call number immediately.
	// IMPORTANT! Immediately call required permission:
	// <uses-permission android:name="android.permission.CALL_PHONE" />
	
	
2) SMS:

	CommunicationExtension.sendSMS("123456789", "Your message text");
	
	
3) Email:

	CommunicationExtension.sendEmail("adress@example.com", "Email subject", "Your email text");
	
4) Dispose. If you don`t need extension after use, dispose it:

	CommunicationExtension.dispose();

