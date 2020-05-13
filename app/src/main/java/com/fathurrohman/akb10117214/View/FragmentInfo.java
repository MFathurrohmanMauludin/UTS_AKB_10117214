
/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.fathurrohman.akb10117214.Presenter.SlidePagerAdapter;
import com.fathurrohman.akb10117214.R;

import java.util.ArrayList;
import java.util.List;

// Sabtu 9 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class FragmentInfo extends Fragment{
    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_beranda, null, false);
        List<Fragment> list = new ArrayList<>();

        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());
        list.add(new PageFragment4());

        pager = view.findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter(getChildFragmentManager(), list);
        pager.setAdapter(pagerAdapter);
        return view;
    }



}
