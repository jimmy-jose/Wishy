package wishy.xs.wishy.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wishy.xs.wishy.Beans.RowItem;
import wishy.xs.wishy.R;

/**
 * Created by Jimmy on 8/1/2017.
 */

public class DrawerCustomAdapter extends BaseAdapter {

    private Context mContext;
    private List<RowItem> rowItems;

    public DrawerCustomAdapter(Context mContext, List<RowItem> rowItems) {
        this.mContext = mContext;
        this.rowItems = rowItems;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtTitle;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return rowItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return rowItems.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = mInflater.inflate(R.layout.drawer_list_item, null);
            holder = new ViewHolder();
            holder.txtTitle = view.findViewById(R.id.title);
            holder.imageView = view.findViewById(R.id.icon);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }

        RowItem rowItem = (RowItem) getItem(i);

        holder.txtTitle.setText(rowItem.getTitle());
        holder.imageView.setImageResource(rowItem.getImageId());

        return view;
    }

}
