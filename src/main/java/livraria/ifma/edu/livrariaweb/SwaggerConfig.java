package livraria.ifma.edu.livrariaweb;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

  @Bean
  public Docket DetalheApi() {

    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket
            .select()
            .apis(RequestHandlerSelectors.basePackage("livraria.ifma.edu.livrariaweb"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.InformacoesApi().build());

    return docket;
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  private ApiInfoBuilder InformacoesApi() {

    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

    apiInfoBuilder.title("API-DEV-LIVRARIA");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.license("Licença - Open Source");
    apiInfoBuilder.contact(this.Contato());

    return apiInfoBuilder;

  }
  private Contact Contato() {

    return new Contact(
            "Adryano Escorcio",
            "",
            "escorciomax@gmail.com");
  }
}