package com.operamdo.appmanager.activitys;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.operamdo.appmanager.R;
import com.operamdo.appmanager.adapter.ApplicationListAdapter;
import com.operando.appmanager.common.ApplicationItem;
import com.operando.appmanager.common.ApplicationListLoader;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TopActivity extends Activity {

    @InjectView(R.id.app_list)
    ListView mAppList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        ButterKnife.inject(this);

        getLoaderManager().initLoader(0, null, new AppListLoaderCallbacks());
    }

    class AppListLoaderCallbacks implements LoaderManager.LoaderCallbacks<List<ApplicationItem>> {

        @Override
        public Loader<List<ApplicationItem>> onCreateLoader(int id, Bundle args) {
            ApplicationListLoader appLoader = new ApplicationListLoader(TopActivity.this);
            appLoader.forceLoad();

            return appLoader;
        }

        @Override
        public void onLoadFinished(Loader<List<ApplicationItem>> loader, List<ApplicationItem> data) {
            mAppList.setAdapter(new ApplicationListAdapter(TopActivity.this, data));
        }

        @Override
        public void onLoaderReset(Loader<List<ApplicationItem>> loader) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
