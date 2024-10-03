package com.mhmdnurulkarim.favorite.di

import com.mhmdnurulkarim.favorite.FavoriteViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}