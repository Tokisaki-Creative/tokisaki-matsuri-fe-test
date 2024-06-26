package com.tokisaki.tokisakimatsuri.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("authorization")
	val authorization: Authorization? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class User(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("email_verified_at")
	val emailVerifiedAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null
)

data class Authorization(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("expires_in")
	val expiresIn: Int? = null,

	@field:SerializedName("token")
	val token: String? = null
)
