package com.efe.countrycodepicker


import countrycodepicker.countrycodepickerlib.generated.resources.Res
import countrycodepicker.countrycodepickerlib.generated.resources.allDrawableResources
import countrycodepicker.countrycodepickerlib.generated.resources.ivory_coast
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

enum class Country(
    val iso: String,
    val phoneCode: String,
    val countryName: String,
) {
    Afghanistan(
        iso = "AF",
        phoneCode = "+93",
        countryName = "Afghanistan",

        ),
    Albania(iso = "AL", phoneCode = "+355", countryName = "Albania"),
    Algeria(iso = "DZ", phoneCode = "+213", countryName = "Algeria"),
    Andorra(iso = "AD", phoneCode = "+376", countryName = "Andorra"),
    Angola(iso = "AO", phoneCode = "+244", countryName = "Angola"),
    AntiguaAndBarbuda(
        iso = "AG",
        phoneCode = "+1268",
        countryName = "Antigua and Barbuda"
    ),
    Argentina(iso = "AR", phoneCode = "+54", countryName = "Argentina"),
    Armenia(iso = "AM", phoneCode = "+374", countryName = "Armenia"),
    Aruba(iso = "AW", phoneCode = "+297", countryName = "Aruba"),
    Australia(iso = "AU", phoneCode = "+61", countryName = "Australia"),
    Austria(iso = "AT", phoneCode = "+43", countryName = "Austria"),
    Azerbaijan(iso = "AZ", phoneCode = "+994", countryName = "Azerbaijan"),
    Bahamas(iso = "BS", phoneCode = "+1242", countryName = "Bahamas"),
    Bahrain(iso = "BH", phoneCode = "+973", countryName = "Bahrain"),
    Bangladesh(iso = "BD", phoneCode = "+880", countryName = "Bangladesh"),
    Barbados(iso = "BB", phoneCode = "+1246", countryName = "Barbados"),
    Belarus(iso = "BY", phoneCode = "+375", countryName = "Belarus"),
    Belgium(iso = "BE", phoneCode = "+32", countryName = "Belgium"),
    Belize(iso = "BZ", phoneCode = "+501", countryName = "Belize"),
    Benin(iso = "BJ", phoneCode = "+229", countryName = "Benin"),
    Bhutan(iso = "BT", phoneCode = "+975", countryName = "Bhutan"),
    Bolivia(iso = "BO", phoneCode = "+591", countryName = "Bolivia"),
    BosniaAndHerzegovina(
        iso = "BA",
        phoneCode = "+387",
        countryName = "Bosnia and Herzegovina"
    ),
    Botswana(iso = "BW", phoneCode = "+267", countryName = "Botswana"),
    Brazil(iso = "BR", phoneCode = "+55", countryName = "Brazil"),
    Brunei(iso = "BN", phoneCode = "+673", countryName = "Brunei"),
    Bulgaria(iso = "BG", phoneCode = "+359", countryName = "Bulgaria"),
    BurkinaFaso(
        iso = "BF",
        phoneCode = "+226",
        countryName = "Burkina Faso"
    ),
    Burundi(iso = "BI", phoneCode = "+257", countryName = "Burundi"),
    Cambodia(iso = "KH", phoneCode = "+855", countryName = "Cambodia"),
    Cameroon(iso = "CM", phoneCode = "+237", countryName = "Cameroon"),
    Canada(iso = "CA", phoneCode = "+1", countryName = "Canada"),
    CapeVerde(iso = "CV", phoneCode = "+238", countryName = "Cape Verde"),

    CentralAfricanRepublic(
        iso = "CF",
        phoneCode = "+236",
        countryName = "Central African Republic"
    ),
    Chad(iso = "TD", phoneCode = "+235", countryName = "Chad"),
    Chile(iso = "CL", phoneCode = "+56", countryName = "Chile"),
    China(iso = "CN", phoneCode = "+86", countryName = "China"),
    Colombia(iso = "CO", phoneCode = "+57", countryName = "Colombia"),
    Comoros(iso = "KM", phoneCode = "+269", countryName = "Comoros"),

    CongoBrazzaville(iso = "CG", phoneCode = "+242", countryName = "Congo (Brazzaville)"),
    CongoKinshasa(iso = "CD", phoneCode = "+243", countryName = "Congo (Kinshasa)"),
    CostaRica(iso = "CR", phoneCode = "+506", countryName = "Costa Rica"),
    CoteDIvoire(
        iso = "CI",
        phoneCode = "+225",
        countryName = "Côte d'Ivoire"
    ),
    Croatia(iso = "HR", phoneCode = "+385", countryName = "Croatia"),
    Cuba(iso = "CU", phoneCode = "+53", countryName = "Cuba"),
    Cyprus(iso = "CY", phoneCode = "+357", countryName = "Cyprus"),
    CzechRepublic(
        iso = "CZ",
        phoneCode = "+420",
        countryName = "Czech Republic"
    ),
    Denmark(iso = "DK", phoneCode = "+45", countryName = "Denmark"),
    Djibouti(iso = "DJ", phoneCode = "+253", countryName = "Djibouti"),
    Dominica(iso = "DM", phoneCode = "+1767", countryName = "Dominica"),
    DominicanRepublic(
        iso = "DO",
        phoneCode = "+1809",
        countryName = "Dominican Republic"
    ),
    Ecuador(iso = "EC", phoneCode = "+593", countryName = "Ecuador"),
    Egypt(iso = "EG", phoneCode = "+20", countryName = "Egypt"),
    ElSalvador(
        iso = "SV",
        phoneCode = "+503",
        countryName = "El Salvador"
    ),
    EquatorialGuinea(
        iso = "GQ",
        phoneCode = "+240",
        countryName = "Equatorial Guinea"
    ),
    Eritrea(iso = "ER", phoneCode = "+291", countryName = "Eritrea"),
    Estonia(iso = "EE", phoneCode = "+372", countryName = "Estonia"),
    Ethiopia(iso = "ET", phoneCode = "+251", countryName = "Ethiopia"),
    Fiji(iso = "FJ", phoneCode = "+679", countryName = "Fiji"),
    Finland(iso = "FI", phoneCode = "+358", countryName = "Finland"),
    France(iso = "FR", phoneCode = "+33", countryName = "France"),
    Gabon(iso = "GA", phoneCode = "+241", countryName = "Gabon"),
    Gambia(iso = "GM", phoneCode = "+220", countryName = "Gambia"),
    Georgia(iso = "GE", phoneCode = "+995", countryName = "Georgia"),
    Germany(iso = "DE", phoneCode = "+49", countryName = "Germany"),
    Ghana(iso = "GH", phoneCode = "+233", countryName = "Ghana"),
    Greece(iso = "GR", phoneCode = "+30", countryName = "Greece"),
    Grenada(iso = "GD", phoneCode = "+1473", countryName = "Grenada"),
    Guatemala(iso = "GT", phoneCode = "+502", countryName = "Guatemala"),
    Guinea(iso = "GN", phoneCode = "+224", countryName = "Guinea"),
    GuineaBissau(
        iso = "GW",
        phoneCode = "+245",
        countryName = "Guinea-Bissau"
    ),
    Guyana(iso = "GY", phoneCode = "+592", countryName = "Guyana"),
    Haiti(iso = "HT", phoneCode = "+509", countryName = "Haiti"),
    Honduras(iso = "HN", phoneCode = "+504", countryName = "Honduras"),
    HongKong(iso = "HK", phoneCode = "+852", countryName = "Hong Kong"),
    Hungary(iso = "HU", phoneCode = "+36", countryName = "Hungary"),
    Iceland(iso = "IS", phoneCode = "+354", countryName = "Iceland"),
    India(iso = "IN", phoneCode = "+91", countryName = "India"),
    Indonesia(iso = "ID", phoneCode = "+62", countryName = "Indonesia"),
    Iran(iso = "IR", phoneCode = "+98", countryName = "Iran"),
    Iraq(iso = "IQ", phoneCode = "+964", countryName = "Iraq"),
    Ireland(iso = "IE", phoneCode = "+353", countryName = "Ireland"),
    Israel(iso = "IL", phoneCode = "+972", countryName = "Israel"),
    Italy(iso = "IT", phoneCode = "+39", countryName = "Italy"),
    Jamaica(iso = "JM", phoneCode = "+1876", countryName = "Jamaica"),
    Japan(iso = "JP", phoneCode = "+81", countryName = "Japan"),
    Jersey(iso = "JE", phoneCode = "+44", countryName = "Jersey"),
    Jordan(iso = "JO", phoneCode = "+962", countryName = "Jordan"),
    Kazakhstan(iso = "KZ", phoneCode = "+7", countryName = "Kazakhstan"),
    Kenya(iso = "KE", phoneCode = "+254", countryName = "Kenya"),
    Kiribati(iso = "KI", phoneCode = "+686", countryName = "Kiribati"),
    Kuwait(iso = "KW", phoneCode = "+965", countryName = "Kuwait"),
    Kyrgyzstan(iso = "KG", phoneCode = "+996", countryName = "Kyrgyzstan"),
    Laos(iso = "LA", phoneCode = "+856", countryName = "Laos"),
    Latvia(iso = "LV", phoneCode = "+371", countryName = "Latvia"),
    Lebanon(iso = "LB", phoneCode = "+961", countryName = "Lebanon"),
    Lesotho(iso = "LS", phoneCode = "+266", countryName = "Lesotho"),
    Liberia(iso = "LR", phoneCode = "+231", countryName = "Liberia"),
    Libya(iso = "LY", phoneCode = "+218", countryName = "Libya"),
    Liechtenstein(
        iso = "LI",
        phoneCode = "+423",
        countryName = "Liechtenstein"
    ),
    Lithuania(iso = "LT", phoneCode = "+370", countryName = "Lithuania"),
    Luxembourg(iso = "LU", phoneCode = "+352", countryName = "Luxembourg"),
    NorthMacedonia(
        iso = "MK",
        phoneCode = "+389",
        countryName = "North Macedonia"
    ),
    Madagascar(iso = "MG", phoneCode = "+261", countryName = "Madagascar"),
    Malawi(iso = "MW", phoneCode = "+265", countryName = "Malawi"),
    Malaysia(iso = "MY", phoneCode = "+60", countryName = "Malaysia"),
    Maldives(iso = "MV", phoneCode = "+960", countryName = "Maldives"),
    Mali(iso = "ML", phoneCode = "+223", countryName = "Mali"),
    Malta(iso = "MT", phoneCode = "+356", countryName = "Malta"),
    MarshallIslands(
        iso = "MH",
        phoneCode = "+692",
        countryName = "Marshall Islands"
    ),
    Mauritania(iso = "MR", phoneCode = "+222", countryName = "Mauritania"),
    Mauritius(iso = "MU", phoneCode = "+230", countryName = "Mauritius"),
    Mexico(iso = "MX", phoneCode = "+52", countryName = "Mexico"),
    Micronesia(iso = "FM", phoneCode = "+691", countryName = "Micronesia"),
    Moldova(iso = "MD", phoneCode = "+373", countryName = "Moldova"),
    Monaco(iso = "MC", phoneCode = "+377", countryName = "Monaco"),
    Mongolia(iso = "MN", phoneCode = "+976", countryName = "Mongolia"),
    Montenegro(
        iso = "ME",
        phoneCode = "+382",
        countryName = "Montenegro"
    ),
    Morocco(iso = "MA", phoneCode = "+212", countryName = "Morocco"),
    Mozambique(iso = "MZ", phoneCode = "+258", countryName = "Mozambique"),
    Myanmar(iso = "MM", phoneCode = "+95", countryName = "Myanmar"),
    Namibia(iso = "NA", phoneCode = "+264", countryName = "Namibia"),
    Nauru(iso = "NR", phoneCode = "+674", countryName = "Nauru"),
    Nepal(iso = "NP", phoneCode = "+977", countryName = "Nepal"),
    Netherlands(
        iso = "NL",
        phoneCode = "+31",
        countryName = "Netherlands"
    ),
    NewZealand(iso = "NZ", phoneCode = "+64", countryName = "New Zealand"),
    Nicaragua(iso = "NI", phoneCode = "+505", countryName = "Nicaragua"),
    Niger(iso = "NE", phoneCode = "+227", countryName = "Niger"),
    Nigeria(iso = "NG", phoneCode = "+234", countryName = "Nigeria"),
    NorthKorea(
        iso = "KP",
        phoneCode = "+850",
        countryName = "North Korea"
    ),
    Norway(iso = "NO", phoneCode = "+47", countryName = "Norway"),
    Oman(iso = "OM", phoneCode = "+968", countryName = "Oman"),
    Pakistan(iso = "PK", phoneCode = "+92", countryName = "Pakistan"),
    Palau(iso = "PW", phoneCode = "+680", countryName = "Palau"),
    Palestine(
        iso = "PS",
        phoneCode = "+970",
        countryName = "Palestine"
    ),
    Panama(iso = "PA", phoneCode = "+507", countryName = "Panama"),
    PapuaNewGuinea(
        iso = "PG",
        phoneCode = "+675",
        countryName = "Papua New Guinea"
    ),
    Paraguay(iso = "PY", phoneCode = "+595", countryName = "Paraguay"),
    Peru(iso = "PE", phoneCode = "+51", countryName = "Peru"),
    Philippines(
        iso = "PH",
        phoneCode = "+63",
        countryName = "Philippines"
    ),
    Poland(iso = "PL", phoneCode = "+48", countryName = "Poland"),
    Portugal(iso = "PT", phoneCode = "+351", countryName = "Portugal"),
    PuertoRico(iso = "PR", phoneCode = "+1", countryName = "Puerto Rico"),
    Qatar(iso = "QA", phoneCode = "+974", countryName = "Qatar"),
    Romania(iso = "RO", phoneCode = "+40", countryName = "Romania"),
    Russia(iso = "RU", phoneCode = "+7", countryName = "Russia"),
    Rwanda(iso = "RW", phoneCode = "+250", countryName = "Rwanda"),
    SaintLucia(
        iso = "LC",
        phoneCode = "+1758",
        countryName = "Saint Lucia"
    ),
    SaintVincentAndTheGrenadines(
        iso = "VC",
        phoneCode = "+1784",
        countryName = "Saint Vincent and the Grenadines"
    ),
    Samoa(iso = "WS", phoneCode = "+685", countryName = "Samoa"),
    SanMarino(iso = "SM", phoneCode = "+378", countryName = "San Marino"),
    SaoTomeAndPrincipe(
        iso = "ST",
        phoneCode = "+239",
        countryName = "Sao Tome and Principe"
    ),
    SaudiArabia(
        iso = "SA",
        phoneCode = "+966",
        countryName = "Saudi Arabia"
    ),
    SolomonIslands(
        iso = "SB",
        phoneCode = "+667",
        countryName = "Solomon Islands"
    ),
    Suriname(
        iso = "SUR",
        phoneCode = "+547",
        countryName = "Suriname"
    ),
    Swaziland(iso = "SZ", phoneCode = "+268", countryName = "Swaziland"),
    Sweden(iso = "SE", phoneCode = "+46", countryName = "Sweden"),
    Switzerland(
        iso = "CH",
        phoneCode = "+41",
        countryName = "Switzerland"
    ),
    Syria(iso = "SY", phoneCode = "+963", countryName = "Syria"),
    Taiwan(iso = "TW", phoneCode = "+886", countryName = "Taiwan"),
    Tajikistan(iso = "TJ", phoneCode = "+992", countryName = "Tajikistan"),
    Tanzania(iso = "TZ", phoneCode = "+255", countryName = "Tanzania"),
    Thailand(iso = "TH", phoneCode = "+66", countryName = "Thailand"),
    TimorLeste(
        iso = "TL",
        phoneCode = "+670",
        countryName = "Timor-Leste"
    ),
    Togo(iso = "TG", phoneCode = "+228", countryName = "Togo"),
    Tonga(iso = "TO", phoneCode = "+676", countryName = "Tonga"),
    TrinidadAndTobago(
        iso = "TT",
        phoneCode = "+1868",
        countryName = "Trinidad and Tobago"
    ),
    Tunisia(iso = "TN", phoneCode = "+216", countryName = "Tunisia"),
    Turkey(iso = "TR", phoneCode = "+90", countryName = "Turkey"),
    Turkmenistan(
        iso = "TM",
        phoneCode = "+993",
        countryName = "Turkmenistan"
    ),
    Tuvalu(iso = "TV", phoneCode = "+688", countryName = "Tuvalu"),
    Uganda(iso = "UG", phoneCode = "+256", countryName = "Uganda"),
    Ukraine(iso = "UA", phoneCode = "+380", countryName = "Ukraine"),
    UnitedArabEmirates(
        iso = "AE",
        phoneCode = "+971",
        countryName = "United Arab Emirates"
    ),
    UnitedKingdom(
        iso = "GB",
        phoneCode = "+44",
        countryName = "United Kingdom"
    ),
    UnitedStates(
        iso = "US",
        phoneCode = "+1",
        countryName = "United States"
    ),
    Uruguay(iso = "UY", phoneCode = "+598", countryName = "Uruguay"),
    Uzbekistan(iso = "UZ", phoneCode = "+998", countryName = "Uzbekistan"),
    Vanuatu(iso = "VU", phoneCode = "+678", countryName = "Vanuatu"),
    Venezuela(iso = "VE", phoneCode = "+58", countryName = "Venezuela"),
    Vietnam(iso = "VN", phoneCode = "+84", countryName = "Vietnam"),
    Yemen(iso = "YE", phoneCode = "+967", countryName = "Yemen"),
    Zambia(iso = "ZM", phoneCode = "+260", countryName = "Zambia"),
    Zimbabwe(iso = "ZW", phoneCode = "+263", countryName = "Zimbabwe");

    companion object {
        fun filter(
            searchQuery: String
        ): List<Country> {
            return Country.entries
                .filter { country ->
                    country.countryName.lowercase().contains(searchQuery.lowercase()) ||
                            country.iso.contains(searchQuery) ||
                            country.phoneCode.contains(searchQuery)
                }
        }
    }
}


@OptIn(ExperimentalResourceApi::class)
fun Country.getFlag(): DrawableResource {
    if (this == Country.CoteDIvoire) {
        return Res.drawable.ivory_coast
    }

    return Res.allDrawableResources.entries.first {
        val flagName: String = it.key.lowercase().replace("_", " ")
        val countryName: String = this.countryName.lowercase()
            .replace("-", " ")
            .replace("(", "")
            .replace(")", "")
        flagName.contains(countryName)
    }.value
}
