package com.operando.appmanager.common;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class ApplicationListLoader extends AsyncTaskLoader<List<ApplicationInfo>> {

    PackageManager mPackageManager;

    public ApplicationListLoader(Context context) {
        super(context);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public List<ApplicationInfo> loadInBackground() {
        List<ApplicationInfo> infos = mPackageManager
                .getInstalledApplications(PackageManager.GET_META_DATA);

        return infos;
    }
}
