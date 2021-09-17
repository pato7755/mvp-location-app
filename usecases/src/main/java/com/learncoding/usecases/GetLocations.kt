package com.learncoding.usecases

import com.learncoding.data.LocationsRepository
import com.learncoding.domain.Location

class GetLocations(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.getSavedLocations()

}