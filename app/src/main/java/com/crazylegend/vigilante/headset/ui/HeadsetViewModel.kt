package com.crazylegend.vigilante.headset.ui

import android.app.Application
import com.crazylegend.vigilante.abstracts.AbstractPagingViewModel
import com.crazylegend.vigilante.headset.database.HeadsetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by crazy on 11/5/20 to long live and prosper !
 */
@HiltViewModel
class HeadsetViewModel @Inject constructor(
        private val repo: HeadsetRepository,
        application: Application) : AbstractPagingViewModel(application) {

    val headsetData = provideDatabaseData { repo.getAllHeadsetRecords() }

}