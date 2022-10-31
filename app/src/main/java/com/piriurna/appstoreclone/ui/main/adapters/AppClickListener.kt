package com.piriurna.appstoreclone.ui.main.adapters

import com.piriurna.domain.models.App

interface AppClickListener {

    fun onAppClicked(app : App)
}