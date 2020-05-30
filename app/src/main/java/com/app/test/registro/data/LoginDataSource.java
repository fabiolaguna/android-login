package com.app.test.registro.data;

import android.database.Cursor;
import android.widget.Toast;

import com.app.test.registro.DatabaseHelper;
import com.app.test.registro.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password, DatabaseHelper db) {

        LoggedInUser user = null;
        Cursor cursor = db.getData(username, password);
        if (cursor.moveToFirst()) {
            if (username.equals(cursor.getString(1)) && password.equals(cursor.getString(2))) {
                user = new LoggedInUser(cursor.getString(1), cursor.getString(3), cursor.getString(4));
            } else {
                return new Result.Error(new IOException("Login failed"));
            }
        } else {
            return new Result.Error(new IOException("Login failed"));
        }

        return new Result.Success<>(user);
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
