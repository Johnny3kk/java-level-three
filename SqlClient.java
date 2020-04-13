package ru.gb.jt.chat.server.core;

import java.sql.*;

public class SqlClient {

    // Подключение к базе данных вызывает класс ChatServer

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            // Загружаем драйвер
            Class.forName("org.sqlite.JDBC");
            // Создаём соединение к базе данных по URL, которая состоит из протокола:подпротокола://[хоста]:[порта_СУБД]/[БД] и других_сведений
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat.db");
            // Создаём простой statement запрос
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static String getNickname(String login, String password) {
        // Записываем теекст запроса с принимаемыми login и password
        String query = String.format("select nickname from users where login='%s' and password='%s'", login, password);
        // Выполним запрос
        try (ResultSet set = statement.executeQuery(query)) {
            // С помощью метода next() проходим по элементам базы данных до соответствия запросу
            if (set.next())
                // Возвращаем нужную информацию по запросу
                return set.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Если запрашиваемых элементов в базе данных нет, то возвращаем null
        return null;
    }

}
