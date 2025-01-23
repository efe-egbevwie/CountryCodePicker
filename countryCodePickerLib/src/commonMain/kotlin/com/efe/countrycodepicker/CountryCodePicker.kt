package com.efe.countrycodepicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CountryCodePickerDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onCountrySelected: (Country) -> Unit,
) {
    AdaptiveDialog(
        modifier = modifier,
        onDismiss = onDismiss,
    ) {
        var filterText by remember {
            mutableStateOf("")
        }
        var searchQuery: String? by remember { mutableStateOf(null) }

        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = filterText,
                    modifier = Modifier.fillMaxWidth(0.8f),
                    placeholder = {
                        Text("Search by name, code or ISO")
                    },
                    trailingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    },
                    onValueChange = { newValue ->
                        filterText = newValue
                        searchQuery = newValue
                    },
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CountryCodePickerLazyColumn(
                searchQuery = searchQuery,
                countryRowContent = { country ->
                    CountryRow(
                        country = country,
                        showCountryCode = true,
                        modifier = Modifier.clickable {
                            onCountrySelected(country)
                            onDismiss()
                        }
                            .padding(12.dp)
                    )
                }
            )
        }
    }

}

@Composable
fun CountryCodePickerLazyColumn(
    searchQuery: String? = null,
    countryRowContent: @Composable (Country) -> Unit,
    modifier: Modifier = Modifier,
) {
    val countryList: List<Country> =
        if (searchQuery.isNullOrBlank().not()) Country.filter(searchQuery.toString()) else Country.entries
    LazyColumn(modifier = modifier) {
        items(countryList) { country ->
            countryRowContent.invoke(country)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AdaptiveDialog(modifier: Modifier = Modifier, onDismiss: () -> Unit, content: @Composable () -> Unit) {
    BoxWithConstraints(modifier) {
        val width = constraints.maxWidth
        val windowSize = WindowSize.getWindowSize(width.pxToDp())
        when (windowSize) {
            WindowSize.COMPACT -> {
                val state = rememberModalBottomSheetState(skipPartiallyExpanded = false)
                ModalBottomSheet(
                    modifier = Modifier.fillMaxHeight(),
                    sheetState = state,
                    onDismissRequest = onDismiss,
                ) {
                    content()
                }
            }

            WindowSize.MEDIUM, WindowSize.EXPANDED -> {
                Dialog(onDismissRequest = onDismiss, properties = DialogProperties(usePlatformDefaultWidth = false)) {
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(0.5f).fillMaxHeight(0.5f)
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
private fun CountryRow(country: Country, showCountryCode: Boolean, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(country.getFlag()),
            contentDescription = country.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier.width(18.dp)
                .height(18.dp)
                .weight(1f)
        )

        if (showCountryCode) Text(text = country.phoneCode, modifier = Modifier.weight(1f))
        Text(text = country.countryName, modifier = Modifier.weight(2f))
    }
}


@Composable
@Preview
private fun CountryCodePickerPreview() {
    MaterialTheme {
        Surface {
            CountryCodePickerLazyColumn(
                countryRowContent = { country ->
                    CountryRow(country = country, showCountryCode = true, modifier = Modifier.padding(12.dp))
                }
            )
        }
    }
}

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }