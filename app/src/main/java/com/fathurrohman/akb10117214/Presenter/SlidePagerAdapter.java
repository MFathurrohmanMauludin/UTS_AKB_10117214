/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.Presenter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

// Senin 11 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

import java.util.List;

public class SlidePagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentList;

    public SlidePagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
