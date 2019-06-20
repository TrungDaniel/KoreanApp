package com.example.koreanapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.annotation.Annotation;
import java.util.List;

public class PlaceResult implements Parcelable {

    @SerializedName("placeID")
    @Expose
    public Integer placeID;
    @SerializedName("placeName")
    @Expose
    public String placeName;
    @SerializedName("urlLogoPlace")
    @Expose
    public String urlLogoPlace;
    @SerializedName("categoryID")
    @Expose
    public Integer categoryID;
    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("urlWeb")
    @Expose
    public String urlWeb;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("urlBanner")
    @Expose
    public Object urlBanner;
    @SerializedName("isMoreDetail")
    @Expose
    public Integer isMoreDetail;
    @SerializedName("isPromotion")
    @Expose
    public Integer isPromotion;
    @SerializedName("longitude")
    @Expose
    public double longitude;
    @SerializedName("latitude")
    @Expose
    public double latitude;
    @SerializedName("kakaoTalk")
    @Expose
    public String kakaoTalk;
    @SerializedName("listMedia")
    @Expose
    public List<Object> listMedia = null;

    public PlaceResult(Parcel in) {
        if (in.readByte() == 0) {
            placeID = null;
        } else {
            placeID = in.readInt();
        }
        placeName = in.readString();
        urlLogoPlace = in.readString();
        if (in.readByte() == 0) {
            categoryID = null;
        } else {
            categoryID = in.readInt();
        }
        address = in.readString();
        phone = in.readString();
        urlWeb = in.readString();
        description = in.readString();
        if (in.readByte() == 0) {
            isMoreDetail = null;
        } else {
            isMoreDetail = in.readInt();
        }
        if (in.readByte() == 0) {
            isPromotion = null;
        } else {
            isPromotion = in.readInt();
        }
        longitude = in.readDouble();
        latitude = in.readDouble();
        kakaoTalk = in.readString();
    }

    public static final Creator<PlaceResult> CREATOR = new Creator<PlaceResult>() {
        @Override
        public PlaceResult createFromParcel(Parcel in) {
            return new PlaceResult(in);
        }

        @Override
        public PlaceResult[] newArray(int size) {
            return new PlaceResult[size];
        }
    };

    public PlaceResult(Integer placeID, String placeName, String urlLogoPlace, Integer categoryID, String address, String phone, String urlWeb, String description, Object urlBanner, Integer isMoreDetail, Integer isPromotion, double longitude, double latitude, String kakaoTalk, List<Object> listMedia) {
        this.placeID = placeID;
        this.placeName = placeName;
        this.urlLogoPlace = urlLogoPlace;
        this.categoryID = categoryID;
        this.address = address;
        this.phone = phone;
        this.urlWeb = urlWeb;
        this.description = description;
        this.urlBanner = urlBanner;
        this.isMoreDetail = isMoreDetail;
        this.isPromotion = isPromotion;
        this.longitude = longitude;
        this.latitude = latitude;
        this.kakaoTalk = kakaoTalk;
        this.listMedia = listMedia;
    }

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getUrlLogoPlace() {
        return urlLogoPlace;
    }

    public void setUrlLogoPlace(String urlLogoPlace) {
        this.urlLogoPlace = urlLogoPlace;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(Object urlBanner) {
        this.urlBanner = urlBanner;
    }

    public Integer getIsMoreDetail() {
        return isMoreDetail;
    }

    public void setIsMoreDetail(Integer isMoreDetail) {
        this.isMoreDetail = isMoreDetail;
    }

    public Integer getIsPromotion() {
        return isPromotion;
    }

    public void setIsPromotion(Integer isPromotion) {
        this.isPromotion = isPromotion;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getKakaoTalk() {
        return kakaoTalk;
    }

    public void setKakaoTalk(String kakaoTalk) {
        this.kakaoTalk = kakaoTalk;
    }

    public List<Object> getListMedia() {
        return listMedia;
    }

    public void setListMedia(List<Object> listMedia) {
        this.listMedia = listMedia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (placeID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(placeID);
        }
        dest.writeString(placeName);
        dest.writeString(urlLogoPlace);
        if (categoryID == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(categoryID);
        }
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(urlWeb);
        dest.writeString(description);
        if (isMoreDetail == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isMoreDetail);
        }
        if (isPromotion == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isPromotion);
        }
        dest.writeDouble(longitude);
        dest.writeDouble(latitude);
        dest.writeString(kakaoTalk);
    }
}