package id.puskesmas.backend.repo;

import id.puskesmas.backend.model.KafkaLogTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaLogTableRepository extends JpaRepository<KafkaLogTable,Long> {
}
