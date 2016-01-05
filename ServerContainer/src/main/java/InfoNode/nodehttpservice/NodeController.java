package InfoNode.nodehttpservice;

import InfoNode.nodehttpservice.handler.HttpEmployeeHandler;
import InfoNode.nodehttpservice.handler.HttpEmployeesHandler;
import InfoNode.nodehttpservice.handler.HttpUpdatedEmployeesHandler;
import org.apache.http.protocol.*;

import java.io.IOException;

public class NodeController {

    private int workingPort;

    public NodeController(int workingPort) {
        this.workingPort = workingPort;
    }

    public void start() throws IOException {

        // Configurarea procesorului a protocolului HTTP
        HttpProcessor httpProcessor = HttpProcessorBuilder.create()
                .add(new ResponseDate())
                .add(new ResponseServer("DIS - InfoNode/1.1"))
                .add(new ResponseContent())
                .add(new ResponseConnControl()).build();

        //Configurarea operatorilor de cereri
        UriHttpRequestHandlerMapper reqistry = new UriHttpRequestHandlerMapper();
        reqistry.register("/employees/", new HttpEmployeesHandler());
        reqistry.register("/employee/*", new HttpEmployeeHandler());
        reqistry.register("/update/employees/", new HttpUpdatedEmployeesHandler());

        // Configuratia serviciului HTTP
        HttpService httpService = new HttpService(httpProcessor, reqistry);

        // Start HTTP listener
        new RequestListener(workingPort, httpService).start();

    }

}
