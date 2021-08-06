package com.sankdev.portfolio;

public class GuiResourceBundle_ru_RU extends GuiResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "Портфолио студенческих работ"},
        {"editWindowTitle", "Редактирование информации о работе"}, {"okKey", "Принять"},
        {"cancelKey", "Отмена"}, {"editButton", "Редактировать"}, {"deleteButton", "Удалить"},
        {"addButton", "Создать"}, {"saveButton", "Сохранить"}, {"loadButton", "Загрузить"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
