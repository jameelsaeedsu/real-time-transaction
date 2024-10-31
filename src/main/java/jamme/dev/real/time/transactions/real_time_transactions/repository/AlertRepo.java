package jamme.dev.real.time.transactions.real_time_transactions.repository;

import jamme.dev.real.time.transactions.real_time_transactions.model.Alert;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface AlertRepo extends ElasticsearchRepository<Alert, String> {

    List<Alert> findByTransactionId(String transactionId);
}
