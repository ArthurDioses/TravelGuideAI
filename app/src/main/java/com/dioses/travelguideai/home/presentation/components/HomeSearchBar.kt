package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dioses.travelguideai.ui.theme.BackgroundGray
import com.dioses.travelguideai.ui.theme.DarkGreen

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 11/04/24 at 9:24 AM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeSearchBar(
    onSearch: () -> Unit,
    placeholder: String,
    inputText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = inputText,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        modifier = modifier.background(color = BackgroundGray, shape = RoundedCornerShape(86.dp)),
        singleLine = true,
        trailingIcon = {
            HomeSearchButton(
                icon = Icons.Default.Search,
                onClick = onSearch,
                modifier = Modifier.padding(8.dp)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = DarkGreen
        )
    )
}

@Preview
@Composable
fun HomeSearchBarPreview() {
    HomeSearchBar(onSearch = { },
        placeholder = "Pais, Ciudad",
        inputText = "Argentina",
        onValueChange = {})
}