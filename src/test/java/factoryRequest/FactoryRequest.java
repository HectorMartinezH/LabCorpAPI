package factoryRequest;

public class FactoryRequest {
    public static final String GET ="get";


    public static IRequest make (String typeRequest){
        IRequest request;

        switch (typeRequest){
            case GET:
                request = new RequestGET();
                break;
            default:
                request = null;
                break;

        }
        return request;
    }

}
