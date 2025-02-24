/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.helpers

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import digital.intopia.compose.IntopiaComposeRoute
import digital.intopia.compose.R

@Composable
fun BodyTextNoPadding(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text,
        modifier = modifier
            .fillMaxWidth(),
        textAlign = textAlign,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun BodyTextNoPadding(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    BodyTextNoPadding(
        stringResource(id = textId),
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun BodyText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    BodyTextNoPadding(
        text,
        modifier.padding(top = 8.dp),
        textAlign
    )
}

@Composable
fun BodyText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    BodyTextNoPadding(
        stringResource(id = textId),
        modifier.padding(top = 8.dp),
        textAlign
    )
}

@Composable
fun BoldBodyTextNoPadding(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        stringResource(id = textId),
        modifier = modifier
            .fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        style = MaterialTheme.typography.bodyMedium
    )
}

@Composable
fun BoldBodyText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    BoldBodyTextNoPadding(
        textId,
        modifier.padding(top = 8.dp),
        textAlign
    )
}

@Composable
fun NavigationListItem(
    @StringRes headline: Int,
    modifier: Modifier = Modifier,
    route: IntopiaComposeRoute,
    onNavigationButtonClicked: (IntopiaComposeRoute) -> Unit,
    showDivider: Boolean? = true,
    colors: ListItemColors = ListItemDefaults.colors()
) {
    val iconScalingMultiplier = LocalDensity.current.fontScale
    if (showDivider == true) {
        HorizontalDivider()
    }
    ListItem(
        modifier = modifier
            .fillMaxWidth()
            .semantics { role = Role.Button }
            .clickable(onClickLabel = stringResource(R.string.navigation_action)) {
                onNavigationButtonClicked(route)
            },
        headlineContent = {
            Text(stringResource(id = headline))
        },
        trailingContent = {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                modifier = modifier.scale(iconScalingMultiplier),
                contentDescription = null
            )
        },
        colors = colors
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenericScaffold(
    title: String,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (modifier: Modifier) -> Unit
) {
    Scaffold(
        modifier = modifier.semantics { paneTitle = title },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        title,
                        modifier = Modifier.semantics { heading() },
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.navigate_up)
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        content(Modifier.padding(contentPadding))
    }
}