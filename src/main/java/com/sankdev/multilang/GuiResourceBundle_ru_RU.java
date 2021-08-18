package com.sankdev.multilang;

public class GuiResourceBundle_ru_RU extends GuiResourceBundle {

  @Override
  protected Object[][] getContents() {
    return new Object[][]{
        // LOCALIZE THIS
        {"appTitle", "Мое портфолио"},
        {"editWindowTitle", "Редактирование информации о работе"}, {"okKey", "Ок"},
        {"cancelKey", "Отмена"}, {"editButton", "Редактировать"}, {"deleteButton", "Удалить"},
        {"addButton", "Добавить"}, {"saveButton", "Сохранить"}, {"loadButton", "Загрузить"},
        {"editItemText", "Введите информацию об элементе портфолио:"},
        {"itemIdLabel", "Номер"},
        {"itemNameLabel", "Наименование"},
        {"itemYearLabel", "Год"},
        {"itemDescriptionLabel", "Описание"},
        {"itemCertifyingBodyLabel", "Организация"},
        {"itemEditionLabel", "Издание"},
        {"itemPrintCountLabel", "Тираж издания"},
        {"itemYearOfExpirationLabel", "Год окончания срока действия"},
        {"itemDegreeLevelLabel", "Уровень диплома об образовании"},
        {"itemTypeCBoxPrompt", "Выберите тип элемента портфолио"},
        {"itemTypeLabel", "Тип элемента"},
        {"CertificateType", "Сертификат"},
        {"DiplomaType", "Диплом об образовании"},
        {"PatentType", "Патент"},
        {"PublicationType", "Публикация"},
        {"HIGH", "Среднее"},
        {"HIGHER", "Высшее"},
        {"MASTERS", "Степень Магистра"},
        {"DOCTOR", "Докторская степень"},
        {"itemDegreeLevelCBoxPromptText", "Выберите уровень образования"}
        // END OF MATERIAL TO LOCALIZE
    };
  }
}
