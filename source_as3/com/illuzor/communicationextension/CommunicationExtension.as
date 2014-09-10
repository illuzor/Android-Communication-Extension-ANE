package com.illuzor.communicationextension {
	
	import flash.external.ExtensionContext;
	import flash.filesystem.File;
	
	/**
	 * ...
	 * @author illuzor
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
		
		public static function sendEmail(addresses:Array, subject:String, message:String, files:Array = null):void {
			if (!context) init();
			var fileCheckFailed:Boolean;
			var filesPaths:Array = [];
			var filesPathsString:String = "";
			if (files) {
				for (var i:int = 0; i < files.length; i++) {
					filesPaths.push(File(files[i]).nativePath);
					if (!File(files[i]).exists) {
						fileCheckFailed = true;
						throw new Error("CommunicationExtension Error: " + File(files[i]).url + " not exists");
						break;
					}
				}
				filesPathsString = filesPaths.join(",");
			}
			if (!fileCheckFailed) context.call("sendEmail", addresses.join(","), subject, message, filesPathsString);
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