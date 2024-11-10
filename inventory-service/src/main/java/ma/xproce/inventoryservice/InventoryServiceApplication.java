package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.repositories.CreatorRepository;
import ma.xproce.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            List<Creator> creators = List.of(
                    Creator.builder().name("x").email("x@gmail.com").build(),
                    Creator.builder().name("y").email("y@gmail.com").build(),
                    Creator.builder().name("z").email("z@gmail.com").build()
            );
            creatorRepository.saveAll(creators);

            List<Video> videos = List.of(
                    Video.builder().name("vEducation").url("vEducation.com").datePublic(new Date())
                            .description("this is an educational video").crt(creators.get(1)).build(),
                    Video.builder().name("vGaming").url("vEGaming.com").datePublic(new Date())
                            .description("this is a Gaming video").crt(creators.get(0)).build(),
                    Video.builder().name("vEntertainment").url("vEntertainment.com").datePublic(new Date())
                            .description("this is an entertainment video").crt(creators.get(2)).build()
            );
            videoRepository.saveAll(videos);
        };
    }
}
