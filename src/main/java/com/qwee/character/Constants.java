package com.qwee.character;

public interface Constants {

    interface Controllers {
        interface CharacterCRUDController {
            String TAG_DESCRIPTION = "Управление игровым персонажем";
            String TAG = "[CHARACTER CRUD CONTROLLER]";

            String GET_ALL_SUMMARY = "Получение всех игровых персонажей";
            String GET_ALL_RESPONSE_DESCR = "Представлены все игровые персонажи из базы данных";


            String GET_BY_ID_SUMMARY = "Поиск игрового персонажа по ID";
            String GET_BY_ID_RESPONSE_DESCR = "Персонаж под запрашиваемым ID найден, данные отправлены";

            String GET_BY_NAME_SUMMARY = "Поиск игрового персонажа по имени";
            String GET_BY_NAME_RESPONSE_DESCR = "Персонаж под запрашиваемым именем найден, данные отправлены";

            String CREATE_SUMMARY = "Создание игрового персонажа";
            String CREATE_DESCRIPTION_SUMMARY = "Пользователь передает в тело запроса только имя и тип персонажа; на основании переданного типа, строятся основные стартовые атрибуты персонажа";
            String CREATE_RESPONSE_DESCR = "Персонаж создан, присвоен ID и дата создания";

            String DELETE_BY_ID_SUMMARY = "Удаление персонажа по ID";
            String DELETE_BY_ID_RESPONSE_DESCR = "Персонаж удален из базы; передано подтверждающее сообщение";

            String DELETE_ALL_SUMMARY = "Удаление всех персонажей из базы данных";
            String DELETE_ALL_RESPONSE_DESCR = "Персонажи удалены, передано подтверждающее сообщение";

            String CHANGE_NAME_SUMMARY = "Изменение имени персонажа";
            String CHANGE_NAME_SUMMARY_DESCR = "Поиск игрового персонажа в базе по ID, передача нового имени в теле запроса без ковычек";
            String CHANGE_NAME_RESPONSE_DESCR = "Имя персонажа изменено, передано подтверждающее сообщение";
        }

        interface GuildController {
            String TAG = "[GUILD CONTROLLER]";
            String TAG_DESCRIPTION = "Управление гильдиями";

            String GET_ALL_SUMMARY = "Получение всех гильдий";
            String GET_ALL_RESPONSE_DESCR = "Запрос выполнен, данные отправлены";

            String GET_BY_NAME_SUMMARY = "Получение гильдии по имени";
            String GET_BY_NAME_SUMMARY_DESCR = "Имя гильдии == тип персонажа (ENUM)";
            String GET_BY_NAME_RESPONSE_DESCR = "Гильдия найдена, данные отправлены";

            String GET_BY_ID_SUMMARY = "Получение гильдии по ID";
            String GET_BY_ID_RESPONSE_DESCR = "Гильдия найдена, данные отправлены";

            String INIT_SUMMARY = "Инициализация основных игровых гильдий";
            String INIT_SUMMARY_DESCR = "Логика приложения не предусматривает создание гильдий. Гильдии должны уже быть созданы; аварийный end-point для создания основных гильдий [WIZZARD, KNIGHT, THIEF]";
            String INIT_SUMMARY_RESPONSE_DESCR = "Гильдии созданы, сохранены в базе данных; в ответ получен список гильдий";

            String CHANGE_MESSAGE_SUMMARY = "Изменение сообщения дня в гильдии, поиск по ID";
            String CHANGE_MESSAGE_DESCR = "Изменяемое поле; сообщение для всех участников гильдии; новое сообщение передавать в тело запроса без ковычек";
            String CHANGE_MESSAGE_RESPONSE_DESCR = "Сообщение изменено и сохранено в базе данных; в ответ получено сообщение с подтверждением";
        }

        interface GameController {
            String TAG = "[GAME CONTROLLER]";
            String TAG_DESCRIPTION = "Выполнение игровых логик";

            String ADD_TO_GUILD_SUMMARY = "Добавление персонажа в его гильдию, поиск по ID персонажа";
            String ADD_TO_GUILD_SUMMARY_DESCR = "Персонаж добавляется в гильдию в соответствии с его типом [WIZZARD, KNIGHT, THIEF]";
            String ADD_TO_GUILD_RESPONSE_DESCR = "Персонаж добавлен в гильдию, изменен статус hasGuild = true, получено подверждающее сообщение";

            String CHARACTER_LVL_UP_SUMMARY = "Повышение уровня персонажа, поиск по ID";
            String CHARACTER_LVL_UP_SUMMARY_DESCR = "Инкрементриуется уровень персонажа, его атрибуты удваиются";
            String CHARACTER_LVL_UP_RESPONSE_DESCR = "Уровень увелен, атрибуты удвоены; получено сообщение с подтверждением";

            String ALL_IN_GUILD_LVL_UP_SUMMARY = "Повышение уровня персонажей в гильдии";
            String ALL_IN_GUILD_LVL_UP_DESCR = "Те персонажи, которые состоят в выбранной гильдии получают повышение уровня, удвоение атрибутов";
            String ALL_IN_GUILD_LVL_UP_RESPONSE_DESCR = "Уровни персонажей увеличены, атрибуты удвоены, получено сообщение с подтверждением";
        }

        interface LadderController {
            String TAG = "[LADDER CONTROLLER]";
            String TAG_DESCRIPTION = "Контроллер получения игровой статистики";

            String TOP_LEVEL_SUMMARY = "Получение лучшего игрока по уровню";
            String TOP_LEVEL_SUMMARY_DESCR = "Наивысший уровень среди всех игроков";
            String TOP_LEVEL_SUMMARY_RESPONSE_DESCR = "Отравлены данные игрока с наивысшим уровнем";
        }
    }

    interface Informer {
        String STATUS_200 = "200";
    }
}
