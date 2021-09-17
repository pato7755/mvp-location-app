package com.learncoding.location.framework

import com.learncoding.data.DeviceLocationSource
import com.learncoding.domain.Location
import java.util.*
import kotlin.random.Random

class FakeLocationSource: DeviceLocationSource {

    private val random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location = Location(random.nextDouble() * 180 - 90, random.nextDouble() * 360 - 180, Date())

}