package RestApi;

public class BaseManager {
    public RestApi getrestapi(){
        RestApiClient restApiClient=new RestApiClient(BaseUrl.baseurl);
        return  restApiClient.getRestApi();
    }
}
