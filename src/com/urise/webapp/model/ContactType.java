package com.urise.webapp.model;

public enum ContactType {

    PHONE("Тел."),
    MOBILE("Мобильный."),
    HOME_PHONE("Домашиний тел."),
    SKYPE("Skype."),
    MAIL("Почта."),
    LINKEDIN("Профиль LinkedIn."),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

}
