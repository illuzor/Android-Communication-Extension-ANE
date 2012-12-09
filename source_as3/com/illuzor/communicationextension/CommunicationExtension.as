package com.illuzor.communicationextension {
	
	import flash.external.ExtensionContext;
	
	/**
	 * ...
	 * @author illuzor  //  illuzor@gmail.com  //  illuzor.com
	 */
	
	public class CommunicationExtension {
		
		private static var context:ExtensionContext;
		
		private static function init():void {
			context = ExtensionContext.createExtensionContext("com.illuzor.extensions.CommunicationExtension", null);
		}
		
		public static function phoneCall(phoneNumber:String, callImmediately:Boolean = false):void {
			if (!context) init();
			context.call("phoneCall", phoneNumber, callImmediately);
		}
		
		public static function sendSMS(phoneNumber:String, message:String):void {
			if (!context) init();
			context.call("sendSMS", phoneNumber, message);
		}
		
		public static function sendEmail(adress:String, subject:String, message:String):void {
			if (!context) init();
			context.call("sendEmail", adress, subject, message);
		}
		
		public static function get phoneSupported():Boolean {
			if (!context) init();
			return context.call("phoneSupported") as Boolean;
		}

		public static function dispose():void {
			if (context) {
				context.dispose();
				context = null;
			}
		}
		
	}
}