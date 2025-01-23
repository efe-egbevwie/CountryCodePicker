import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.efe.countrycodepicker.Country
import com.efe.countrycodepicker.CountryCodePickerDialog
import com.efe.countrycodepicker.getFlag
import org.jetbrains.compose.resources.DrawableResource
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
            var showDialog by remember { mutableStateOf(false) }
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.align(Alignment.Center).clickable { showDialog = !showDialog },
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(selectedCountry.getFlag()),
                    contentDescription = selectedCountry.countryName,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.width(18.dp)
                        .height(18.dp)
                )

                Text(text = selectedCountry.countryName)
                Text(text = selectedCountry.phoneCode)
            }
            if (showDialog) {
                CountryCodePickerDialog(
                    onDismiss = { showDialog = false },
                ) { country ->
                    selectedCountry = country
                }
            }
        }
    }
}