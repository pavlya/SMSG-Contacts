package com.pavelalon.smsg_contacts.view;

import java.util.ArrayList;
import java.util.List;

import com.pavelalon.smsg_contacts.adapters.ImageAdapter;
import com.pavelalon.smsg_contacts.beans.ContactEntity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class SmsG_ContactsActivity extends Activity {

	private static final String _ID = "_id";
	private static final String DISPLAY_NAME = "display_name";
	private static final String PHOTO_URI = "PHOTO_URI";
	public static final String LOG_TAG = "SMS_G_CONTACTS";
	private ListView lvText;
	private ArrayAdapter<String> namesAdapter;
	private List<ContactEntity> contacts;
	private ImageAdapter mAdapter;
	private GridView gridview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sms_g__contacts);

		contacts = new ArrayList<ContactEntity>();

		ContentResolver contentResolver = getContentResolver();
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		String[] projection = null;
		String selection = null;
		String[] selectionArgs = null;
		String sortOrder = null;

		Cursor cursor = contentResolver.query(uri, projection, selection,
				selectionArgs, sortOrder);
		int contactsCount = cursor.getColumnCount();
		Log.d(LOG_TAG, "Contacts rows: " + contactsCount);

		getContacts(cursor);
		
//		getContactsColumnNames(cursor, contactsCount);

		mAdapter = new ImageAdapter(this, contacts);
		gridview = (GridView) findViewById(R.id.gridView);
		gridview.setAdapter(mAdapter);

		// lvText = (ListView)findViewById(R.id.lv_names);
		// List<String> names = new ArrayList<String>();
		// namesAdapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, names);
		// lvText.setAdapter(namesAdapter);

		if (cursor != null) {
			cursor.close();
		}

	}

	private void getContactsColumnNames(Cursor cursor, int contactsCount) {
		cursor.moveToFirst();
		for (int i = 0; i < contactsCount; i++) {
			String s = cursor.getColumnName(i);
			Log.d(LOG_TAG, Integer.toString(i) + "  " + s);
		}
	}

	private void getContacts(Cursor cursor) {
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				String id = cursor.getString(cursor.getColumnIndex(_ID));
//					Log.d(LOG_TAG, "Contact ID is: " + id);
				
				String photoURI = cursor.getString(cursor
						.getColumnIndex(PHOTO_URI));
				if (photoURI != null) {
//					Log.d(LOG_TAG, "Photo URI for contact: " + photoURI);
				}
				String name = cursor.getString(cursor
						.getColumnIndex(DISPLAY_NAME));
				// names.add(name);
				if (photoURI != null){
					contacts.add(new ContactEntity(Integer.valueOf(id), name, photoURI));
				} else {
					contacts.add(new ContactEntity(Integer.valueOf(id), name, null));
				}
				// Log.d(LOG_TAG, "SmsG_ContactsActivity.onCreate contactName "
				// + name);
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sms_g__contacts, menu);
		return true;
	}

}
