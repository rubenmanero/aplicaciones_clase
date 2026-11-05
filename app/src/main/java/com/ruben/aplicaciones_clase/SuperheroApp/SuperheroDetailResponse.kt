package com.ruben.aplicaciones_clase.SuperheroApp

import com.google.gson.annotations.SerializedName

data class SuperheroDetailResponse (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: PowerStatsResponse,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("image") val image: SuperheroImageDetailResponse
)

data class PowerStatsResponse(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
)

data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("publisher") val publisher: String
)

data class SuperheroImageDetailResponse(
    @SerializedName("url") val url: String
)

