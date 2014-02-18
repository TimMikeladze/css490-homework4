
package com.css490.homework4.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapLoader {
	
	public static Bitmap loadBitmap(Resources resources, int id, int width, int height) {
		Bitmap bitmap;
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		options.inScreenDensity = 0;
		
		bitmap = BitmapFactory.decodeResource(resources, id, options);
		
		options.inSampleSize = calculateInSampleSize(options, width, height);
		
		options.inJustDecodeBounds = false;
		
		bitmap = BitmapFactory.decodeResource(resources, id, options);
		bitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
		return bitmap;
	}
	
	private static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
		int height = options.outHeight;
		int width = options.outWidth;
		
		int inSampleSize = 1;
		
		if (height > reqHeight || width > reqWidth) {
			int halfHeight = height / 2;
			int halfWidth = width / 2;
			
			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}
		
		return inSampleSize;
	}
	
}
