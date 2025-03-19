package com.capstone.signargi.di

import android.content.Context
import com.capstone.signargi.data.UserRepository
import com.capstone.signargi.data.pref.UserPreference
import com.capstone.signargi.data.pref.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepository.getInstance(pref)
    }
}