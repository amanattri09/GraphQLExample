package com.example.graphqlexample.presentation.ui.capsule

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeexamplev3.presentation.common.customObserve
import com.example.graphqlexample.domain.post.models.CapsuleModel
import com.example.graphqlexample.presentation.common.base.BaseActivity
import com.example.graphqlexample.presentation.common.theme.GraphQlExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CapsuleActivity : BaseActivity() {

    private val capsuleViewModel: CapsuleViewModel by viewModels()
    private val mutableStateFlowPosts = mutableStateOf<List<CapsuleModel?>?>(null)

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
fun showPosts(mutableStateFlowPosts: MutableState<List<CapsuleModel?>?>) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Home") })
    }, content = {
        LazyColumn(content = {
            mutableStateFlowPosts.value?.forEach {
                item {
                    Text(
                        text = ("Capsule Id : " + it?.id),
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    )
                }
            }
        })
    })
}
