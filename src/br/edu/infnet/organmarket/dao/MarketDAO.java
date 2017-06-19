package br.edu.infnet.organmarket.dao;

import br.edu.infnet.organmarket.entity.Organ;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarketDAO implements Closeable {

    private Connection connection;
    private static MarketDAO instance;

    private static final String DB_URL = "mysql://localhost:3306/organ_market";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

    public static MarketDAO getInstance() {
        if (instance == null) {
            instance = new MarketDAO();
        }
        return instance;
    }

    private MarketDAO() {
    	connect();
    }

    public void close() throws IOException {
        instance.disconnect();
    }

    private void connect() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:" + DB_URL, USER, PASSWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Organ getOneById(Long id) {
        Organ organ = new Organ();
        String sql = "SELECT * FROM Stock WHERE Id = '?'";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet set = statement.executeQuery(sql);
            set.next();

            organ.setId(set.getLong("Id"));
            organ.setOrgan(set.getString("Organ"));
            organ.setPrice(set.getBigDecimal("Price"));
            organ.setDonator(set.getString("Donator"));

            set.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return organ;
    }

    public List<Organ> getAll() {
        List<Organ> organs = new ArrayList<Organ>();

        String sql = "SELECT * FROM Stock";

        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while (set.next()) {
                Organ organ = new Organ();
                organ.setId(set.getLong("Id"));
                organ.setOrgan(set.getString("Organ"));
                organ.setPrice(set.getBigDecimal("Price"));
                organ.setDonator(set.getString("Donator"));
                organs.add(organ);
            }

            set.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return organs;
    }

    public void insert(Organ organ){
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO Stock (Organ, Price, Donator) values (?, ?, ?)");
            stmt.setString(1, organ.getOrgan());
            stmt.setBigDecimal(2, organ.getPrice());
            stmt.setString(3, organ.getDonator());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
