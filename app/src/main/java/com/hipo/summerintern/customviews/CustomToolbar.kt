/*
 * Copyright 2022 Pera Wallet, LDA
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.hipo.summerintern.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.hipo.summerintern.core.fragment.ToolbarConfiguration
import com.hipo.summerintern.databinding.CustomToolbarBinding
import com.hipo.summerintern.utils.viewbinding.viewBinding

class CustomToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding = viewBinding(CustomToolbarBinding::inflate)

    fun configure(toolbarConfiguration: ToolbarConfiguration?) {
        if (toolbarConfiguration == null) {
            isVisible = false
            return
        }
        with(toolbarConfiguration) {
            initTitle(titleResId)
            configureStartButton(startIconResId, startIconClick)
        }
        isVisible = true
    }

    fun setTitle(title: String?) {
        with(binding.toolbarTitleTextView) {
            isVisible = title != null
            text = title.orEmpty()
        }
    }

    private fun initTitle(titleResId: Int?) {
        with(binding.toolbarTitleTextView) {
            isVisible = titleResId != null
            if (titleResId != null) setText(titleResId)
        }
    }

    private fun configureStartButton(resId: Int?, clickAction: (() -> Unit)?) {
        binding.startImageButton.apply {
            if (resId == null) {
                isVisible = false
                return
            }
            setImageResource(resId)
            setOnClickListener { clickAction?.invoke() }
            isVisible = true
        }
    }
}
