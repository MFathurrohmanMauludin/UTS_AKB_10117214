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

import com.fathurrohman.akb10117214.R;

// Senin 11 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class PageFragment3 extends Fragment {
    ViewGroup viewGroup;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.page_tiga, container, false);
        return viewGroup;
    }
}
