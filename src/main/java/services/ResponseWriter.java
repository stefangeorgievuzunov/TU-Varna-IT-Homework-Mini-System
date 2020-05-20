package services;

import services.models.UserModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.function.Function;

public interface ResponseWriter {
  void write(HttpServletRequest req, HttpServletResponse resp, Function<UserModel, UserModel> objectToBePrinted) throws IOException;
}
