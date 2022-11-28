package com.example.pttk_dbclpm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.example.pttk_dbclpm.constant.Constant.DAOConstant.*;
import static com.example.pttk_dbclpm.constant.Constant.DAOConstant.PASSWORD;

public class DAO {
  protected static DAO instance;
  protected Connection connection;

  public DAO(){
    try {
      Class.forName(DRIVER);
      this.connection = DriverManager.getConnection(URI, USER, PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
