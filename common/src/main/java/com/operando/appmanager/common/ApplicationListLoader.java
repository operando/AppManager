package com.operando.appmanager.common;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.ArrayList;
import java.util.List;

public class ApplicationListLoader extends AsyncTaskLoader<List<ApplicationItem>> {

    private PackageManager mPackageManager;

    public ApplicationListLoader(Context context) {
        super(context);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public List<ApplicationItem> loadInBackground() {
        List<ApplicationInfo> applicationInfoList = mPackageManager
                .getInstalledApplications(PackageManager.GET_META_DATA);

        List<ApplicationItem> applicationItemList = new ArrayList<ApplicationItem>();

        for (ApplicationInfo applicationInfo : applicationInfoList) {
            applicationItemList.add(new ApplicationItem(applicationInfo, mPackageManager));
        }

        return applicationItemList;
    }
}
