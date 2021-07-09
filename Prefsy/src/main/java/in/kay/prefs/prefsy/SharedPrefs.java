package in.kay.prefs.prefsy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.scottyab.aescrypt.AESCrypt;

import org.json.JSONException;
import org.json.JSONObject;

public class SharedPrefs {
    private static SharedPreferences mSharedPref;

    public SharedPrefs() {
    }

    public static void init(Context context) {
        if (mSharedPref == null)
            mSharedPref = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }
    public static void clear(Context context) {
        SharedPreferences settings = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
        settings.edit().clear().commit();
    }

    public static String getString(String key, String defValue) {
        return getString(key, defValue, "", "");
    }

    public static String getString(String key, String defValue, String encryptionKey, String encryptedText) {
        if (!encryptionKey.equalsIgnoreCase("") && !encryptedText.equalsIgnoreCase("")) {
            try {
                return AESCrypt.decrypt(encryptionKey, encryptedText);
            } catch (Exception e) {
                e.printStackTrace();
                return defValue + " error is " + e.getLocalizedMessage();
            }
        } else return mSharedPref.getString(key, defValue);
    }

    public static void setString(String key, String value, String encryptionKey) {
        if (!encryptionKey.equalsIgnoreCase("")) {
            try {
                String encryptedMsg = AESCrypt.encrypt(encryptionKey, value);
                SharedPreferences.Editor prefsEditor = mSharedPref.edit();
                prefsEditor.putString(key, encryptedMsg);
                prefsEditor.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            SharedPreferences.Editor prefsEditor = mSharedPref.edit();
            prefsEditor.putString(key, value);
            prefsEditor.commit();
        }
    }

    public static void setString(String key, String value) {
        setString(key, value, "");
    }


    public static boolean getBoolean(String key, boolean defValue) {
        return mSharedPref.getBoolean(key, defValue);
    }

    public static void setBoolean(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.commit();
    }

    public static Integer getInteger(String key, int defValue) {
        return mSharedPref.getInt(key, defValue);
    }

    public static void setInteger(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = mSharedPref.edit();
        prefsEditor.putInt(key, value).commit();
    }

}