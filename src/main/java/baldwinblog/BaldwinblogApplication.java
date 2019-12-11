package baldwinblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping(value = "/baldwin")
public class BaldwinblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaldwinblogApplication.class, args);
    }

    @ResponseBody
    @RequestMapping(value = "/hello.action")
    public String helloSB(){
        String helloStr = "Hello SB!!!";
        return helloStr;
    }
}
