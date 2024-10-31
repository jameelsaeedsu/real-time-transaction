package jamme.dev.real.time.transactions.real_time_transactions.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(indexName = "alerts")
public class Alert {

    @Id
    private String id;

    private String transactionId;

    private Double amount;

    private String alertReason;

    private LocalDateTime localDateTime;

}
