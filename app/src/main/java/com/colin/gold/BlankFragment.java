package com.colin.gold;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.colin.gold.bean.GoldBean;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BlankFragment extends Fragment {

    GoldBean.ResultEntity goldBean;
    View view;
    @Bind(R.id.price)
    TextView price;
    @Bind(R.id.openingprice)
    TextView openingprice;
    @Bind(R.id.maxprice)
    TextView maxprice;
    @Bind(R.id.minprice)
    TextView minprice;
    @Bind(R.id.changepercent)
    TextView changepercent;
    @Bind(R.id.lastclosingprice)
    TextView lastclosingprice;
    @Bind(R.id.tradeamount)
    TextView tradeamount;
    @Bind(R.id.type)
    TextView type;
    @Bind(R.id.openingprice_icon)
    ImageView openingpriceIcon;
    @Bind(R.id.maxprice_icon)
    ImageView maxpriceIcon;
    @Bind(R.id.minprice_icon)
    ImageView minpriceIcon;
    @Bind(R.id.changepercent_icon)
    ImageView changepercentIcon;
    @Bind(R.id.lastclosingprice_icon)
    ImageView lastclosingpriceIcon;
    @Bind(R.id.tradeamount_icon)
    ImageView tradeamountIcon;
    @Bind(R.id.lin1)
    RelativeLayout lin1;
    @Bind(R.id.lin2)
    RelativeLayout lin2;
    @Bind(R.id.lin3)
    RelativeLayout lin3;
    @Bind(R.id.lin4)
    RelativeLayout lin4;
    @Bind(R.id.lin5)
    RelativeLayout lin5;
    @Bind(R.id.lin6)
    RelativeLayout lin6;
    @Bind(R.id.lin7)
    RelativeLayout lin7;

    public BlankFragment(GoldBean.ResultEntity info) {
        this.goldBean = info;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        price.setText(goldBean.getPrice());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "price" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getPrice()))
            price.setTextColor(Color.parseColor("#ffff4444"));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "price" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getPrice()))
            price.setTextColor(Color.parseColor("#ff99cc00"));
        PreUtils.setString(getActivity(), "price" + goldBean.getType(), goldBean.getPrice());

        //开盘价
        openingprice.setText(goldBean.getOpeningprice());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "openingPrice" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getOpeningprice()))
            openingpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "openingPrice" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getOpeningprice()))
            openingpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "openingPrice" + goldBean.getType(), goldBean.getOpeningprice());

        //最高价
        maxprice.setText(goldBean.getMaxprice());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "maxPrice" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getMaxprice()))
            maxpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "maxPrice" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getMaxprice()))
            maxpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "maxPrice" + goldBean.getType(), goldBean.getMaxprice());

        //最低价
        minprice.setText(goldBean.getMinprice());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "minPrice" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getMinprice()))
            minpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "minPrice" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getMinprice()))
            minpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "minPrice" + goldBean.getType(), goldBean.getMinprice());

        //涨跌幅
        changepercent.setText(goldBean.getChangepercent());
        if (Double.parseDouble(Utils.subStringLastOne(PreUtils.getString(getActivity(), "changePercent" + goldBean.getType(), "12.12"))) < Double.parseDouble(Utils.subStringLastOne(goldBean.getChangepercent())))
            changepercentIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(Utils.subStringLastOne(PreUtils.getString(getActivity(), "changePercent" + goldBean.getType(), "12.12"))) > Double.parseDouble(Utils.subStringLastOne(goldBean.getChangepercent())))
            changepercentIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "changePercent" + goldBean.getType(), goldBean.getChangepercent());

        //昨日收盘价
        lastclosingprice.setText(goldBean.getLastclosingprice());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "lastCloseingPrice" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getLastclosingprice()))
            lastclosingpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "lastCloseingPrice" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getLastclosingprice()))
            lastclosingpriceIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "lastCloseingPrice" + goldBean.getType(), goldBean.getLastclosingprice());

        //总成交量
        tradeamount.setText(goldBean.getTradeamount());
        if (Double.parseDouble(PreUtils.getString(getActivity(), "tradeaMount" + goldBean.getType(), "12.12")) < Double.parseDouble(goldBean.getTradeamount()))
            tradeamountIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        else if (Double.parseDouble(PreUtils.getString(getActivity(), "tradeaMount" + goldBean.getType(), "12.12")) > Double.parseDouble(goldBean.getTradeamount()))
            tradeamountIcon.setImageDrawable(getActivity().getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
        PreUtils.setString(getActivity(), "tradeaMount" + goldBean.getType(), goldBean.getTradeamount());

        //品种代码
        type.setText(goldBean.getType());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.lin1, R.id.lin2, R.id.lin3, R.id.lin4, R.id.lin5, R.id.lin6, R.id.lin7})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin1:
                break;
            case R.id.lin2:
                break;
            case R.id.lin3:
                break;
            case R.id.lin4:
                break;
            case R.id.lin5:
                break;
            case R.id.lin6:
                break;
            case R.id.lin7:
                break;
        }
    }
}
