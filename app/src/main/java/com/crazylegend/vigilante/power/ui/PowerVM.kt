package com.crazylegend.vigilante.power.ui

import android.app.Application
import com.crazylegend.vigilante.abstracts.AbstractAVM
import com.crazylegend.vigilante.power.db.PowerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by crazy on 11/7/20 to long live and prosper !
 */
@HiltViewModel
class PowerVM @Inject constructor(private val powerRepository: PowerRepository, application: Application) : AbstractAVM(application) {

    val powerHistory = provideDatabaseData { powerRepository.getAllPowerActions() }
}