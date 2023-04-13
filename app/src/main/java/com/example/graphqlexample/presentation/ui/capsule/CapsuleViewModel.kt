package com.example.graphqlexample.presentation.ui.capsule

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeexamplev3.domain.post.ICharacterRepositary
import com.example.composeexamplev3.presentation.common.customCollect
import com.example.graphqlexample.data.common.ApiResponse
import com.example.graphqlexample.domain.capsule.models.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CapsuleViewModel @Inject constructor(private val capsuleRepo: ICharacterRepositary) : ViewModel() {

    val liveDataCapsules = MutableLiveData<ApiResponse<List<CharacterModel?>?>>()

    fun getCapsules() {
        viewModelScope.launch {
            capsuleRepo.getCharacters().customCollect(liveDataCapsules)
        }
    }

}