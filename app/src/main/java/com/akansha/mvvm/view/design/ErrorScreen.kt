package com.akansha.mvvm.view.design

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ErrorScreen() {
    ConstraintLayout {
        val error = createRef()
        Text(
            text = "Error!",
            modifier = Modifier
                .constrainAs(error) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },

            )
    }
}