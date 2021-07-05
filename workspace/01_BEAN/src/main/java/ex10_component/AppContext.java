package ex10_component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="ex10_component")
// @ComponentScan(basePackages={"ex10_component"})
public class AppContext {

}