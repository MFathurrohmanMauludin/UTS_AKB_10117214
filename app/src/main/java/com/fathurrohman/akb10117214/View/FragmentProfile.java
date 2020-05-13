/*
 * M Fathurrohman Mauludin - 10117214
 */

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

public class FragmentProfile extends Fragment {
    TextView nim, nama, kelas, deskripsi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile, container, false);
        nim = view.findViewById(R.id.tv_nim);
        nama = view.findViewById(R.id.tv_nama);
        kelas = view.findViewById(R.id.tv_kelas);
        deskripsi = view.findViewById(R.id.tv_deskripsi);

        nim.setText("NIM: 10117214");
        nama.setText("Nama: M Fathurrohman Mauludin");
        kelas.setText("Kelas: IF-7");
        deskripsi.setText("Deskripsi: \nMahasiswa dari jurusan Teknik Informatika di UNIKOM yang sedang menempuh jenjang pendidikan S1");
        return view;
    }
}
