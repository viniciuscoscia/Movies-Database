package br.com.viniciuscoscia.moviesdatabase.commons

import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
//open class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
//    val viewModel: VM by lazy { getViewModel(viewModelClass()) }

//    @Suppress("UNCHECKED_CAST")
//    private fun viewModelClass(): KClass<VM> {
//        return ((javaClass.genericSuperclass as ParameterizedType)
//            .actualTypeArguments[0] as Class<VM>).kotlin
//    }
}