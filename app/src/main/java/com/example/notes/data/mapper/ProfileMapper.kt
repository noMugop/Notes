package com.example.notes.data.mapper

import com.example.notes.data.database.module.ProfileDbModel
import com.example.notes.data.network.module.ProfileDto
import com.example.notes.domain.entity.Profile
import javax.inject.Inject

class ProfileMapper @Inject constructor() {

    fun mapDtoToProfile(profileDto: ProfileDto) = Profile(
        id = profileDto.id,
        name = profileDto.name,
        email = profileDto.email,
        phone = profileDto.phone,
        avatar = profileDto.avatar,
        position = profileDto.position,
        companyName = profileDto.companyName,
        nameEng = profileDto.nameEng,
        timezone = profileDto.timezone,
        alertEmail = profileDto.alertEmail
    )

    fun mapDbModelToProfile(profileDto: ProfileDbModel) = Profile (
        id = profileDto.id,
        name = profileDto.name,
        email = profileDto.email,
        phone = profileDto.phone,
        avatar = profileDto.avatar,
        position = profileDto.position,
        companyName = profileDto.companyName,
        nameEng = profileDto.nameEng,
        timezone = profileDto.timezone,
        alertEmail = profileDto.alertEmail
    )

    fun mapProfileToDbModel(profileDto: Profile) = ProfileDbModel (
        id = profileDto.id,
        name = profileDto.name,
        email = profileDto.email,
        phone = profileDto.phone,
        avatar = profileDto.avatar,
        position = profileDto.position,
        companyName = profileDto.companyName,
        nameEng = profileDto.nameEng,
        timezone = profileDto.timezone,
        alertEmail = profileDto.alertEmail
    )
}