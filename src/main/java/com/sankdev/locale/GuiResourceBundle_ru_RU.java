package com.sankdev.locale;

public class GuiResourceBundle_ru_RU extends GuiResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "Портфолио студенческих работ"},
        {"editWindowTitle", "Редактирование информации о работе"}, {"okKey", "Ок"},
        {"cancelKey", "Отмена"}, {"editButton", "Редактировать"}, {"deleteButton", "Удалить"},
        {"addButton", "Добавить"}, {"saveButton", "Сохранить"}, {"loadButton", "Загрузить"},
        {"addItemText", "Введите информацию о новом элементе портфолио:"},
        {"editItemText", "Внесите необходимые исправления"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
