package com.ach.calendfi.entity;

import java.io.Serializable;

/**
 * (Activityinfo)Entity class
 *
 * @author makejava
 * @since 2021-10-21 21:34:20
 */
public class ActivityInfo implements Serializable {
    private static final long serialVersionUID = 635570693787176853L;

    private Integer id;
    /**
     * Project id
     */
    private Integer projectid;
    /**
     * Activity id
     */
    private Integer actividyid;
    /**
     * Activity type: distinguish between single currency and pair
     */
    private String type;
    /**
     * pair address/single currency address
     */
    private String pairaddress;
    /**
     * Reward address
     */
    private String rewardtoken;
    /**
     * amount
     */
    private String amount;
    /**
     * strarttime
     */
    private String strarttime;
    /**
     * duration
     */
    private String duration;
    /**
     * endtime
     */
    private String endtime;
    /**
     * inserttime
     */
    private String inserttime;

    /**
     * Pool id: the id of the LP where the pair is located, there is no need to set it for a single currency
     */
    private Integer poolid;

    /**
     * Stake coin name
     */
    private String pairname;

    //priceOfStakedToken
    private String priceOfStakedToken;

    //rewardTokenPrice
    private String rewardTokenPrice;

    private String rgb0;

    private String rgb1;

    private String rewardTokenName;

    private String version;

    private String isdel;

    //Single currency farm usage
    private String symbol0;
    //Single currency farm usage
    private String piclink0;

    private int flag;

    private String dailyamount;

    private String sustainabledays;

    private String apr;

    private String directdivided;

    private String indirectdivided;

    private String directweight;

    private String indirectweight;

    private String isleaderboard;

    private int directinviteCount;

    private int indirectinviteCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getActividyid() {
        return actividyid;
    }

    public void setActividyid(Integer actividyid) {
        this.actividyid = actividyid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPairaddress() {
        return pairaddress;
    }

    public void setPairaddress(String pairaddress) {
        this.pairaddress = pairaddress;
    }

    public String getRewardtoken() {
        return rewardtoken;
    }

    public void setRewardtoken(String rewardtoken) {
        this.rewardtoken = rewardtoken;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStrarttime() {
        return strarttime;
    }

    public void setStrarttime(String strarttime) {
        this.strarttime = strarttime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getInserttime() {
        return inserttime;
    }

    public void setInserttime(String inserttime) {
        this.inserttime = inserttime;
    }

    public String getPairname() {
        return pairname;
    }

    public void setPairname(String pairname) {
        this.pairname = pairname;
    }

    public Integer getPoolid() {
        return poolid;
    }

    public void setPoolid(Integer poolid) {
        this.poolid = poolid;
    }

    public String getPriceOfStakedToken() {
        return priceOfStakedToken;
    }

    public void setPriceOfStakedToken(String priceOfStakedToken) {
        this.priceOfStakedToken = priceOfStakedToken;
    }

    public String getRewardTokenPrice() {
        return rewardTokenPrice;
    }

    public void setRewardTokenPrice(String rewardTokenPrice) {
        this.rewardTokenPrice = rewardTokenPrice;
    }

    public String getRgb0() {
        return rgb0;
    }

    public void setRgb0(String rgb0) {
        this.rgb0 = rgb0;
    }

    public String getRgb1() {
        return rgb1;
    }

    public void setRgb1(String rgb1) {
        this.rgb1 = rgb1;
    }

    public String getRewardTokenName() {
        return rewardTokenName;
    }

    public void setRewardTokenName(String rewardTokenName) {
        this.rewardTokenName = rewardTokenName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getSymbol0() {
        return symbol0;
    }

    public void setSymbol0(String symbol0) {
        this.symbol0 = symbol0;
    }

    public String getPiclink0() {
        return piclink0;
    }

    public void setPiclink0(String piclink0) {
        this.piclink0 = piclink0;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDailyamount() {
        return dailyamount;
    }

    public void setDailyamount(String dailyamount) {
        this.dailyamount = dailyamount;
    }

    public String getSustainabledays() {
        return sustainabledays;
    }

    public void setSustainabledays(String sustainabledays) {
        this.sustainabledays = sustainabledays;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getDirectdivided() {
        return directdivided;
    }

    public void setDirectdivided(String directdivided) {
        this.directdivided = directdivided;
    }

    public String getIndirectdivided() {
        return indirectdivided;
    }

    public void setIndirectdivided(String indirectdivided) {
        this.indirectdivided = indirectdivided;
    }

    public String getDirectdweight() {
        return directweight;
    }

    public void setDirectdweight(String directdweight) {
        this.directweight = directdweight;
    }

    public String getIndirectweight() {
        return indirectweight;
    }

    public void setIndirectweight(String indirectweight) {
        this.indirectweight = indirectweight;
    }

    public String getIsleaderboard() {
        return isleaderboard;
    }

    public void setIsleaderboard(String isleaderboard) {
        this.isleaderboard = isleaderboard;
    }

    public String getDirectweight() {
        return directweight;
    }

    public void setDirectweight(String directweight) {
        this.directweight = directweight;
    }

    public int getDirectinviteCount() {
        return directinviteCount;
    }

    public void setDirectinviteCount(int directinviteCount) {
        this.directinviteCount = directinviteCount;
    }

    public int getIndirectinviteCount() {
        return indirectinviteCount;
    }

    public void setIndirectinviteCount(int indirectinviteCount) {
        this.indirectinviteCount = indirectinviteCount;
    }
}

