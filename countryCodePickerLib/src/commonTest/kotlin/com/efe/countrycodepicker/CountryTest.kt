package com.efe.countrycodepicker
import org.jetbrains.compose.resources.DrawableResource
import kotlin.test.Test
import kotlin.test.assertEquals


class CountryTest {
    @Test
    fun `all countries should return non-null flag resource`(){
        val countryFlags: List<DrawableResource> = Country.entries.map { it.getFlag() }
        assertEquals(countryFlags.size, Country.entries.size)
    }
}