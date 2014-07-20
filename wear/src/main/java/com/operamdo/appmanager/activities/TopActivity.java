package com.operamdo.appmanager.activities;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.widget.ListView;

import com.operamdo.appmanager.R;
import com.operamdo.appmanager.adapter.ApplicationListAdapter;
import com.operando.appmanager.common.ApplicationItem;
import com.operando.appmanager.common.ApplicationListLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TopActivity extends Activity implements LoaderManager.LoaderCallbacks<List<ApplicationItem>> {

    @InjectView(R.id.app_list)
    ListView mAppList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rect_activity_top);
        ButterKnife.inject(this);

        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<List<ApplicationItem>> onCreateLoader(int id, Bundle args) {
        ApplicationListLoader appLoader = new ApplicationListLoader(this);
        appLoader.forceLoad();

        return appLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<ApplicationItem>> loader, List<ApplicationItem> data) {
        mAppList.setAdapter(new ApplicationListAdapter(this, data));
    }

    @Override
    public void onLoaderReset(Loader<List<ApplicationItem>> loader) {
    }
}
