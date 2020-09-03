package br.com.viniciuscoscia.moviesdatabase.commons

import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

open class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
    val viewModel: VM by lazy { getViewModel(viewModelClass()) }

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<VM> {
        return ((javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<VM>).kotlin
    }
}