package com.learning.composeexample.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import com.learning.composeexample.ui.state.CardUiState


// like a.. backing property
// 실제는 Stateful, Stateless를 구분하도록 하는데, 외부에서 ViewModel을 주입한다는 의미는
// ViewModel 내부의 State 변수가 변할 수 있다는 뜻이므로 StateFul한 형태이다.
@Composable
fun MainScreen(
    viewModel : MainViewModel
) {
    MainScreen(uiState = viewModel.uiState)
}
@Composable()
private fun MainScreen(
    uiState : CardUiState
) {

}