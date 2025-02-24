/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.paneTitle
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import digital.intopia.compose.IntopiaComposeRoute
import digital.intopia.compose.R
import digital.intopia.compose.ui.helpers.Accordion
import digital.intopia.compose.ui.helpers.BodyTextNoPadding
import digital.intopia.compose.ui.helpers.NavigationListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigationButtonClicked: (IntopiaComposeRoute) -> Unit
) {
    val title = stringResource(id = R.string.app_name)
    Scaffold (
        modifier = modifier.semantics { paneTitle = title },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = title,
                        modifier = Modifier. semantics { heading() },
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1)
                }
            )
        }
    ) { contentPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollState)
        ) {
            BodyTextNoPadding(textId = R.string.app_description)
            Spacer(modifier = Modifier.height(8.dp))
            Accordion(title = stringResource(R.string.title_getting_started)) {
                NavigationListItem(
                    headline = R.string.title_getting_started_start,
                    route = IntopiaComposeRoute.GettingStartedStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_getting_started_end,
                    route = IntopiaComposeRoute.GettingStartedEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_accessible_names)) {
                NavigationListItem(
                    headline = R.string.title_content_description_start,
                    route = IntopiaComposeRoute.ContentDescriptionStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_content_description_end,
                    route = IntopiaComposeRoute.ContentDescriptionEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_text_field_label_start,
                    route = IntopiaComposeRoute.TextFieldLabelStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_text_field_label_end,
                    route = IntopiaComposeRoute.TextFieldLabelEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_accessible_descriptions)) {
                NavigationListItem(
                    headline = R.string.title_supporting_text_start,
                    route = IntopiaComposeRoute.SupportingTextStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_supporting_text_end,
                    route = IntopiaComposeRoute.SupportingTextEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_accessible_usage_instructions)) {
                NavigationListItem(
                    headline = R.string.title_account_tile_start,
                    route = IntopiaComposeRoute.AccountTileStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_account_tile_end,
                    route = IntopiaComposeRoute.AccountTileEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_role_semantics)) {
                NavigationListItem(
                    headline = R.string.title_role_semantics_start,
                    route = IntopiaComposeRoute.RoleSemanticsStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_role_semantics_end,
                    route = IntopiaComposeRoute.RoleSemanticsEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_images)) {
                NavigationListItem(
                    headline = R.string.title_decorative_image_start,
                    route = IntopiaComposeRoute.DecorativeImageStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_decorative_image_end,
                    route = IntopiaComposeRoute.DecorativeImageEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_informative_image_start,
                    route = IntopiaComposeRoute.InformativeImageStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_informative_image_end,
                    route = IntopiaComposeRoute.InformativeImageEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_functional_image_start,
                    route = IntopiaComposeRoute.FunctionalImageStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_functional_image_end,
                    route = IntopiaComposeRoute.FunctionalImageEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_complex_image_start,
                    route = IntopiaComposeRoute.ComplexImageStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_complex_image_end,
                    route = IntopiaComposeRoute.ComplexImageEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_tables)) {
                NavigationListItem(
                    headline = R.string.title_tables_start,
                    route = IntopiaComposeRoute.TablesStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_tables_end,
                    route = IntopiaComposeRoute.TablesEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_groups)) {
                NavigationListItem(
                    headline = R.string.title_groups_start,
                    route = IntopiaComposeRoute.GroupsStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_groups_end,
                    route = IntopiaComposeRoute.GroupsEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_instructions)) {
                NavigationListItem(
                    headline = R.string.title_form_field_instructions_start,
                    route = IntopiaComposeRoute.FormFieldInstructionsStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_form_field_instructions_end,
                    route = IntopiaComposeRoute.FormFieldInstructionsEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_keyboards)) {
                NavigationListItem(
                    headline = R.string.title_keyboards_start,
                    route = IntopiaComposeRoute.KeyboardsStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_keyboards_end,
                    route = IntopiaComposeRoute.KeyboardsEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_text_field_autofill)) {
                NavigationListItem(
                    headline = R.string.title_autofill_start,
                    route = IntopiaComposeRoute.AutofillStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_autofill_end,
                    route = IntopiaComposeRoute.AutofillEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_live_regions)) {
                NavigationListItem(
                    headline = R.string.title_live_region_start,
                    route = IntopiaComposeRoute.LiveRegionStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_live_region_end,
                    route = IntopiaComposeRoute.LiveRegionEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_accordions)) {
                NavigationListItem(
                    headline = R.string.title_accordion_start,
                    route = IntopiaComposeRoute.AccordionStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_accordion_end,
                    route = IntopiaComposeRoute.AccordionEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Accordion(title = stringResource(R.string.title_layout)) {
                NavigationListItem(
                    headline = R.string.title_dynamic_type_start,
                    route = IntopiaComposeRoute.DynamicTypeStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_dynamic_type_end,
                    route = IntopiaComposeRoute.DynamicTypeEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_truncation_start,
                    route = IntopiaComposeRoute.TruncationStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_truncation_end,
                    route = IntopiaComposeRoute.TruncationEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_responsive_layout_start,
                    route = IntopiaComposeRoute.ResponsiveLayoutStart,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
                NavigationListItem(
                    headline = R.string.title_responsive_layout_end,
                    route = IntopiaComposeRoute.ResponsiveLayoutEnd,
                    onNavigationButtonClicked = onNavigationButtonClicked
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            NavigationListItem(
                headline = R.string.title_about_app,
                route = IntopiaComposeRoute.About,
                onNavigationButtonClicked = onNavigationButtonClicked,
                showDivider = false,
                colors = ListItemDefaults.colors(containerColor = Color.LightGray)
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen {  }
}