@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.example.pizzaproject.sections

import androidx.compose.runtime.*
import com.example.pizzaproject.models.Section
import com.example.pizzaproject.styles.buttonStyles
import com.stevdza.san.kotlinbs.components.BSButton
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

const val AGENT_URL = "https://console.dialogflow.com/api-client/demo/embedded/6d1eacba-db34-4f9c-a3e6-2f3bf4757d49"

@Composable
fun mainSection() {
    var agentButtonClicked by remember { mutableStateOf(false) }

    Box(
        modifier =
            Modifier
                .id(Section.Home.id)
                .fillMaxSize(),
        contentAlignment = Alignment.TopCenter,
    ) {
        mainBackground()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            header()

            Column(
                modifier = Modifier.fillMaxSize().weight(2f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                P(attrs = Modifier.height(40.px).toAttrs()) {}

                Row(
                    modifier =
                        Modifier.fillMaxWidth(
                            90.percent,
                        ),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    BSButton(
                        modifier =
                            buttonStyles.toModifier()
                                .thenIf(
                                    condition = rememberBreakpoint() < Breakpoint.MD,
                                    other = Modifier.size(height = 30.px, width = 100.px),
                                ),
                        text =
                            if (rememberBreakpoint() < Breakpoint.MD) {
                                "AI Agent"
                            } else {
                                "Chat with our AI Agent"
                            },
                        onClick = {
                            agentButtonClicked = agentButtonClicked.not()
                        },
                    )
                }

                if (agentButtonClicked) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(right = 20.px),
                        contentAlignment = Alignment.TopEnd,
                    ) {
                        agentIframe()
                    }
                }

                Spacer()
            }

            Column(
                modifier =
                    Modifier.fillMaxSize().weight(1f)
                        .cursor(Cursor.Pointer)
                        .onClick {
                            window.location.href = "#about"
                        },
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                // peoplePicsSection()
                if (rememberBreakpoint() > Breakpoint.SM) {
                    Column(
                        modifier =
                            Modifier
                                .backgroundColor(Color.black)
                                .color(Color.orange)
                                .borderRadius(10.px)
                                .top(10.px),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(value = "See what we have to offer")
                        Spacer()
                    }

                    Column(
                        modifier =
                            Modifier
                                .backgroundColor(Color.black)
                                .color(Color.orange)
                                .borderRadius(bottomLeft = 20.px, bottomRight = 20.px)
                                .top(10.px),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(value = "↓")
                    }
                }
            }
        }

        menuSection()
    }
}

@Composable
fun mainBackground() {
    Image(
        src = "PizzaOvenBG.png",
        description = "Main Background",
        modifier =
            Modifier.fillMaxSize()
                .objectFit(ObjectFit.Cover),
    )
}

@Composable
fun agentIframe() {
    Iframe(
        attrs = {
            attr("width", "350")
            attr("height", "430")
            attr("src", AGENT_URL)
            attr("allow", "microphone")
        },
    )
}
