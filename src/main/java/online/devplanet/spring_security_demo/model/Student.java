package online.devplanet.spring_security_demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int studentId;
    private  String studentName;
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
