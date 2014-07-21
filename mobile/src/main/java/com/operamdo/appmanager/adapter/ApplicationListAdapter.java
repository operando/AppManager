package com.operamdo.appmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.operamdo.appmanager.R;
import com.operando.appmanager.common.ApplicationItem;
import com.operando.appmanager.common.adapter.BindableAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ApplicationListAdapter extends BindableAdapter<ApplicationItem> {

    static class ViewHolder {
        @InjectView(R.id.app_name)
        TextView mAppName;

        @InjectView(R.id.app_icon)
        ImageView mAppIcon;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    public ApplicationListAdapter(Context context, List<ApplicationItem> episodeList) {
        super(context, episodeList);
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View view = inflater.inflate(R.layout.applist_item, container, false);
        ViewHolder holder = new ViewHolder(view);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(ApplicationItem item, int position, View view) {
        ViewHolder holder = (ViewHolder) view.getTag();

        holder.mAppName.setText(item.getAppName());
        holder.mAppIcon.setImageDrawable(item.getAppIcon());
    }
}
