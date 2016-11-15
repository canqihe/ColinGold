package com.colin.gold;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutFragment extends Fragment {

    View view;
    @Bind(R.id.github)
    Button github;
    @Bind(R.id.ins)
    Button ins;
    @Bind(R.id.gplus)
    Button gplus;

    public AboutFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.github, R.id.ins, R.id.gplus})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.github:
                goChrome("https://github.com/canqihe");
                break;
            case R.id.ins:
                goChrome("https://www.instagram.com/mr.canqi/");
                break;
            case R.id.gplus:
                goChrome("https://plus.google.com/109218788195104150608");
                break;

        }
    }

    public void goChrome(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
