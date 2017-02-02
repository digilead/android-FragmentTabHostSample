package jp.digilead.fragmenttabhosttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment implements MainActivity.OnBackPressedListener
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        createFragment(PageFragment1.newInstance(), false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    /**
     * create fragment
     *
     * @param fragment
     */
    void createFragment(Fragment fragment, boolean addToBackStack)
    {
        //   replace: remove creent and add new
        //   add: add new
        if (addToBackStack)
        {
            getChildFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)   // BackStackに追加
                    .add(R.id.content_frame, fragment)
                    .commit();
        }
        else
        {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_frame, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onBackPressed()
    {
        // count of stacked fragments
        int backStackCnt = getChildFragmentManager().getBackStackEntryCount();

        if (backStackCnt >= 1)
        {
            // if stacked fragments exist, show previous fragment

            // pop from stack
            getChildFragmentManager().popBackStack();

            return true;
        }

        return false;
    }
}
