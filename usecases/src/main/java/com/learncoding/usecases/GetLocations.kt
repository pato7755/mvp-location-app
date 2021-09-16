package com.learncoding.usecases

import android.location.Location
import com.learncoding.data.LocationsRepository

class GetLocations(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()

}