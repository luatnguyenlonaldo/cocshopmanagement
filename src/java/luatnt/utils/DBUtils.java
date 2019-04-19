/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luatnt.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Lonaldo
 */
public class DBUtils {
    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        Context serverContext = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) serverContext.lookup("DBUtils");
        Connection con = ds.getConnection();
        return con;
    }
}
