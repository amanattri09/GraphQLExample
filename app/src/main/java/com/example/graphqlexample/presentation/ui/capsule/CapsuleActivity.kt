package com.example.graphqlexample.presentation.ui.capsule

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.example.composeexamplev3.presentation.common.customObserve
import com.example.graphqlexample.data.remote.capsule.entities.CapsulesResponse
import com.example.graphqlexample.presentation.common.base.BaseActivity
import com.example.graphqlexample.presentation.common.theme.GraphQlExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CapsuleActivity : BaseActivity() {

    private val capsuleViewModel: CapsuleViewModel by viewModels()
    private val mutableStateFlowPosts = mutableStateOf<CapsulesResponse?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQlExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    showPosts(mutableStateFlowPosts)
                }
            }
        }
        setObserver()
        init()
    }

    private fun init() {
        capsuleViewModel.getCapsules()
    }

    private fun setObserver() {
        capsuleViewModel.liveDataCapsules.customObserve(this, onLoading = ::onLoading, ::onError) {
            mutableStateFlowPosts.value = it
        }
    }
}

@Composable
fun showPosts(mutableStateFlowPosts: MutableState<CapsulesResponse?>) {

}
