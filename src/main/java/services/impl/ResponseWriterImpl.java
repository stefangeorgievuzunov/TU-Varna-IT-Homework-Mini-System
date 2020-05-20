package services.impl;

import com.google.gson.Gson;
import services.ResponseWriter;
import services.models.UserModel;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Function;

public class ResponseWriterImpl implements ResponseWriter {
    @Inject
    private Gson gson;
    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

    @Override
    public void write(HttpServletRequest req, HttpServletResponse resp, Function<UserModel, UserModel> objectToBePrinted) throws IOException {
        StringBuilder sb = new StringBuilder();
        String s;

        while ((s = req.getReader().readLine()) != null) {
            sb.append(s);
        }

        UserModel user = gson.fromJson(sb.toString(), UserModel.class);
        UserModel result = objectToBePrinted.apply(user);

        resp.setContentType(CONTENT_TYPE);
        PrintWriter out = resp.getWriter();
        out.println(gson.toJson(result));
        out.flush();
    }
}
