package com.example.graphqlexample.presentation.ui.capsule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.FindCapsulesQuery
import com.example.composeexamplev3.domain.post.ICapsuleRepositary
import com.example.composeexamplev3.presentation.common.customCollect
import com.example.graphqlexample.data.common.ApiResponse
import com.example.graphqlexample.domain.post.models.CapsuleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleViewModel @Inject constructor(private val capsuleRepo: ICapsuleRepositary) : ViewModel() {

    val liveDataCapsules = MutableLiveData<ApiResponse<List<CapsuleModel?>?>>()

    fun getCapsules() {
        viewModelScope.launch {
            capsuleRepo.getCapsules().customCollect(liveDataCapsules)
        }
    }

}