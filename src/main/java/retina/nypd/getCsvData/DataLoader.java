package retina.nypd.getCsvData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import retina.nypd.repositories.Repository;

@Component
public class DataLoader implements ApplicationRunner {

    private final Repository repository;

    @Autowired
    public DataLoader(Repository repository) {
        this.repository = repository;
    }

    public void run(ApplicationArguments args) {
        GetData.getSampleData(repository);
    }
}