package factoryRequest;

public class RequestInformation {
    private String url;

    public RequestInformation(String url){
        this.url= url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}