package com.sabbirtech.mobidoc;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.sabbirtech.mobidoc.helper.DatabaseHelper;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;

/**
 * Created by SABBIR TECH on 03-Sep-18.
 */

public class ImageProvider extends ContentProvider {

    public static final String LOG_TAG = ImageProvider.class.getSimpleName();


    /** URI matcher code for the content URI for the pictures table */
    private static final int PICTURES = 100;

    /** URI matcher code for the content URI for a single picture in the movies table */
    private static final int PICTURES_ID = 101;
    public static final String CONTENT_AUTHORITY = "com.sabbirtech.mobidoc";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);


    public static final String PATH_IMAGES = "image-path";

    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_IMAGES);

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    static {
        // The calls to addURI() go here, for all of the content URI patterns that the provider
        // should recognize. All paths added to the UriMatcher have a corresponding code to return
        // when a match is found.

        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_IMAGES, PICTURES);

        sUriMatcher.addURI(CONTENT_AUTHORITY, PATH_IMAGES + "/#", PICTURES_ID);

    }

    private DatabaseHelper dbHelper;

    @Override
    public boolean onCreate() {

        dbHelper = new DatabaseHelper(getContext());
        return true;

    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projections, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch (match) {
            case PICTURES:

                cursor = database.query(dbHelper.TABLE_IMAGE, projections, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            case PICTURES_ID:

                selection = _ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };

                cursor = database.query(dbHelper.TABLE_IMAGE, projections, selection, selectionArgs,
                        null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        // Set notification URI on the Cursor,
        // so we know what content URI the Cursor was created for.
        // If the data at this URI changes, then we know we need to update the Cursor.
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        // Return the cursor
        return cursor;
       
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PICTURES:
                return insertCart(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }

    }

    private Uri insertCart(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
