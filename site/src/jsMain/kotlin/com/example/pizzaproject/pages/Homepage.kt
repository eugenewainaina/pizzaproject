@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.pages

import androidx.compose.runtime.*
import com.example.pizzaproject.sections.aboutUsSection
import com.example.pizzaproject.sections.contactUsSection
import com.example.pizzaproject.sections.mainSection
import com.example.pizzaproject.sections.peoplePicsSection
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page
import kotlinx.browser.window

@Page
@Composable
fun homepage() {
    window.document.title = "Pizza Oven"
    Column(modifier = Modifier.fillMaxSize()) {
        mainSection()

        aboutUsSection()

        peoplePicsSection()

        contactUsSection()
    }
}
