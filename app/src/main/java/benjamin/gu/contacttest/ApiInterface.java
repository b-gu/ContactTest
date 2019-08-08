package benjamin.gu.contacttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("contacts")
    Call<ResultPojo> getContacts();
}
