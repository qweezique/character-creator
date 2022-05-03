package com.qwee.character;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static class Controllers {
        public static class CharacterCRUDController {
            public static final String TAG_DESCRIPTION = "Управление игровым персонажем";
            public static final String TAG = "[CHARACTER CRUD CONTROLLER]";

            public static final String GET_ALL_SUMMARY = "Получение всех игровых персонажей";
            public static final String GET_ALL_RESPONSE_DESCR = "Представлены все игровые персонажи из базы данных";


            public static final String GET_BY_ID_SUMMARY = "Поиск игрового персонажа по ID";
            public static final String GET_BY_ID_RESPONSE_DESCR = "Персонаж под запрашиваемым ID найден, данные отправлены";

            public static final String GET_BY_NAME_SUMMARY = "Поиск игрового персонажа по имени";
            public static final String GET_BY_NAME_RESPONSE_DESCR = "Персонаж под запрашиваемым именем найден, данные отправлены";

            public static final String CREATE_SUMMARY = "Создание игрового персонажа";
            public static final String CREATE_DESCRIPTION_SUMMARY = "Пользователь передает в тело запроса только имя и тип персонажа; на основании переданного типа, строятся основные стартовые атрибуты персонажа";
            public static final String CREATE_RESPONSE_DESCR = "Персонаж создан, присвоен ID и дата создания";

            public static final String DELETE_BY_ID_SUMMARY = "Удаление персонажа по ID";
            public static final String DELETE_BY_ID_RESPONSE_DESCR = "Персонаж удален из базы; передано подтверждающее сообщение";

            public static final String DELETE_ALL_SUMMARY = "Удаление всех персонажей из базы данных";
            public static final String DELETE_ALL_RESPONSE_DESCR = "Персонажи удалены, передано подтверждающее сообщение";

            public static final String CHANGE_NAME_SUMMARY = "Изменение имени персонажа";
            public static final String CHANGE_NAME_SUMMARY_DESCR = "Поиск игрового персонажа в базе по ID, передача нового имени в теле запроса без ковычек";
            public static final String CHANGE_NAME_RESPONSE_DESCR = "Имя персонажа изменено, передано подтверждающее сообщение";
        }

        public static class GuildController {
            public static final String TAG = "[GUILD CONTROLLER]";
            public static final String TAG_DESCRIPTION = "Управление гильдиями";

            public static final String GET_ALL_SUMMARY = "Получение всех гильдий";
            public static final String GET_ALL_RESPONSE_DESCR = "Запрос выполнен, данные отправлены";

            public static final String GET_BY_NAME_SUMMARY = "Получение гильдии по имени";
            public static final String GET_BY_NAME_SUMMARY_DESCR = "Имя гильдии == тип персонажа (ENUM)";
            public static final String GET_BY_NAME_RESPONSE_DESCR = "Гильдия найдена, данные отправлены";

            public static final String GET_BY_ID_SUMMARY = "Получение гильдии по ID";
            public static final String GET_BY_ID_RESPONSE_DESCR = "Гильдия найдена, данные отправлены";

            public static final String INIT_SUMMARY = "Инициализация основных игровых гильдий";
            public static final String INIT_SUMMARY_DESCR = "Логика приложения не предусматривает создание гильдий. Гильдии должны уже быть созданы; аварийный end-point для создания основных гильдий [WIZZARD, KNIGHT, THIEF]";
            public static final String INIT_SUMMARY_RESPONSE_DESCR = "Гильдии созданы, сохранены в базе данных; в ответ получен список гильдий";

            public static final String CHANGE_MESSAGE_SUMMARY = "Изменение сообщения дня в гильдии, поиск по ID";
            public static final String CHANGE_MESSAGE_DESCR = "Изменяемое поле; сообщение для всех участников гильдии; новое сообщение передавать в тело запроса без ковычек";
            public static final String CHANGE_MESSAGE_RESPONSE_DESCR = "Сообщение изменено и сохранено в базе данных; в ответ получено сообщение с подтверждением";
        }

        public static class GameController {
            public static final String TAG = "[GAME CONTROLLER]";
            public static final String TAG_DESCRIPTION = "Выполнение игровых логик";

            public static final String ADD_TO_GUILD_SUMMARY = "Добавление персонажа в его гильдию, поиск по ID персонажа";
            public static final String ADD_TO_GUILD_SUMMARY_DESCR = "Персонаж добавляется в гильдию в соответствии с его типом [WIZZARD, KNIGHT, THIEF]";
            public static final String ADD_TO_GUILD_RESPONSE_DESCR = "Персонаж добавлен в гильдию, изменен статус hasGuild = true, получено подверждающее сообщение";

            public static final String CHARACTER_LVL_UP_SUMMARY = "Повышение уровня персонажа, поиск по ID";
            public static final String CHARACTER_LVL_UP_SUMMARY_DESCR = "Инкрементриуется уровень персонажа, его атрибуты удваиются";
            public static final String CHARACTER_LVL_UP_RESPONSE_DESCR = "Уровень увелен, атрибуты удвоены; получено сообщение с подтверждением";

            public static final String ALL_IN_GUILD_LVL_UP_SUMMARY = "Повышение уровня персонажей в гильдии";
            public static final String ALL_IN_GUILD_LVL_UP_DESCR = "Те персонажи, которые состоят в выбранной гильдии получают повышение уровня, удвоение атрибутов";
            public static final String ALL_IN_GUILD_LVL_UP_RESPONSE_DESCR = "Уровни персонажей увеличены, атрибуты удвоены, получено сообщение с подтверждением";
        }

        public static class LadderController {
            public static final String TAG = "[LADDER CONTROLLER]";
            public static final String TAG_DESCRIPTION = "Контроллер получения игровой статистики";

            public static final String TOP_LEVEL_SUMMARY = "Получение лучшего игрока по уровню";
            public static final String TOP_LEVEL_SUMMARY_DESCR = "Наивысший уровень среди всех игроков";
            public static final String TOP_LEVEL_SUMMARY_RESPONSE_DESCR = "Отравлены данные игрока с наивысшим уровнем";
        }
    }

    public static class Informer{
        public static final String STATUS_200 = "200";
    }
}
