package wishy.xs.wishy.fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wishy.xs.wishy.R;

/**
 * Created by Jimmy on 7/31/2017.
 */

public class AddWishListFragment extends Fragment {
    private TextView addWishList;
    private Context mContext;

    public AddWishListFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_wish_list,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addWishList = view.findViewById(R.id.addWIshListMessage);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Typeface tf = Typeface.createFromAsset(mContext.getAssets(),"fonts/OpenSansCondensed-Light.ttf");
        addWishList.setTypeface(tf,Typeface.BOLD);
    }
}
