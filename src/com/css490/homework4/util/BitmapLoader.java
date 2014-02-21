
package com.css490.homework4.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * A utilty class to handle optmized bitmap loading
 * 
 * @author Tim Mikeladze
 */
public class BitmapLoader {
	
	/**
	 * Load a bitmap into memory given an id.
	 * 
	 * @param resources the resources
	 * @param id the id of the bitmap
	 * @param width the width of the bitmap
	 * @param height the height of the bitmap
	 * @return the bitmap
	 */
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
	
	/**
	 * Calculate in sample size, used to speed up bitmap loading by having pre calculated
	 * dimensions using powers of 2.
	 * 
	 * @param options the options
	 * @param reqWidth the requested width
	 * @param reqHeight the requested height
	 * @return the sampling size
	 */
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
