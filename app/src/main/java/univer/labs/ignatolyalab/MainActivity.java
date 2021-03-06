package univer.labs.ignatolyalab;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);

//        TelephonyManager tm = (TelephonyManager)
//                getSystemService(this.TELEPHONY_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            String imei = tm.getImei();
//        } else {
//            String imei = tm.getDeviceId();
//        }
        final String OSVERSION = System.getProperty("os.version");
        final String RELEASE = android.os.Build.VERSION.RELEASE;
        final String DEVICE = android.os.Build.DEVICE;
        final String MODEL = android.os.Build.MODEL;
        final String PRODUCT = android.os.Build.PRODUCT;
        final String BRAND = android.os.Build.BRAND;
        final String DISPLAY = android.os.Build.DISPLAY;
        final String CPU_ABI = android.os.Build.CPU_ABI;
        final String CPU_ABI2 = android.os.Build.CPU_ABI2;
        final String UNKNOWN = android.os.Build.UNKNOWN;
        final String HARDWARE = android.os.Build.HARDWARE;
        final String ID = android.os.Build.ID;
        final String MANUFACTURER = android.os.Build.MANUFACTURER;
        final String SERIAL = android.os.Build.SERIAL;
        final String USER = android.os.Build.USER;
        final String HOST = android.os.Build.HOST;
        final String DEVICE_IMEI = getIMEINumber();

        String textInfo = OSVERSION +
                RELEASE +
                DEVICE +
                MODEL +
                PRODUCT +
                BRAND +
                DISPLAY +
                CPU_ABI +
                CPU_ABI2 +
                UNKNOWN +
                HARDWARE +
                ID +
                MANUFACTURER +
                SERIAL +
                USER +
                HOST +
                DEVICE_IMEI;


        int unicalId = 0;
        for (int i = 0; i < textInfo.length(); i++) {
            unicalId = unicalId + (byte) textInfo.charAt(i);
        }

        mTextView.setText("RELEASE: " + RELEASE + "\n" +
                "DEVICE: " + DEVICE + "\n" +
                "MODEL: " + MODEL + "\n" +
                "PRODUCT: " + PRODUCT + "\n" +
                "BRAND: " + BRAND + "\n" +
                "DISPLAY: " + DISPLAY + "\n" +
                "CPU_ABI: " + CPU_ABI + "\n" +
                "CPU_ABI2: " + CPU_ABI2 + "\n" +
                "HARDWARE: " + HARDWARE + "\n" +
                "ID: " + ID + "\n" +
                "MANUFACTURER: " + MANUFACTURER + "\n" +
                "SERIAL: " + SERIAL + "\n" +
                "USER: " + USER + "\n" +
                "HOST: " + HOST + "\n" +
                "DEVICE IMEI: " + DEVICE_IMEI + "\n" +
                "UNICAL ID: " + String.valueOf(unicalId));

    }

    @SuppressLint("MissingPermission")
    private String getIMEINumber() {
        String deviceUniqueIdentifier = null;
        TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                deviceUniqueIdentifier = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
            }else{
                deviceUniqueIdentifier = tm.getDeviceId();
            }
        return deviceUniqueIdentifier;
    }
}
