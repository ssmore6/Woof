package com.example.shwetamore.woof;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shwetamore on 12/9/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        printHashkey();
    }

    public void printHashkey(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.shwetamore.woof",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("HASHKEY:", Base64.encodeToString(md.digest(), Base64.DEFAULT));

            }

        }
        catch (PackageManager.NameNotFoundException e){

        }
        catch(NoSuchAlgorithmException e){

        }
    }
}
