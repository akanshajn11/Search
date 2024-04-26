package com.akansha.mvvm_compose_search.view.design

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akansha.mvvm_compose_search.R

@Composable
fun EmptyView(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.empty_screen_title),
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = stringResource(id = R.string.empty_screen_subtitle),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun EmptyScreenPreview() {
    EmptyView()
}