package com.sankdev.locale;

import java.util.ListResourceBundle;

public class GuiResourceBundle extends ListResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "Student works portfolio tracking"}, {"editWindowTitle", "Edit item"},
        {"okKey", "OK"}, {"cancelKey", "Cancel"}, {"editButton", "Edit"},
        {"deleteButton", "Delete"},
        {"addButton", "Create"}, {"saveButton", "Save"}, {"loadButton", "Load"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
