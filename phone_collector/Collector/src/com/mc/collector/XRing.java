package com.mc.collector;

import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;

public class XRing {
	/**
	 * ӵ���ڶಥ�������ĺ���
	 */
	//****************************************************************//
	//����ϵͳ��֪ͨ����
	public static void SystemRingtone_notification(Context context){
		Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		android.media.Ringtone rt = RingtoneManager.getRingtone(context, uri);
		if(rt != null)
		rt.play();
	}
}
