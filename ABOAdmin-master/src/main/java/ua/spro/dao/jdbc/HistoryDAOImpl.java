package ua.spro.dao.jdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ua.spro.dao.HistoryDAO;
import ua.spro.entity.Client;
import ua.spro.entity.History;
import ua.spro.service.ClientService;
import ua.spro.util.ConnectionDBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

public class HistoryDAOImpl implements HistoryDAO, Observer {

    private static String url = ConnectionDBUtil.getInstance().getUrl();
    private static String login = ConnectionDBUtil.getInstance().getLogin();
    private static String password = ConnectionDBUtil.getInstance().getPassword();


    public HistoryDAOImpl() {

        ConnectionDBUtil.getInstance().addObserver(this);
    }

    @Override
    public Integer save(History history) {
        try (Connection c = DriverManager.getConnection(
                url, login, password)){

            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO abo.histories(date_h , note, user_id)" +
                            "VALUES (?, ?, ?)" , Statement.RETURN_GENERATED_KEYS
            );
            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            statement.setTimestamp(1,currentDate );
            statement.setString(2, history.getComment());
            statement.setInt(3, history.getUserId());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys() ;
            if (generatedKeys.next()) {
                history.setId((int) generatedKeys.getLong(1));
            }
            return history.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public History getById(Integer id) {
        return null;
    }

    @Override
    public boolean update(History history) {
        try (Connection c = DriverManager.getConnection(
                url, login, password)){

            PreparedStatement statement = c.prepareStatement(
                    "UPDATE abo.histories SET note = ?, user_id = ? WHERE history_id = ?;"
            );
            statement.setString(1, history.getComment());
            statement.setInt(2, history.getUserId());
            statement.setInt(3, history.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("update success");
        return true;
    }

    @Override
    public boolean delete(History history) {
        return false;
    }

    @Override
    public ObservableList<History> getAll() {
        ObservableList<History> list = FXCollections.observableArrayList();
        try(Connection c = DriverManager.getConnection(url, login, password)) {
            PreparedStatement statement = c.prepareStatement(
                    "SELECT * " +
                            "FROM abo.histories  "

            );


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                list.add(new History(
                        resultSet.getInt(1),
                        (resultSet.getTimestamp(2)).toLocalDateTime(),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for(History n: list){
//            System.out.println(n);
//        }
        return list;
    }

    public ObservableList<History> getByClient(Client client){
        ObservableList<History> list = FXCollections.observableArrayList();
        Integer id = client.getId();
        try(Connection c = DriverManager.getConnection(url, login, password)) {
            PreparedStatement statement = c.prepareStatement(
                    "select cl.client_id, h.date_h, h.note, h.user_id\n" +
                            "from clients cl\n" +
                            "join clients_history ch\n" +
                            "on cl.client_id = ch.client_id\n" +
                            "left join histories h\n" +
                            "on ch.history_id = h.history_id\n" +
                            "having cl.client_id = ?  "

            );
            statement.setInt(1, id);


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                list.add(new History(
                        resultSet.getInt(1),
                        (resultSet.getTimestamp(2)).toLocalDateTime(),
                        resultSet.getString(3),
                        resultSet.getInt(4)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(History n: list){
            System.out.println(n);
        }
        return list;
    }

    public boolean saveCommentByClient(Client client, String comment){

        /*
        *
        *
        *
        *
        *
        *
        *
        *
        * */
        ObservableList<History> list = FXCollections.observableArrayList();
        try (Connection c = DriverManager.getConnection(
                url, login, password)){

            PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO histories( date_h, note)" +
                            "VALUES (?, ?)"
            );

            Timestamp currentDate = new Timestamp(System.currentTimeMillis());
            statement.setTimestamp(1,currentDate );
            statement.setString(2, comment);
            statement.execute();
            statement.clearParameters();

            statement = c.prepareStatement(
                    "SELECT max(history_id) " +
                            "FROM abo.histories  "
                            );
            ResultSet resultSet = statement.executeQuery();
            Integer id = null;
//
            while (resultSet.next()) {
                       id = resultSet.getInt(1);
            }
            statement.clearParameters();


            statement = c.prepareStatement(
                    "INSERT INTO clients_history( client_id, history_id)" +
                            "VALUES (?, ?)"
            );

            statement.setInt(1,client.getId() );
            statement.setInt(2, id);
            statement.execute();

            /* */
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean saveLink(Client client, History history){
        try (Connection c = DriverManager.getConnection(
                url, login, password)){
                    PreparedStatement statement = c.prepareStatement(
                    "INSERT INTO clients_history( client_id, history_id)" +
                            "VALUES (?, ?)"
            );

            statement.setInt(1,client.getId() );
            statement.setInt(2, history.getId());
            statement.execute();

            /* */
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ConnectionDBUtil){
            url = ConnectionDBUtil.getInstance().getUrl();
            login = ConnectionDBUtil.getInstance().getLogin();
            password = ConnectionDBUtil.getInstance().getPassword();
        }
    }
}



