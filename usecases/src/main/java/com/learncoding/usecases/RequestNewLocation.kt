package com.learncoding.usecases

import android.location.Location
import com.learncoding.data.LocationsRepository

class RequestNewLocation(private val locationsRepository: LocationsRepository) {

    operator fun invoke(): List<Location> = locationsRepository.requestNewLocation()
}