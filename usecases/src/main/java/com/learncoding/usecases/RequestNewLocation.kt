package com.learncoding.usecases

import com.learncoding.data.LocationsRepository
import com.learncoding.domain.Location

class RequestNewLocation(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()
}