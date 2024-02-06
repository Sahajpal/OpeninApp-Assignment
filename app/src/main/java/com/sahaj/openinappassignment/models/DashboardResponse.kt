package com.sahaj.openinappassignment.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DashboardResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("statusCode") var statusCode: Int? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("support_whatsapp_number") var supportWhatsappNumber: String? = null,
    @SerializedName("extra_income") var extraIncome: Double? = null,
    @SerializedName("total_links") var totalLinks: Int? = null,
    @SerializedName("total_clicks") var totalClicks: Int? = null,
    @SerializedName("today_clicks") var todayClicks: Int? = null,
    @SerializedName("top_source") var topSource: String? = null,
    @SerializedName("top_location") var topLocation: String? = null,
    @SerializedName("startTime") var startTime: String? = null,
    @SerializedName("links_created_today") var linksCreatedToday: Int? = null,
    @SerializedName("applied_campaign") var appliedCampaign: Int? = null,
    @SerializedName("data") var data: Data? = Data()
)

data class Data(
    @SerializedName("recent_links") var recentLinks: ArrayList<Links> = arrayListOf(),
    @SerializedName("top_links") var topLinks: ArrayList<Links> = arrayListOf(),
    @SerializedName("favourite_links") var favouriteLinks: ArrayList<String> = arrayListOf(),
    @SerializedName("overall_url_chart") @Expose var overallUrlChart: Map<String, Float> = HashMap()
)