package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    public List<Location> readLocationsFromCSV(String csvFilePath) throws IOException {
        List<Location> locations = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            String[] line;
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {
                // Suponemos que el CSV tiene dos columnas: code y description
                String code = line[0];
                String description = line[1];

                // Crear un nuevo objeto Location y agregarlo a la lista
                //Location location = new Location(code, description);
                //Location location = new Location("1","Manizales");
                //locations.add(location);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return locations;
    }
}
