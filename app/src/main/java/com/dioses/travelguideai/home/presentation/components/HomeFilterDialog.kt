package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dioses.travelguideai.home.presentation.HomeFilterDialogAction
import com.dioses.travelguideai.home.domain.HomeFilterSettings

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 11/04/24 at 10:35 PM
 * All rights reserved 2024.
 ****/
@Composable
fun HomeFilterDialog(
    onDismiss: () -> Unit,
    filterSettings: HomeFilterSettings,
    onAction: (HomeFilterDialogAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Personas")
                    HomeFilterIncrement(
                        number = filterSettings.people,
                        onMinus = { onAction(HomeFilterDialogAction.OnPeopleMinus) },
                        onPlus = { onAction(HomeFilterDialogAction.OnPeoplePlus) })
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Restaurante")
                    HomeFilterCheckBox(
                        onclick = { onAction(HomeFilterDialogAction.OnRestaurantClick) },
                        isChecked = filterSettings.restaurant
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Museos")
                    HomeFilterCheckBox(
                        onclick = { onAction(HomeFilterDialogAction.OnMuseumClick) },
                        isChecked = filterSettings.museums
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
                Row(verticalAlignment = Alignment.Bottom) {
                    Button(
                        onClick = { onAction(HomeFilterDialogAction.OnApplyClick) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Aplicar")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeFilterDialogPreview() {
    HomeFilterDialog({}, HomeFilterSettings(), {})
}