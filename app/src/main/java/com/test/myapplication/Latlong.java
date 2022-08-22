package com.test.myapplication;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Latlong {
        @SerializedName("distance")
        @Expose
        private String distance;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("address_1")
        @Expose
        private String address1;
        @SerializedName("address_2")
        @Expose
        private String address2;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("country_code")
        @Expose
        private String countryCode;
        @SerializedName("std_code")
        @Expose
        private String stdCode;
        @SerializedName("telephone_1")
        @Expose
        private String telephone1;
        @SerializedName("telephone_2")
        @Expose
        private String telephone2;
        @SerializedName("comm_email")
        @Expose
        private String commEmail;
        @SerializedName("alt_email")
        @Expose
        private String altEmail;
        @SerializedName("website")
        @Expose
        private String website;
        @SerializedName("reservation_link")
        @Expose
        private String reservationLink;
        @SerializedName("tariff_min_rate")
        @Expose
        private String tariffMinRate;
        @SerializedName("tariff_max_rate")
        @Expose
        private String tariffMaxRate;
        @SerializedName("place")
        @Expose
        private String place;
        @SerializedName("district_id")
        @Expose
        private String districtId;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("classification_id")
        @Expose
        private String classificationId;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("image")
        @Expose
        private String image;

    public Latlong(String lat, String lon) {
        this.latitude=lat;
        this.longitude = lon;
    }


    public Latlong(int id, String name, String phno, String website, String adrs) {
        this.name = name;
        this.id = String.valueOf(id);
        this.mobile = phno;
        this.website = website;
        this.address1 =adrs;
    }

    public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getStdCode() {
            return stdCode;
        }

        public void setStdCode(String stdCode) {
            this.stdCode = stdCode;
        }

        public String getTelephone1() {
            return telephone1;
        }

        public void setTelephone1(String telephone1) {
            this.telephone1 = telephone1;
        }

        public String getTelephone2() {
            return telephone2;
        }

        public void setTelephone2(String telephone2) {
            this.telephone2 = telephone2;
        }

        public String getCommEmail() {
            return commEmail;
        }

        public void setCommEmail(String commEmail) {
            this.commEmail = commEmail;
        }

        public String getAltEmail() {
            return altEmail;
        }

        public void setAltEmail(String altEmail) {
            this.altEmail = altEmail;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getReservationLink() {
            return reservationLink;
        }

        public void setReservationLink(String reservationLink) {
            this.reservationLink = reservationLink;
        }

        public String getTariffMinRate() {
            return tariffMinRate;
        }

        public void setTariffMinRate(String tariffMinRate) {
            this.tariffMinRate = tariffMinRate;
        }

        public String getTariffMaxRate() {
            return tariffMaxRate;
        }

        public void setTariffMaxRate(String tariffMaxRate) {
            this.tariffMaxRate = tariffMaxRate;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getDistrictId() {
            return districtId;
        }

        public void setDistrictId(String districtId) {
            this.districtId = districtId;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getClassificationId() {
            return classificationId;
        }

        public void setClassificationId(String classificationId) {
            this.classificationId = classificationId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

    }
