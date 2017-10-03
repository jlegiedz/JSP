package sda.springApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


// wyszukuje w com.sda atrybutow javy
// spring ma szukac wszystkich klas ktore majajjedna z adnotacji Component/Service itd
//zeby controller byl widoczny przez springa: musi byc adnotacja Controller plus:
@ComponentScan(basePackages = { "Controller"})
@SpringBootApplication

public class SpringWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringWebApplication.class);
    }

    // uruchomienie aplikacji springowej
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringWebApplication.class, args);
    }



}
