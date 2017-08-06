package wishy.xs.wishy.activities;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import wishy.xs.wishy.adapters.DrawerCustomAdapter;
import wishy.xs.wishy.beans.RowItem;
import wishy.xs.wishy.fragments.AddWishListFragment;
import wishy.xs.wishy.R;

public class MainFullscreenActivity extends AppCompatActivity {

    private String[] listItemTitles;
    private TypedArray listItemIcons;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private List<RowItem> rowItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(R.layout.drawer_menu);

        Fragment fragment = new AddWishListFragment();
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.content_frame, fragment,"WIshlists")
                .commit();

        listItemTitles = getResources().getStringArray(R.array.listItemTitles);
        listItemIcons = getResources().obtainTypedArray(R.array.listItemIcons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        rowItems = new ArrayList<>();
        for (int i = 0; i < listItemTitles.length; i++) {
            RowItem item = new RowItem( listItemIcons.getResourceId(i,-1),listItemTitles[i]);
            rowItems.add(item);
        }
        DrawerCustomAdapter adapter = new DrawerCustomAdapter(getApplicationContext(),rowItems);
        // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private void selectItem(int position) {
        // Create a new fragment and specify the planet to show based on position
        Fragment fragment = new AddWishListFragment();
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();

        // Highlight the selected item, update the title, and close the drawer
        mDrawerList.setItemChecked(position, true);
//        setTitle(listItemTitles[position]);
//        mDrawerLayout.closeDrawer(mDrawerList);
    }

}
