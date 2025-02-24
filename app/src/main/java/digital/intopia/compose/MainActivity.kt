/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import digital.intopia.compose.ui.accessibledescriptions.SupportingTextEndScreen
import digital.intopia.compose.ui.accessibledescriptions.SupportingTextStartScreen
import digital.intopia.compose.ui.accessiblenames.ContentDescriptionEndScreen
import digital.intopia.compose.ui.accessiblenames.ContentDescriptionStartScreen
import digital.intopia.compose.ui.accessiblenames.TextFieldLabelEndScreen
import digital.intopia.compose.ui.accessiblenames.TextFieldLabelStartScreen
import digital.intopia.compose.ui.accessibleusageinstructions.AccountTileEndScreen
import digital.intopia.compose.ui.accessibleusageinstructions.AccountTileStartScreen
import digital.intopia.compose.ui.accordions.AccordionEndScreen
import digital.intopia.compose.ui.accordions.AccordionStartScreen
import digital.intopia.compose.ui.autofill.AutofillEndScreen
import digital.intopia.compose.ui.autofill.AutofillStartScreen
import digital.intopia.compose.ui.formfieldinstructions.FormFieldInstructionsEndScreen
import digital.intopia.compose.ui.formfieldinstructions.FormFieldInstructionsStartScreen
import digital.intopia.compose.ui.gettingstarted.FakeCheckboxesEndScreen
import digital.intopia.compose.ui.gettingstarted.FakeCheckboxesStartScreen
import digital.intopia.compose.ui.groups.RadioGroupEndScreen
import digital.intopia.compose.ui.groups.RadioGroupStartScreen
import digital.intopia.compose.ui.home.AboutScreen
import digital.intopia.compose.ui.home.HomeScreen
import digital.intopia.compose.ui.images.ComplexImageEndScreen
import digital.intopia.compose.ui.images.ComplexImageStartScreen
import digital.intopia.compose.ui.images.DecorativeImageEndScreen
import digital.intopia.compose.ui.images.DecorativeImageStartScreen
import digital.intopia.compose.ui.images.FunctionalImageEndScreen
import digital.intopia.compose.ui.images.FunctionalImageStartScreen
import digital.intopia.compose.ui.images.InformativeImageEndScreen
import digital.intopia.compose.ui.images.InformativeImageStartScreen
import digital.intopia.compose.ui.keyboards.KeyboardsEndScreen
import digital.intopia.compose.ui.keyboards.KeyboardsStartScreen
import digital.intopia.compose.ui.layout.DynamicTypeEndScreen
import digital.intopia.compose.ui.layout.DynamicTypeStartScreen
import digital.intopia.compose.ui.layout.ResponsiveLayoutEndScreen
import digital.intopia.compose.ui.layout.ResponsiveLayoutStartScreen
import digital.intopia.compose.ui.layout.TruncationEndScreen
import digital.intopia.compose.ui.layout.TruncationStartScreen
import digital.intopia.compose.ui.liveregions.LiveRegionEndScreen
import digital.intopia.compose.ui.liveregions.LiveRegionStartScreen
import digital.intopia.compose.ui.rolesemantics.RoleSemanticsEndScreen
import digital.intopia.compose.ui.rolesemantics.RoleSemanticsStartScreen
import digital.intopia.compose.ui.tables.TablesEndScreen
import digital.intopia.compose.ui.tables.TablesStartScreen
import digital.intopia.compose.ui.theme.IntopiaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntopiaComposeTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IntopiaComposeNavHost(navController)
                }
            }
        }
    }
}

@Composable
private fun IntopiaComposeNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        val popBackStack: () -> Unit = { navController.popBackStack() }

        composable(route = IntopiaComposeRoute.Home.route) {
            HomeScreen { route: IntopiaComposeRoute ->
                navController.navigate(route.route)
            }
        }
        composable(route = IntopiaComposeRoute.GettingStartedStart.route) {
            FakeCheckboxesStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.GettingStartedEnd.route) {
            FakeCheckboxesEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ContentDescriptionStart.route) {
            ContentDescriptionStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ContentDescriptionEnd.route) {
            ContentDescriptionEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TextFieldLabelStart.route) {
            TextFieldLabelStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TextFieldLabelEnd.route) {
            TextFieldLabelEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.SupportingTextStart.route) {
            SupportingTextStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.SupportingTextEnd.route) {
            SupportingTextEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AccountTileStart.route) {
            AccountTileStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AccountTileEnd.route) {
            AccountTileEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.RoleSemanticsStart.route) {
            RoleSemanticsStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.RoleSemanticsEnd.route) {
            RoleSemanticsEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.DecorativeImageStart.route) {
            DecorativeImageStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.DecorativeImageEnd.route) {
            DecorativeImageEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.InformativeImageStart.route) {
            InformativeImageStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.InformativeImageEnd.route) {
            InformativeImageEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.FunctionalImageStart.route) {
            FunctionalImageStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.FunctionalImageEnd.route) {
            FunctionalImageEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ComplexImageStart.route) {
            ComplexImageStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ComplexImageEnd.route) {
            ComplexImageEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TablesStart.route) {
            TablesStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TablesEnd.route) {
            TablesEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.GroupsStart.route) {
            RadioGroupStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.GroupsEnd.route) {
            RadioGroupEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.FormFieldInstructionsStart.route) {
            FormFieldInstructionsStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.FormFieldInstructionsEnd.route) {
            FormFieldInstructionsEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.KeyboardsStart.route) {
            KeyboardsStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.KeyboardsEnd.route) {
            KeyboardsEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AutofillStart.route) {
            AutofillStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AutofillEnd.route) {
            AutofillEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.LiveRegionStart.route) {
            LiveRegionStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.LiveRegionEnd.route) {
            LiveRegionEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AccordionStart.route) {
            AccordionStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.AccordionEnd.route) {
            AccordionEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.LiveRegionEnd.route) {
            LiveRegionEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.DynamicTypeStart.route) {
            DynamicTypeStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.DynamicTypeEnd.route) {
            DynamicTypeEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TruncationStart.route) {
            TruncationStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.TruncationEnd.route) {
            TruncationEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ResponsiveLayoutStart.route) {
            ResponsiveLayoutStartScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.ResponsiveLayoutEnd.route) {
            ResponsiveLayoutEndScreen(onBackPressed = popBackStack)
        }
        composable(route = IntopiaComposeRoute.About.route) {
            AboutScreen(onBackPressed = popBackStack)
        }
    }
}