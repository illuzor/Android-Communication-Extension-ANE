Android-Communication-Extension-ANE
===================================
Native Extension for Adobe AIR

Features:

	- dial phone number
	- call phone number
	- send sms
	- send email
	
Changes history:

	10.01.2013:
	- added multiple email adresses
	
Important! Be shure, that you are using latest version of AIR SDK. This ANE builded for 4.0
	
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

	CommunicationExtension.sendEmail(["adress@example.com"], "Email subject", "Your email text");
	// or multiple adresses
	CommunicationExtension.sendEmail(["adress@example.com", "adress102@example.ws", "adress247@example.ru"], "Email subject", "Your email text");
	
4) Dispose. If you don`t need extension after use, dispose it:

	CommunicationExtension.dispose();
	
Demo app - http://yadi.sk/d/Se_LR8fm1lgsD

![demoAppQR.gif](http://download.illuzor.com/images/github/ane/demoAppQR.gif)