Android-Communication-Extension-ANE
===================================
Native Extension for Adobe AIR

Features:

	- dial phone number;
	- call phone number;
	- send sms;
	- send email (attachments supported).
	
Important! Be shure you are using latest version of AIR SDK. This ANE builded for 15.0
	
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
	// or with attachments (one or multiple)
	var file1:File = ...;
	var file2:File = ...;
	CommunicationExtension.sendEmail(["adress@example.com"], "Email subject", "Your email text", [file1, file2]);
	
4) Dispose. If you don`t need extension after use, dispose it:

	CommunicationExtension.dispose();
	
Demo app - http://yadi.sk/d/Se_LR8fm1lgsD

![demoAppQR.gif](http://download.illuzor.com/images/github/ane/demoAppQR.gif)