package com.example.airlinesafety.Servvice;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.example.airlinesafety.Server.Airline;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service //this tells spring this is a data service, business logic inside
public class DataService {

    private final String URL_DATA = "https://raw.githubusercontent.com/fivethirtyeight/data/master/airline-safety/airline-safety.csv";
    private List<Airline> airlineList = new ArrayList<>();

    public void fetchData() throws IOException, InterruptedException, IOException {

        String airlineName = "";
        int incidents = 0;
        int accidents = 0;
        int fatalities = 0;
        long availSeatKmWeek = 0;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(URL_DATA)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //way to read strings
        StringReader csvReader = new StringReader(response.body());

        Iterable<CSVRecord> iter = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);

        for (CSVRecord record : iter) {
            airlineName = record.get(0);

            //berieme data z 2 a 5 miesta v CSV tabulke
            incidents = Integer.parseInt(record.get(2)) + Integer.parseInt(record.get(5));
            accidents = Integer.parseInt(record.get(3)) + Integer.parseInt(record.get(6));
            fatalities = Integer.parseInt(record.get(4)) + Integer.parseInt(record.get(7));
            availSeatKmWeek = Long.parseLong(record.get(1));

            //inside loop because for every record
            Airline airline = new Airline();
            airline.setAccidents(accidents);
            airline.setFatalities(fatalities);
            airline.setAvailSeatKmWeek(availSeatKmWeek);
            airlineList.add(airline);
        }

    }

    public Object getAirLineList() {
        return this.airlineList;
    }
}
