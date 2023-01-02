package com.example.graphqlexample.presentation.common.base

import androidx.activity.ComponentActivity
import com.example.graphqlexample.R
import com.example.graphqlexample.presentation.common.showToast


open class BaseActivity : ComponentActivity() {

    fun onError(throwable: Throwable) {
        showToast(throwable.message ?: getString(R.string.title_default_Error))
    }

    fun onLoading(showLoading: Boolean) {
        if (showLoading)
            showToast(resources.getString(R.string.title_loading))
    }


}