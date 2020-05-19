package core;

import com.google.gson.Gson;

import javax.enterprise.inject.Produces;

public class GsonFactory {
    @Produces
    Gson gson(){
        return new Gson();
    }
}
