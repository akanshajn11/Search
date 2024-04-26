package com.akansha.mvvm_compose_search.view.design

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.akansha.mvvm_compose_search.R
import com.akansha.mvvm_compose_search.view.theme.AppTheme

@Composable
fun ErrorView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.spacings.spacings16),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(id = R.string.error_title))
    }
}

@Preview
@Composable
fun PreviewErrorScreen() {
    ErrorView()
}