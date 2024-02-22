@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.sections

import androidx.compose.runtime.*
import com.example.pizzaproject.models.Section
import com.example.pizzaproject.styles.NavigationItemStyle
import com.example.pizzaproject.styles.buttonStyles
import com.stevdza.san.kotlinbs.components.BSButton
import com.stevdza.san.kotlinbs.components.BSOffcanvas
import com.stevdza.san.kotlinbs.components.showModalOnClick
import com.stevdza.san.kotlinbs.components.showOffcanvasOnClick
import com.stevdza.san.kotlinbs.models.offcanvas.OffcanvasPlacement
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*

// navigation bar
@Composable
fun header() {
    val breakpoint = rememberBreakpoint()

    Row(
        modifier =
            Modifier.margin(top = 20.px)
                .fillMaxWidth(90.percent)
                .backgroundColor(Color.black)
                .top(10.px)
                .position(Position.Sticky)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Color.orange,
                )
                .borderRadius(20.px),
        // .boxShadow(blurRadius = 10.px, spreadRadius = 0.2.px, color = Color.orange),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leftSide()
        rightSide(breakpoint = breakpoint)
    }

    BSOffcanvas(
        id = "OptionsOffCanvas",
        modifier =
            Modifier.fontFamily("verdana")
                .fillMaxWidth(50.percent),
        title = "Navigate",
        placement = OffcanvasPlacement.END,
        dark = true,
        allowScrolling = true,
        closableOutside = true,
        body = {
            Column {
                Section.entries.forEach {
                    Link(
                        modifier =
                            NavigationItemStyle.toModifier()
                                .padding(right = 30.px)
                                .fontSize(18.px)
                                .fontWeight(FontWeight.Normal)
                                .textDecorationLine(TextDecorationLine.None)
                                .thenIf(condition = it == Section.Menu, other = Modifier.showModalOnClick("menu_modal")),
                        path = it.path,
                        text = it.title,
                    )
                }
            }
        },
    )
}

// for the logo
@Composable
private fun leftSide() { // TODO implement hamburger menu for when breakpoint < Breakpoint.MD for each Section entries
    Row(
        modifier =
            Modifier.fillMaxWidth()
                .borderRadius(r = 50.px)
                .padding(left = 30.px),
    ) {
        Image(
            modifier =
                Modifier.onClick {
                    window.location.href = "#home"
                }
                    .cursor(Cursor.Pointer),
            src = "PizzaOvenInPizzaWeTrust.svg",
            description = "Logo Image",
            // modifier = NavigationItemStyle.toModifier()
        )
    }
}

// the nav bar
@Composable
private fun rightSide(breakpoint: Breakpoint) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
    ) {
        if (rememberBreakpoint() > Breakpoint.SM) {
            Section.entries.forEach {
                Link(
                    modifier =
                        NavigationItemStyle.toModifier()
                            .padding(right = 30.px)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Normal)
                            .textDecorationLine(TextDecorationLine.None)
                            .thenIf(condition = it == Section.Menu, other = Modifier.showModalOnClick("menu_modal")),
                    path = it.path,
                    text = it.title,
                )
                // }
            }
        } else {
            BSButton(
                modifier =
                    buttonStyles.toModifier()
                        .height(25.px)
                        .showOffcanvasOnClick(id = "OptionsOffCanvas"),
                text = "Options",
                onClick = {},
            )
        }
    }
}
