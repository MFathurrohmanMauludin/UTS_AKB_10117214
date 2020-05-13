package com.fathurrohman.akb10117214.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fathurrohman.akb10117214.R;

// Sabtu 9 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class FragmentKontak extends Fragment {
    TextView telepon, email, sosmed;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_contact, container, false);
        telepon = view.findViewById(R.id.tv_telepon);
        email = view.findViewById(R.id.tv_email);
        sosmed = view.findViewById(R.id.tv_sosmed);

        telepon.setText("No Telepon: 0895357235620");
        email.setText("Email: fathurdiakfari@gmail.com");
        sosmed.setText("Sosial Media: \nfacebook(@fathurrohman), instagram(@fathur_diakfari), Line(fathurrohman097).");

        return view;
    }
}
