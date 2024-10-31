package jamme.dev.real.time.transactions.real_time_transactions.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionId;

    private String accountNumber;

    private Double amount;

    private String transactionType;

    private String country;

    private LocalDateTime transactionDate;

}
