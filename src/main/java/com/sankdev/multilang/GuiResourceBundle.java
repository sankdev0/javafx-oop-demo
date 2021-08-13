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
        {"itemEditionBodyLabel", "Item Edition"},
        {"itemPrintCountLabel", "Item Print Count"},
        {"itemYearOfExpirationLabel", "Item Year of Expiration"},
        {"itemDegreeLevelLabel", "Item Degree Level"},
        {"itemTypeLabel", "Item Type"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
