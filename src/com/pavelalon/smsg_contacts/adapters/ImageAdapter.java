package com.pavelalon.smsg_contacts.adapters;

import java.net.URI;
import java.util.List;

import com.pavelalon.smsg_contacts.beans.ContactEntity;
import com.pavelalon.smsg_contacts.view.R;
import com.pavelalon.smsg_contacts.view.SmsG_ContactsActivity;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

	private List<ContactEntity> contacts;
	
	private final Integer[] mThumbIds = {

	R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4,
			R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
			R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2,
			R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5,
			R.drawable.sample_6, R.drawable.sample_7, R.drawable.sample_0,
			R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
			R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6,
			R.drawable.sample_7 };
	private final String[] mNames = { "Jake", "Josh", "Willma", "Blake",
			"David", "Danny", "Elliot", "Mendy", "Rachel", "Denise", "Hilda",
			"Olga", "Ben", "Stewie", "Pitter", "Ron", "Bella", "Vicky",
			"Rambo", "Yan", "Tom", "Arnold" };

	private Context mContext;

	public ImageAdapter(Context c, List<ContactEntity> contacts) {
		this.contacts = contacts;
		Log.d(SmsG_ContactsActivity.LOG_TAG, "ImageAdapter.contacs.size(): " + contacts.size());
		mContext = c;
	}

	@Override
	public int getCount() {
		return contacts.size();
//		return mThumbIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View grid;
		// If its a new image, inflate it with R.layout.user_image
		// (RelativeLayout).
		if (convertView == null) {
			grid = new View(mContext);
			LayoutInflater inflater = LayoutInflater.from(mContext);
			grid = inflater.inflate(R.layout.user_image, parent, false);
		} else {
			grid = (View) convertView;
		}

		ImageView contactImage = (ImageView) grid
				.findViewById(R.id.contactImage);
		TextView contactName = (TextView) grid.findViewById(R.id.contactName);

		// Scale and crop the image in each cell to be a square
		// TODO: Does not affect text or image lower bar... need to fix that
		contactImage.setLayoutParams(new RelativeLayout.LayoutParams(
				getWidth() / 4, getWidth() / 4));

		// Scale it to the center
		contactImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

		// Set image resource according to its position
		// TODO: pull data from Device Contacts
		// Use 0 for testing purpose only
		if (contacts.get(position).getPhotoURI()== null){
			contactImage.setImageResource(mThumbIds[0]);
		} else {
			// TODO need to implement setting contact uri
//			Uri imageUri = new Uri();
//			contactImage.setImageURI(imageUri);
		}
		contactName.setText(contacts.get(position).getContactName());
//		contactName.setText(mNames[position]);

		return grid;
	}

	// Returns the device current width. *For future usage*
	// Right now returns a static 480px dimension to work on my tablet
	private int getWidth() {
		DisplayMetrics metrics = new DisplayMetrics();
		mContext.getSystemService(Context.WINDOW_SERVICE);
		// mContext.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		// return metrics.widthPixels;
		// return 720;
		return 480;
	}
}
