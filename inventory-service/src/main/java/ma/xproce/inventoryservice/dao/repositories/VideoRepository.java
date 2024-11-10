package ma.xproce.inventoryservice.dao.repositories;

import ma.xproce.inventoryservice.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
}
