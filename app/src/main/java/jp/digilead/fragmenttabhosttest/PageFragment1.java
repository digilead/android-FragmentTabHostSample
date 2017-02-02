package jp.digilead.fragmenttabhosttest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PageFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PageFragment1 extends Fragment
{
    public PageFragment1()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static PageFragment1 newInstance()
    {
        PageFragment1 fragment = new PageFragment1();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null)
//        {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_1, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        setOnClickListener(view);
    }

    private void setOnClickListener(View view)
    {
        view.findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Fragment fragment = getParentFragment();
                if (fragment != null && fragment instanceof TabFragment)
                {
                    ((TabFragment) fragment).createFragment(PageFragment2.newInstance(), true);
                }
            }
        });
    }
}
