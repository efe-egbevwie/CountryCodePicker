import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.efe.countrycodepicker.Country
import com.efe.countrycodepicker.CountryCodePickerDialog
import com.efe.countrycodepicker.CountryCodePickerDropDown
import com.efe.countrycodepicker.getFlag
import com.efe.countrycodepicker.pxToDp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            Modifier.fillMaxSize()
        ) {
            var selectedCountry by remember { mutableStateOf(Country.Australia) }
            var showPicker by remember { mutableStateOf(false) }
            var selectedDisplayType by remember { mutableStateOf(DisplayType.Dialog) }
            val showCountryCode by remember { mutableStateOf(true) }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Country Code Picker dialog demo",
                    style = MaterialTheme.typography.titleMedium
                )
                DialogTypePicker(
                    selectedDisplayType = selectedDisplayType
                ) { newDisplayType ->
                    selectedDisplayType = newDisplayType
                }

                Box {
                    var selectorHeight by remember { mutableStateOf(0) }
                    CountryPicker(modifier = Modifier
                        .clickable { showPicker = !showPicker }
                        .onGloballyPositioned { layoutCoordinates ->
                            selectorHeight = layoutCoordinates.size.height
                        },
                        currentCountry = selectedCountry
                    )

                    when (selectedDisplayType) {
                        DisplayType.Dialog -> {
                            if (showPicker) {
                                CountryCodePickerDialog(
                                    showCountryCode = showCountryCode,
                                    onDismiss = { showPicker = false },
                                ) { country ->
                                    selectedCountry = country
                                }
                            }
                        }

                        DisplayType.DropDown -> {
                            if (showPicker) {
                                CountryCodePickerDropDown(
                                    expanded = true,
                                    offset = DpOffset(x = 0.dp, y = selectorHeight.pxToDp()),
                                    showCountryCode = showCountryCode,
                                    onDismiss = {
                                        showPicker = false
                                    }
                                ) { country ->
                                    selectedCountry = country
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogTypePicker(
    modifier: Modifier = Modifier,
    selectedDisplayType: DisplayType,
    onDisplayTypeSelected: (DisplayType) -> Unit
) {
    Row(modifier) {
        DisplayType.entries.forEach { displayType ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(end = 20.dp)
            ) {
                Text(text = displayType.name)
                RadioButton(
                    selected = selectedDisplayType == displayType,
                    onClick = { onDisplayTypeSelected(displayType) }
                )
            }
        }
    }
}

@Composable
private fun CountryPicker(modifier: Modifier = Modifier, currentCountry: Country) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(currentCountry.getFlag()),
            contentDescription = currentCountry.countryName,
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(40.dp)
        )

        Text(text = currentCountry.countryName)
        Text(text = currentCountry.phoneCode)
    }

}

enum class DisplayType {
    Dialog,
    DropDown
}