package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
    public static List<String> getDataByType(String type) {
        List<String> dataList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT value FROM data_store WHERE type = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, type);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                dataList.add(rs.getString("value"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
