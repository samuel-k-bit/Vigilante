package com.crazylegend.vigilante.intro

import android.os.Bundle
import android.view.View
import com.crazylegend.kotlinextensions.animations.playAnimation
import com.crazylegend.kotlinextensions.animations.zoomInDown
import com.crazylegend.kotlinextensions.views.setOnClickListenerCooldown
import com.crazylegend.viewbinding.viewBinding
import com.crazylegend.vigilante.R
import com.crazylegend.vigilante.abstracts.AbstractFragment
import com.crazylegend.vigilante.databinding.FragmentIntroFinalBinding
import com.crazylegend.vigilante.di.providers.prefs.DefaultPreferencessProvider
import com.crazylegend.vigilante.utils.DEFAULT_ANIM_TIME
import com.crazylegend.vigilante.utils.goToScreen
import com.crazylegend.vigilante.utils.uiAction
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by crazy on 11/9/20 to long live and prosper !
 */
@AndroidEntryPoint
class FinalScreenIntro : AbstractFragment<FragmentIntroFinalBinding>(R.layout.fragment_intro_final) {

    @Inject
    lateinit var prefsProvider: DefaultPreferencessProvider

    override val binding by viewBinding(FragmentIntroFinalBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiAction {
            binding.image.zoomInDown().playAnimation(DEFAULT_ANIM_TIME)
        }
        binding.finish.setOnClickListenerCooldown {
            prefsProvider.setIntroShown()
            proceedFurther()
        }
    }

    private fun proceedFurther() {
        goToScreen(FinalScreenIntroDirections.destinationHome())
    }
}