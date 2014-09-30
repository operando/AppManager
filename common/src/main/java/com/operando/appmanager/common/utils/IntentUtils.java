package com.operando.appmanager.common.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class IntentUtils {

    private IntentUtils() {
    }

    public static void uninstall(Context context, String packageName) {
        Uri uri = Uri.fromParts("package", packageName, null);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        context.startActivity(intent);
    }

    public static void uninstall(Activity activity, String packageName, int requestCode) {
        Uri uri = Uri.fromParts("package", packageName, null);
        Intent intent = new Intent(Intent.ACTION_DELETE, uri);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void openApplicationPage(Context context, String packageName) {
        Uri uri = Uri.parse("market://details?id=" + packageName);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(intent);
    }

}
