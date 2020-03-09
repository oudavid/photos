package com.acs.photos

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "camera")
data class Photo(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("camera")
    val camera: Camera
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "name")
data class Camera(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("name")
    val name: String
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("photos")
data class PhotoResponse(
    @JsonProperty("photos")
    val photos: List<Photo>
)