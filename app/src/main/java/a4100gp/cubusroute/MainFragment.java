package a4100gp.cubusroute;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends ListFragment implements SearchView.OnQueryTextListener, MenuItem.OnActionExpandListener {

    List<String> mAllValues;
    private ArrayAdapter<String> mAdapter;
    private Context mContext;
    String[] itemname ={
            "1A",
            "1B",
            "2",
            "3",
            "4",
            "5",
            "6"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        setHasOptionsMenu(true);
        populateList();

    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        String item = (String) listView.getAdapter().getItem(position);
        if (position == 0){
            Intent i = new Intent(mContext, a4100gp.cubusroute.MapActivity1A.class);
            i.putExtra("viewpager_position", position);
            startActivity(i);
        }else if (position == 1){
            Intent i = new Intent(mContext, a4100gp.cubusroute.MapActivity1B.class);
            i.putExtra("viewpager_position", position);
            startActivity(i);
        }else if (position == 2){
            Intent i = new Intent(mContext, a4100gp.cubusroute.MapActivity2.class);
            i.putExtra("viewpager_position", position);
            startActivity(i);
        }else if (position == 3){
            Intent i = new Intent(mContext, a4100gp.cubusroute.MapActivity3.class);
            i.putExtra("viewpager_position", position);
            startActivity(i);
        }else if (position == 4){
            Intent i = new Intent(mContext, a4100gp.cubusroute.MapActivity4.class);
            i.putExtra("viewpager_position", position);
            startActivity(i);
        }
//        if (getActivity() instanceof OnItem1SelectedListener) {
//            ((OnItem1SelectedListener) getActivity()).OnItem1SelectedListener(item);
//        }
        getFragmentManager().popBackStack();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_search, container, false);
        ListView listView = (ListView) layout.findViewById(android.R.id.list);
        TextView emptyTextView = (TextView) layout.findViewById(android.R.id.empty);
        listView.setEmptyView(emptyTextView);
        return layout;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint("Search");

        super.onCreateOptionsMenu(menu, inflater);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            resetSearch();
            return false;
        }

        List<String> filteredValues = new ArrayList<String>(mAllValues);
        for (String value : mAllValues) {
            if (!value.toLowerCase().contains(newText.toLowerCase())) {
                filteredValues.remove(value);
            }
        }
        //mAdapter = new CustomListAdapter(this, itemname);
        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, filteredValues);
        setListAdapter(mAdapter);

        return false;
    }

    public void resetSearch() {
        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mAllValues);
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return true;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return true;
    }

    public interface OnItem1SelectedListener {
        void OnItem1SelectedListener(String item);
    }

    private void populateList(){

        mAllValues = new ArrayList<>();
        mAllValues.add("1A");
        mAllValues.add("1B");
        mAllValues.add("2");
        mAllValues.add("3");
        mAllValues.add("4");
        //mAdapter = new CustomListAdapter(mContext, itemname);
        mAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, mAllValues);
        setListAdapter(mAdapter);
    }
}