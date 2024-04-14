package com.akansha.mvvm.view.design

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ProgressScreen() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val progress = createRef()
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .constrainAs(progress) {
                    centerHorizontallyTo(parent)
                    centerVerticallyTo(parent)
                },
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}