package com.colin.gold;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.colin.gold.bean.GoldBean;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.progress)
    ProgressBar mProgressBar;

    GoldBean goldBean;
    List<GoldBean.ResultEntity> result;
    GoldBean.ResultEntity goldEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("现货黄金价格");
//        getSupportActionBar().setIcon(R.mipmap.icon);
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getGoldPrice();

    }

    public void getGoldPrice() {
        OkHttpUtils
                .get()
                .url(GolbalContact.BASE_URL)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        e.printStackTrace();
                        Snackbar.make(toolbar, "网络访问错误。", Snackbar.LENGTH_SHORT).show();
                        mProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onResponse(String response) {
                        mProgressBar.setVisibility(View.GONE);
                        viewPager.setVisibility(View.VISIBLE);
                        goldBean = new Gson().fromJson(response, GoldBean.class);
                        List<GoldBean.ResultEntity> result = goldBean.getResult();
                        viewPager.setOffscreenPageLimit(9);
                        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), result);
                        viewPager.setAdapter(adapter);
                    }
                });
    }


    class FragmentAdapter extends FragmentPagerAdapter {
        List<GoldBean.ResultEntity> result;

        public FragmentAdapter(FragmentManager fm, List<GoldBean.ResultEntity> result) {
            super(fm);
            this.result = result;
        }

        @Override
        public Fragment getItem(int id) {
            if (id == result.size()) {
                return new AboutFragment();
            } else {
                GoldBean.ResultEntity info = result.get(id);
                return new BlankFragment(info);
            }

        }

        @Override
        public int getCount() {
            return result.size() + 1;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            getGoldPrice();
            Snackbar.make(toolbar, goldBean.getResult().get(0).getUpdatetime() + " 刷新完毕。", Snackbar.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}
