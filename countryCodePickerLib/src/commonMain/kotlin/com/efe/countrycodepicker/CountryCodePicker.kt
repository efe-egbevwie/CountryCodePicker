package com.efe.countrycodepicker

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CountryCodePickerDialog(
    modifier: Modifier = Modifier,
    showCountryCode: Boolean = false,
    onDismiss: () -> Unit,
    onCountrySelected: (Country) -> Unit,
) {
    AdaptiveDialog(
        modifier = modifier,
        onDismiss = onDismiss,
    ) {
        var searchQuery: String? by remember { mutableStateOf(null) }

        Column(modifier = Modifier) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = searchQuery.orEmpty(),
                    modifier = Modifier.fillMaxWidth(0.8f),
                    placeholder = {
                        Text(
                            "Search by name, code or ISO",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    trailingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    },
                    onValueChange = { newValue ->
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
                        showCountryCode = showCountryCode,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
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
fun CountryCodePickerDropDown(
    expanded: Boolean,
    showCountryCode: Boolean,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset,
    onCountrySelected: (Country) -> Unit
) {
    Box {
        var searchQuery by remember { mutableStateOf("") }
        DropdownMenu(
            offset = offset,
            modifier = modifier.height(300.dp),
            expanded = expanded,
            onDismissRequest = onDismiss
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                OutlinedTextField(
                    modifier = Modifier.width(300.dp),
                    value = searchQuery,
                    placeholder = {
                        Text(
                            "Search by name, code or ISO",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    trailingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    },
                    onValueChange = { newQuery ->
                        searchQuery = newQuery
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                CountryCodePickerLazyColumn(
                    modifier = Modifier.height(300.dp).width(300.dp),
                    searchQuery = searchQuery,
                    countryRowContent = { country ->
                        CountryDropDownRow(
                            country = country,
                            showCountryCode = showCountryCode,
                            modifier = Modifier
                                .clickable {
                                    onCountrySelected(country)
                                    onDismiss()
                                }
                                .padding(10.dp)
                        )
                    }
                )
            }
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
        if (searchQuery.isNullOrBlank()
                .not()
        ) Country.filter(searchQuery.toString()) else Country.entries
    LazyColumn(modifier = modifier) {
        items(countryList) { country ->
            countryRowContent.invoke(country)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AdaptiveDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
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
                Dialog(
                    onDismissRequest = onDismiss,
                    properties = DialogProperties(usePlatformDefaultWidth = false)
                ) {
                    Surface(
                        color = Color.White,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxWidth(0.3f).fillMaxHeight(0.5f)
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
private fun CountryRow(
    country: Country,
    showCountryCode: Boolean,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(country.getFlag()),
            contentDescription = country.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(40.dp)
                .height(30.dp)
                .padding(start = 10.dp)
        )

        Spacer(modifier = Modifier.width(20.dp))

        if (showCountryCode) {
            Text(text = country.phoneCode, modifier = Modifier.weight(1f))
        }
        Text(text = country.countryName, modifier = Modifier.weight(2f))
    }
}

@Composable
private fun CountryDropDownRow(
    country: Country,
    showCountryCode: Boolean,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(country.getFlag()),
            contentDescription = country.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(40.dp)
                .height(30.dp)
                .padding(start = 10.dp)
                .weight(1f)
        )

        Spacer(modifier = Modifier.width(20.dp))

        if (showCountryCode) {
            Text(text = country.phoneCode, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(20.dp))
        }
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
                    CountryRow(
                        country = country,
                        showCountryCode = true,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            )
        }
    }
}

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }