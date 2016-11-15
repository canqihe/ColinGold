package com.colin.gold.bean;

import java.util.List;

/**
 * Created by Colin on 2016/11/14 15:06.
 * 邮箱：cartier_he@163.com
 * 微信：cartier_he
 */

public class GoldBean {


    /**
     * status : 0
     * msg : ok
     * result : [{"type":"Au(T+D)","typename":"黄金延期","price":"269.53","openingprice":"277.30","maxprice":"278.30","minprice":"267.43","changepercent":"-3.07%","lastclosingprice":"278.07","tradeamount":"185842.0000","updatetime":"2016-11-14 14:45:07"},{"type":"mAu(T+D)","typename":"迷你黄金延期","price":"269.79","openingprice":"277.89","maxprice":"278.50","minprice":"267.60","changepercent":"-3.08%","lastclosingprice":"278.37","tradeamount":"19645.2000","updatetime":"2016-11-14 14:45:08"},{"type":"Au99.99","typename":"沪金99","price":"269.82","openingprice":"278.35","maxprice":"280.00","minprice":"268.00","changepercent":"-3.11%","lastclosingprice":"278.47","tradeamount":"17051.7800","updatetime":"2016-11-14 14:45:07"},{"type":"Au99.95","typename":"沪金95","price":"269.65","openingprice":"277.60","maxprice":"277.60","minprice":"268.30","changepercent":"-3.18%","lastclosingprice":"278.51","tradeamount":"1994.0000","updatetime":"2016-11-14 14:44:41"},{"type":"iAu99.99","typename":"IAU99.99","price":"270.00","openingprice":"272.00","maxprice":"272.00","minprice":"267.00","changepercent":"-2.74%","lastclosingprice":"277.60","tradeamount":"915.9000","updatetime":"2016-11-14 14:41:35"},{"type":"Au(T+N2)","typename":"延期双金","price":"269.45","openingprice":"278.45","maxprice":"278.45","minprice":"268.45","changepercent":"-3.25%","lastclosingprice":"278.50","tradeamount":"280.0000","updatetime":"2016-11-14 14:43:34"},{"type":"Au100g","typename":"沪金100G","price":"270.60","openingprice":"278.39","maxprice":"278.40","minprice":"268.50","changepercent":"-3.14%","lastclosingprice":"279.37","tradeamount":"226.4000","updatetime":"2016-11-14 14:44:23"},{"type":"Pt99.95","typename":"沪铂95","price":"220.75","openingprice":"226.00","maxprice":"226.00","minprice":"220.50","changepercent":"-3.35%","lastclosingprice":"228.40","tradeamount":"204.0000","updatetime":"2016-11-14 14:30:12"},{"type":"Au(T+N1)","typename":"延期单金","price":"272.80","openingprice":"278.55","maxprice":"281.80","minprice":"271.00","changepercent":"-3.13%","lastclosingprice":"281.60","tradeamount":"163.2000","updatetime":"2016-11-14 14:45:00"},{"type":"iAu100g","typename":"IAU100G","price":"0.00","openingprice":"0.00","maxprice":"0.00","minprice":"0.00","changepercent":"0.00%","lastclosingprice":"282.00","tradeamount":"0.0000","updatetime":"2016-11-14 00:23:01"},{"type":"iAu99.5","typename":"IAU99.5","price":"0.00","openingprice":"0.00","maxprice":"0.00","minprice":"0.00","changepercent":"0.00%","lastclosingprice":"237.80","tradeamount":"0.0000","updatetime":"2016-11-13 19:41:16"}]
     */

    private String status;
    private String msg;
    /**
     * type : Au(T+D)
     * typename : 黄金延期
     * price : 269.53
     * openingprice : 277.30
     * maxprice : 278.30
     * minprice : 267.43
     * changepercent : -3.07%
     * lastclosingprice : 278.07
     * tradeamount : 185842.0000
     * updatetime : 2016-11-14 14:45:07
     */

    private List<ResultEntity> result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public static class ResultEntity {
        private String type;
        private String typename;
        private String price;
        private String openingprice;
        private String maxprice;
        private String minprice;
        private String changepercent;
        private String lastclosingprice;
        private String tradeamount;
        private String updatetime;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOpeningprice() {
            return openingprice;
        }

        public void setOpeningprice(String openingprice) {
            this.openingprice = openingprice;
        }

        public String getMaxprice() {
            return maxprice;
        }

        public void setMaxprice(String maxprice) {
            this.maxprice = maxprice;
        }

        public String getMinprice() {
            return minprice;
        }

        public void setMinprice(String minprice) {
            this.minprice = minprice;
        }

        public String getChangepercent() {
            return changepercent;
        }

        public void setChangepercent(String changepercent) {
            this.changepercent = changepercent;
        }

        public String getLastclosingprice() {
            return lastclosingprice;
        }

        public void setLastclosingprice(String lastclosingprice) {
            this.lastclosingprice = lastclosingprice;
        }

        public String getTradeamount() {
            return tradeamount;
        }

        public void setTradeamount(String tradeamount) {
            this.tradeamount = tradeamount;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}
