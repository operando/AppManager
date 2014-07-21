package com.operando.appmanager.common;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import lombok.Data;

@Data
public class ApplicationItem {

    private String appName;

    private String appPackageName;

    private Drawable appIcon;

    public ApplicationItem(ApplicationInfo appInfo, PackageManager packageManager) {
        setAppName(appInfo.loadLabel(packageManager).toString());
        setAppIcon(appInfo.loadIcon(packageManager));
        setAppPackageName(appInfo.packageName);
    }

}
