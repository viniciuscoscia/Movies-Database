package br.com.viniciuscoscia.moviesdatabase.ui.home

import android.os.Bundle
import br.com.viniciuscoscia.moviesdatabase.R
import br.com.viniciuscoscia.moviesdatabase.commons.BaseActivity

class HomeActivity : BaseActivity<HomeViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        lifecycle.addObserver(viewModel)
    }
}