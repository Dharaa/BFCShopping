package com.example.bfcfashion.auth.model.CreateProduct;

import com.google.gson.annotations.SerializedName;

public class CreateCategoryResponse{

	@SerializedName("device_id")
	private String deviceId;

	@SerializedName("sku-url")
	private String skuUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("ip_address")
	private String ipAddress;

	@SerializedName("title")
	private String title;

	@SerializedName("category-id")
	private int categoryId;

	public void setDeviceId(String deviceId){
		this.deviceId = deviceId;
	}

	public String getDeviceId(){
		return deviceId;
	}

	public void setSkuUrl(String skuUrl){
		this.skuUrl = skuUrl;
	}

	public String getSkuUrl(){
		return skuUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIpAddress(String ipAddress){
		this.ipAddress = ipAddress;
	}

	public String getIpAddress(){
		return ipAddress;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}
}