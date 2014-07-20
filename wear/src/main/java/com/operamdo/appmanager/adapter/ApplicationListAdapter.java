package com.operamdo.appmanager.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.operamdo.appmanager.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ApplicationListAdapter extends BindableAdapter<ApplicationInfo> {


    static class ViewHolder {
        @InjectView(R.id.app_name)
        TextView mAppName;

        @InjectView(R.id.app_icon)
        ImageView mAppIcon;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    PackageManager mPackageManager;


    public ApplicationListAdapter(Context context, List<ApplicationInfo> episodeList) {
        super(context, episodeList);
        mPackageManager = context.getPackageManager();
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View view = inflater.inflate(R.layout.applist_item, container, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(ApplicationInfo item, int position, View view) {
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.mAppName.setText(item.loadLabel(mPackageManager));
        holder.mAppIcon.setImageDrawable(item.loadIcon(mPackageManager));
    }


}
