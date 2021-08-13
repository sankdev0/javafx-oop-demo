package com.sankdev.multilang;

public class GuiResourceBundle_en_US extends GuiResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "My Portfolio"}, {"editWindowTitle", "Edit item"},
        {"okKey", "OK"}, {"cancelKey", "Cancel"}, {"editButton", "Edit"},
        {"deleteButton", "Delete"},
        {"addButton", "Create"}, {"saveButton", "Save"}, {"loadButton", "Load"},
        {"addItemText", "Add new Portfolio item details:"},
        {"editItemText", "Edit the Portfolio item details"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
