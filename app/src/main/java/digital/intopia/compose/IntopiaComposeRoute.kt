/*
 Copyright (c) 2024 Intopia Pty Ltd

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package digital.intopia.compose

enum class IntopiaComposeRoute(val route: String) {
    Home("home"),
    GettingStartedStart("gettingStartedStart"),
    GettingStartedEnd("gettingStartedEnd"),
    ContentDescriptionStart("contentDescriptionStart"),
    ContentDescriptionEnd("contentDescriptionEnd"),
    TextFieldLabelStart("textFieldLabelStart"),
    TextFieldLabelEnd("textFieldLabelEnd"),
    SupportingTextStart("supportingTextStart"),
    SupportingTextEnd("supportingTextEnd"),
    AccountTileStart("accountTileStart"),
    AccountTileEnd("accountTileEnd"),
    RoleSemanticsStart("roleSemanticsStart"),
    RoleSemanticsEnd("roleSemanticsEnd"),
    DecorativeImageStart("decorativeImageStart"),
    DecorativeImageEnd("decorativeImageEnd"),
    InformativeImageStart("informativeImageStart"),
    InformativeImageEnd("informativeImageEnd"),
    FunctionalImageStart("functionalImageStart"),
    FunctionalImageEnd("functionalImageEnd"),
    ComplexImageStart("complexImageStart"),
    ComplexImageEnd("complexImageEnd"),
    TablesStart("tablesStart"),
    TablesEnd("tablesEnd"),
    GroupsStart("groupsStart"),
    GroupsEnd("groupsEnd"),
    FormFieldInstructionsStart("formFieldInstructionsStart"),
    FormFieldInstructionsEnd("formFieldInstructionsEnd"),
    KeyboardsStart("keyboardsStart"),
    KeyboardsEnd("keyboardsEnd"),
    AutofillStart("autofillStart"),
    AutofillEnd("autofillEnd"),
    LiveRegionStart("liveRegionStart"),
    LiveRegionEnd("liveRegionEnd"),
    AccordionStart("accordionStart"),
    AccordionEnd("accordionEnd"),
    DynamicTypeStart("dynamicTypeStart"),
    DynamicTypeEnd("dynamicTypeEnd"),
    TruncationStart("truncationStart"),
    TruncationEnd("truncationEnd"),
    ResponsiveLayoutStart("responsiveLayoutStart"),
    ResponsiveLayoutEnd("responsiveLayoutEnd"),
    About("about")
}