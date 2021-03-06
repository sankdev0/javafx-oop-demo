package com.sankdev.multilang;

import java.util.ListResourceBundle;

public class GuiResourceBundle extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "My Portfolio"}, {"editWindowTitle", "Edit item"},
        {"okKey", "OK"}, {"cancelKey", "Cancel"}, {"editButton", "Edit"},
        {"deleteButton", "Delete"},
        {"addButton", "Create"}, {"saveButton", "Save"}, {"loadButton", "Load"},
        {"editItemText", "Enter Portfolio item details:"},
        {"itemIdLabel", "Item Id"},
        {"itemNameLabel", "Item Name"},
        {"itemYearLabel", "Year"},
        {"itemDescriptionLabel", "Description"},
        {"itemCertifyingBodyLabel", "Item Certifying Body"},
        {"itemEditionLabel", "Item Edition"},
        {"itemPrintCountLabel", "Item Print Count"},
        {"itemYearOfExpirationLabel", "Item Year of Expiration"},
        {"itemDegreeLevelLabel", "Item Degree Level"},
        {"itemTypeLabel", "Item Type"},
        {"itemTypeCBoxPrompt", "Choose the portfolio item type"},
        {"CertificateType", "Certificate"},
        {"DiplomaType", "Diploma"},
        {"PatentType", "Patent"},
        {"PublicationType", "Publication"},
        {"HIGH", "High School"},
        {"HIGHER", "Higher education"},
        {"MASTERS", "Master's degree"},
        {"DOCTOR", "PhD"},
        {"itemDegreeLevelCBoxPromptText", "Choose Degree Level"}

        // END OF MATERIAL TO LOCALIZE
    };
  }
}
