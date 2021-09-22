package com.learncoding.location.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learncoding.data.LocationsRepository
import com.learncoding.domain.Location
import com.learncoding.location.R
import com.learncoding.location.framework.FakeLocationSource
import com.learncoding.location.framework.InMemoryLocationPersistenceSource
import com.learncoding.location.ui.LocationsAdapter
import com.learncoding.location.ui.MainPresenter
import com.learncoding.usecases.GetLocations
import com.learncoding.usecases.RequestNewLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {
    private val presenter: MainPresenter
    private val locationsAdapter = LocationsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }

        recycler.adapter = locationsAdapter

        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }

        presenter.onCreate()

    }

    init {
        // This would be done by a dependency injector in a complex App
        //
        val persistence = InMemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = LocationsRepository(persistence, deviceLocation)
        presenter = MainPresenter(
            this,
            GetLocations(locationsRepository),
            RequestNewLocation(locationsRepository)
        )
    }

    override fun renderLocations(locations: List<com.learncoding.location.ui.Location>) {
        locationsAdapter.items = locations
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}